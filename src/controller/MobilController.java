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
import java.util.List;

public class MobilController {

    private MobilDAO mobilDAO;

    public MobilController() {
        mobilDAO = new MobilDAO();
    }

    // Tambah mobil baru
    public void tambahMobil(String plat, String tipe, String merk, String hargaSewaStr, String status) {
        if (Validator.isEmpty(plat) || Validator.isEmpty(tipe) || Validator.isEmpty(merk) || 
            Validator.isEmpty(hargaSewaStr) || Validator.isEmpty(status)) {
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

    // Nanti bisa ditambahkan update dan delete jika DAO-nya sudah tersedia
}
