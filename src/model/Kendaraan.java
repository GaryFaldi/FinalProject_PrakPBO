/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author GaryFaldi
 */
public abstract class Kendaraan {
    protected String plat;
    protected String tipe;
    protected String merk;
    protected int hargaSewa;
    protected String status;

    public Kendaraan(String plat, String tipe, String merk, int hargaSewa, String status) {
        this.plat = plat;
        this.tipe = tipe;
        this.merk = merk;
        this.hargaSewa = hargaSewa;
        this.status = status;
    }

    // Getter & Setter
    public String getPlat() {
        return plat;
    }

    public String getTipe() {
        return tipe;
    }

    public String getMerk() {
        return merk;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public String getStatus() {
        return status;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setHargaSewa(int hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Method abstract (boleh di-override oleh anaknya)
    public abstract String getJenis(); // Mobil / Motor
}
