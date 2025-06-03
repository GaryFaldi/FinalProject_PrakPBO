/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author GaryFaldi
 */
public class Mobil {
    protected String plat;
    protected String tipe;
    protected String merk;
    protected int hargaSewa;
    protected int status;
    
    public Mobil(String plat, String tipe, String merk, int hargaSewa, int status) {
        this.plat = plat;
        this.tipe = tipe;
        this.merk = merk;
        this.hargaSewa = hargaSewa;
        this.status = status;    }

    public String getJenis() {
        return "Mobil";
    }
    public String getPlat() {
        return plat;
    }

    public String getTipe() {
        return tipe;
    }

    public String getMerk() {
        return merk;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }

    public int getStatus() {
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

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String toString() {
        return tipe;  // atau bisa juga return plat + " - " + merk + " - " + tipe;
    }
}