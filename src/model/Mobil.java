/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author GaryFaldi
 */
public class Mobil extends Kendaraan {

    public Mobil(String plat, String tipe, String merk, int hargaSewa, String status) {
        super(plat, tipe, merk, hargaSewa, status);
    }

    @Override
    public String getJenis() {
        return "Mobil";
    }
}