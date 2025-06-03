/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author GaryFaldi
 */
import java.time.LocalDate;

public class Transaksi {
    private int id;
    private String platKendaraan;
    private String namaPenyewa;
    private LocalDate tanggalPenyewaan;
    private LocalDate tanggalPengembalian;
    private double totalBayar;

    public Transaksi(int id, String platKendaraan, String namaPenyewa, LocalDate tanggalPenyewaan, LocalDate tanggalPengembalian, double totalBayar) {
        this.id = id;
        this.platKendaraan = platKendaraan;
        this.namaPenyewa = namaPenyewa;
        this.tanggalPenyewaan = tanggalPenyewaan;
        this.tanggalPengembalian = tanggalPengembalian;
        this.totalBayar = totalBayar;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public String getPlatKendaraan() {
        return platKendaraan;
    }

    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public LocalDate getTanggalPenyewaan() {
        return tanggalPenyewaan;
    }

    public LocalDate getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setPlatKendaraan(String PlatKendaraan) {
        this.platKendaraan = platKendaraan;
    }

    public void setNamaPenyewa(String namaPenyewa) {
        this.namaPenyewa = namaPenyewa;
    }

    public void setTanggalPenyewaan(LocalDate tanggalPenyewaan) {
        this.tanggalPenyewaan = tanggalPenyewaan;
    }

    public void setTanggalPengembalian(LocalDate tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }
}
