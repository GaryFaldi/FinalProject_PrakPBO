/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author GaryFaldi
 */
import config.Connector;
import model.Transaksi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiDAO {
    private Connection conn;

    public TransaksiDAO() {
        conn = Connector.getConnection();
    }

    public void insertTransaksi(Transaksi transaksi) {
        String sql = "INSERT INTO transaksi (platKendaraan, namaPenyewa, tanggalPenyewaan, tanggalPengembalian, totalBayar) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, transaksi.getPlatKendaraan());
            stmt.setString(2, transaksi.getNamaPenyewa()); // pastikan ada setter dan getter id_user
            stmt.setDate(3, java.sql.Date.valueOf(transaksi.getTanggalPenyewaan())); // LocalDate
            stmt.setDate(4, java.sql.Date.valueOf(transaksi.getTanggalPengembalian()));
            stmt.setDouble(5, transaksi.getTotalBayar());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Mengambil semua transaksi
    public List<Transaksi> getAllTransaksi() {
        List<Transaksi> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Transaksi transaksi = new Transaksi(
                    rs.getInt("id"),
                    rs.getString("platKendaraan"),
                    rs.getString("namaPenyewa"),
                    rs.getDate("tanggalPenyewaan").toLocalDate(),
                    rs.getDate("tanggalPengembalian").toLocalDate(),
                    rs.getDouble("totalBayar")
                );
                list.add(transaksi);
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil transaksi: " + e.getMessage());
        }
        return list;
    }

    // Mengambil transaksi berdasarkan ID
    public Transaksi getTransaksiById(int id) {
        String sql = "SELECT * FROM transaksi WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Transaksi(
                        rs.getInt("id"),
                        rs.getString("platKendaraan"),
                        rs.getString("id_user"),
                        rs.getDate("tanggalPenyewaan").toLocalDate(),
                        rs.getDate("tanggalPengembalian").toLocalDate(),
                        rs.getDouble("totalBayar")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil transaksi by ID: " + e.getMessage());
        }
        return null;
    }
}