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
        String sql = "INSERT INTO motor (plat, tipe, merk, harga_sewa, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, motor.getPlat());
            stmt.setString(2, motor.getTipe());
            stmt.setString(3, motor.getMerk());
            stmt.setDouble(4, motor.getHargaSewa());
            stmt.setString(5, motor.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal tambah motor: " + e.getMessage());
        }
    }
    
    public void HapusMotor(String plat) {
        String sql = "DELETE FROM motor WHERE plat = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, plat);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal hapus motor: " + e.getMessage());
        }
    }

    public void updateMotor(Motor motor) {
        String sql = "UPDATE motor SET tipe = ?, merk = ?, harga_sewa = ?, status = ? WHERE plat = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, motor.getTipe());
            stmt.setString(2, motor.getMerk());
            stmt.setDouble(3, motor.getHargaSewa());
            stmt.setString(4, motor.getStatus());
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
                    rs.getInt("harga_sewa"),
                    rs.getString("status")
                );
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
                        rs.getInt("harga_sewa"),
                        rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil motor by ID: " + e.getMessage());
        }
        return null; // Jika tidak ditemukan
    }

}
