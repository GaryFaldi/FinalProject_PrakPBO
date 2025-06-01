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
    private int idUser;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;
    private double totalBayar;

    public Transaksi(int id, String platKendaraan, int idUser, LocalDate tanggalPinjam, LocalDate tanggalKembali, double totalBayar) {
        this.id = id;
        this.platKendaraan = platKendaraan;
        this.idUser = idUser;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.totalBayar = totalBayar;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public String getPlatKendaraan() {
        return platKendaraan;
    }

    public int getIdUser() {
        return idUser;
    }

    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setPlatKendaraan(String PlatKendaraan) {
        this.platKendaraan = platKendaraan;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setTanggalPinjam(LocalDate tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public void setTanggalKembali(LocalDate tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }
}
