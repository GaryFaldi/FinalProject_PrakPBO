/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author GaryFaldi
 */
import model.Mobil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import config.Connector;

public class MobilDAO {
    private Connection conn;

    public MobilDAO() {
        conn = Connector.getConnection();
    }

    public void tambahMobil(Mobil mobil) {
        String sql = "INSERT INTO mobil (plat, tipe, merk, harga_sewa, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, mobil.getPlat());
            stmt.setString(2, mobil.getTipe());
            stmt.setString(3, mobil.getMerk());
            stmt.setDouble(4, mobil.getHargaSewa());
            stmt.setString(5, mobil.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal tambah mobil: " + e.getMessage());
        }
    }
    
    public void HapusMobil(String plat) {
        String sql = "DELETE FROM mobil WHERE plat = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, plat);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal hapus mobil: " + e.getMessage());
        }
    }

    public void updateMobil(Mobil mobil) {
        String sql = "UPDATE mobil SET tipe = ?, merk = ?, harga_sewa = ?, status = ? WHERE plat = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, mobil.getTipe());
            stmt.setString(2, mobil.getMerk());
            stmt.setDouble(3, mobil.getHargaSewa());
            stmt.setString(4, mobil.getStatus());
            stmt.setString(5, mobil.getPlat());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal update mobil: " + e.getMessage());
        }
    }
    
    public List<Mobil> getAllMobil() {
        List<Mobil> list = new ArrayList<>();
        String sql = "SELECT * FROM mobil";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Mobil mobil = new Mobil(
                    rs.getString("plat"),
                    rs.getString("tipe"),
                    rs.getString("merk"),
                    rs.getInt("harga_sewa"),
                    rs.getString("status")
                );
                list.add(mobil);
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil mobil: " + e.getMessage());
        }
        return list;
    }

    public Mobil getMobilById(String plat) {
        String sql = "SELECT * FROM mobil WHERE plat = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, plat);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Mobil(
                        rs.getString("plat"),
                        rs.getString("tipe"),
                        rs.getString("merk"),
                        rs.getInt("harga_sewa"),
                        rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil mobil by ID: " + e.getMessage());
        }
        return null; // Jika tidak ditemukan
    }

}
