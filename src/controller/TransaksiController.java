/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author GaryFaldi
 */
import dao.TransaksiDAO;
import model.Transaksi;
import util.Validator;
import java.time.LocalDate;

public class TransaksiController {
    private TransaksiDAO transaksiDAO;

    public TransaksiController() {
        transaksiDAO = new TransaksiDAO(); // pastikan DAO-nya siap
    }

        public void simpanTransaksi(String plat, String namaPenyewa, LocalDate tanggalPenyewaan, LocalDate tanggalPengembalian, int totalBayar) {
            Transaksi transaksi = new Transaksi(0, plat, namaPenyewa, tanggalPenyewaan, tanggalPengembalian, totalBayar);
            transaksi.setPlatKendaraan(plat);
            transaksi.setNamaPenyewa(namaPenyewa);

            transaksi.setTanggalPenyewaan(tanggalPenyewaan);
            transaksi.setTanggalPengembalian(tanggalPengembalian);


            transaksi.setTotalBayar(totalBayar);

            transaksiDAO.insertTransaksi(transaksi);
        }

}
