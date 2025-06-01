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

    // Menambahkan transaksi baru
    public void tambahTransaksi(Transaksi transaksi) {
        String sql = "INSERT INTO transaksi (plat_kendaraan, id_user, tanggal_pinjam, tanggal_kembali, total_bayar) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, transaksi.getPlatKendaraan());
            stmt.setInt(2, transaksi.getIdUser());
            stmt.setDate(3, Date.valueOf(transaksi.getTanggalPinjam()));
            stmt.setDate(4, Date.valueOf(transaksi.getTanggalKembali()));
            stmt.setDouble(5, transaksi.getTotalBayar());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal tambah transaksi: " + e.getMessage());
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
                    rs.getString("plat_kendaraan"),
                    rs.getInt("id_user"),
                    rs.getDate("tanggal_pinjam").toLocalDate(),
                    rs.getDate("tanggal_kembali").toLocalDate(),
                    rs.getDouble("total_bayar")
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
                        rs.getString("plat_kendaraan"),
                        rs.getInt("id_user"),
                        rs.getDate("tanggal_pinjam").toLocalDate(),
                        rs.getDate("tanggal_kembali").toLocalDate(),
                        rs.getDouble("total_bayar")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil transaksi by ID: " + e.getMessage());
        }
        return null;
    }
}