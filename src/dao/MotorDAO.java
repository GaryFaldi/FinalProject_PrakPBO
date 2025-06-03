/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author GaryFaldi
 */
import model.Motor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import config.Connector;

public class MotorDAO {
    private Connection conn;

    public MotorDAO() {
        conn = Connector.getConnection();
    }

    public void tambahMotor(Motor motor) {
        String sql = "INSERT INTO motor (plat, tipe, merk, hargaSewa, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, motor.getPlat());
            stmt.setString(2, motor.getTipe());
            stmt.setString(3, motor.getMerk());
            stmt.setDouble(4, motor.getHargaSewa());
            stmt.setInt(5, motor.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal tambah motor: " + e.getMessage());
        }
    }
    
    public void hapusMotor(String plat) {
        String sql = "DELETE FROM motor WHERE plat = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, plat);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal hapus motor: " + e.getMessage());
        }
    }

    public void updateMotor(Motor motor) {
        String sql = "UPDATE motor SET tipe = ?, merk = ?, hargaSewa = ?, status = ? WHERE plat = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, motor.getTipe());
            stmt.setString(2, motor.getMerk());
            stmt.setDouble(3, motor.getHargaSewa());
            stmt.setInt(4, motor.getStatus());
            stmt.setString(5, motor.getPlat());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal update motor: " + e.getMessage());
        }
    }
    
    public List<Motor> getAllMotor() {
        List<Motor> list = new ArrayList<>();
        String sql = "SELECT * FROM motor";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Motor motor = new Motor(
                    rs.getString("plat"),
                    rs.getString("tipe"),
                    rs.getString("merk"),
                    rs.getInt("hargaSewa"),
                    rs.getInt("status")
                );
                System.out.println("Data dari DB: " + motor.getTipe());
                list.add(motor);
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil motor: " + e.getMessage());
        }
        return list;
    }

    public Motor getMotorById(String plat) {
        String sql = "SELECT * FROM motor WHERE plat = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, plat);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Motor(
                        rs.getString("plat"),
                        rs.getString("tipe"),
                        rs.getString("merk"),
                        rs.getInt("hargaSewa"),
                        rs.getInt("status")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil motor by ID: " + e.getMessage());
        }
        return null;
    }
    
    public int cekStatusMotor(String plat) {
        int status = 0;
        String sql = "SELECT status FROM motor WHERE plat = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, plat);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status = rs.getInt("status");
            }
        } catch (SQLException e) {
            System.err.println("Gagal cek status motor: " + e.getMessage());
        }

        return status;
    }

    public void updateStatusMotor(String plat, int status) throws SQLException {
        String query = "UPDATE motor SET status = ? WHERE plat = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, status);
        stmt.setString(2, plat);
        stmt.executeUpdate();
        stmt.close();
    }
}