/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author GaryFaldi
 */
import dao.MotorDAO;
import model.Motor;
import util.Validator;
import javax.swing.JOptionPane;
import java.util.*;
import java.sql.*; 

public class MotorController {

    private MotorDAO motorDAO;

    public MotorController() {
        motorDAO = new MotorDAO();
    }

    // Tambah motor baru
    public void tambahMotor(String plat, String tipe, String merk, String hargaSewaStr, int status) {
        if (Validator.isEmpty(plat) || Validator.isEmpty(tipe) || Validator.isEmpty(merk) || 
            Validator.isEmpty(hargaSewaStr)) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return;
        }

        if (!Validator.isValidPlatNomor(plat)) {
            JOptionPane.showMessageDialog(null, "Format plat nomor tidak valid!");
            return;
        }

        if (!Validator.isNumeric(hargaSewaStr)) {
            JOptionPane.showMessageDialog(null, "Harga sewa harus berupa angka!");
            return;
        }

        double hargaSewa = Double.parseDouble(hargaSewaStr);

        Motor motor = new Motor(plat, tipe, merk, (int) hargaSewa, status);
        motorDAO.tambahMotor(motor);

        JOptionPane.showMessageDialog(null, "Motor berhasil ditambahkan!");
    }

    // Ambil semua motor dari database
    public List<Motor> getAllMotor() {
        return motorDAO.getAllMotor();
    }

    public void ubahStatusMotor(String plat, int status) throws SQLException {
        MotorDAO motorDAO = new MotorDAO();
        motorDAO.updateStatusMotor(plat, status);
    }
    
    public void updateMotor(String plat, String tipe, String merk, String hargaSewaStr, String statusStr) {
        if (Validator.isEmpty(plat) || Validator.isEmpty(tipe) || Validator.isEmpty(merk) || 
            Validator.isEmpty(hargaSewaStr) || Validator.isEmpty(statusStr)) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return;
        }

        if (!Validator.isGeneralText(tipe) || !Validator.isGeneralText(merk)) {
            JOptionPane.showMessageDialog(null, "Tipe dan Merk hanya boleh mengandung huruf, angka, dan spasi!");
            return;
        }

        if (!Validator.isNumeric(hargaSewaStr)) {
            JOptionPane.showMessageDialog(null, "Harga sewa harus berupa angka!");
            return;
        }
        if (!statusStr.equals("0") && !statusStr.equals("1")) {
            JOptionPane.showMessageDialog(null, "Status tidak valid!");
            return;
        }

        double hargaSewa = Double.parseDouble(hargaSewaStr);
        int status = Integer.parseInt(statusStr);

        Motor motor = new Motor(plat, tipe, merk, (int) hargaSewa, status);
        motorDAO.updateMotor(motor);

        JOptionPane.showMessageDialog(null, "Data motor berhasil diupdate");
    }

    public void hapusMotor(String plat) {
        if (Validator.isEmpty(plat)) {
            JOptionPane.showMessageDialog(null, "Pilih data motor yang akan dihapus!");
            return;
        }

        motorDAO.hapusMotor(plat);

        JOptionPane.showMessageDialog(null, "Data motor berhasil dihapus!");
    }
    
    private String convertIntToStatus(int status) {
        return status == 0 ? "Tersedia" : "Disewa";
    }
    
    public List<Motor> cariMotor(String keyword) {
        List<Motor> semuaMotor = getAllMotor();
        List<Motor> hasilPencarian = new ArrayList<>();
        
        // Konversi keyword ke lowercase untuk pencarian case insensitive
        String lowerKeyword = keyword.toLowerCase();
        
        for (Motor m : semuaMotor) {
            // Cek apakah keyword cocok dengan tipe, merk, atau status
            if (m.getTipe().toLowerCase().contains(lowerKeyword) ||
                m.getMerk().toLowerCase().contains(lowerKeyword) ||
                convertIntToStatus(m.getStatus()).toLowerCase().contains(lowerKeyword)) {
                hasilPencarian.add(m);
            }
        }
        
        return hasilPencarian;
    }
}