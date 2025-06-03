/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author GaryFaldi
 */
import dao.MobilDAO;
import model.Mobil;
import util.Validator;
import javax.swing.JOptionPane;
import java.util.*;
import java.sql.*; 


public class MobilController {

    private MobilDAO mobilDAO;

    public MobilController() {
        mobilDAO = new MobilDAO();
    }

    // Tambah mobil baru
    public void tambahMobil(String plat, String tipe, String merk, String hargaSewaStr, int status) {
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

        Mobil mobil = new Mobil(plat, tipe, merk, (int) hargaSewa, status);
        mobilDAO.tambahMobil(mobil);

        JOptionPane.showMessageDialog(null, "Mobil berhasil ditambahkan!");
    }

    // Ambil semua mobil dari database
    public List<Mobil> getAllMobil() {
        return mobilDAO.getAllMobil();
    }

    public void ubahStatusMobil(String plat, int status) throws SQLException {
        MobilDAO mobilDAO = new MobilDAO();
        mobilDAO.updateStatusMobil(plat, status);
    }
    
    public void updateMobil(String plat, String tipe, String merk, String hargaSewaStr, String statusStr) {
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

        Mobil mobil = new Mobil(plat, tipe, merk, (int) hargaSewa, status);
        mobilDAO.updateMobil(mobil);

        JOptionPane.showMessageDialog(null, "Data mobil berhasil diupdate");
    }

    public void HapusMobil(String plat) {
        if (Validator.isEmpty(plat)) {
            JOptionPane.showMessageDialog(null, "Pilih data mobil yang akan dihapus!");
            return;
        }

        mobilDAO.HapusMobil(plat);

        JOptionPane.showMessageDialog(null, "Data mobil berhasil dihapus!");
    }
    
    private String convertIntToStatus(int status) {
    return status == 0 ? "Tersedia" : "Disewa";
}
    
    public List<Mobil> cariMobil(String keyword) {
    List<Mobil> semuaMobil = getAllMobil();
    List<Mobil> hasilPencarian = new ArrayList<>();
    
    // Konversi keyword ke lowercase untuk pencarian case insensitive
    String lowerKeyword = keyword.toLowerCase();
    
    for (Mobil m : semuaMobil) {
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
