package com.ShofaKhafiy.Tugas2dan3.latihan;

import java.util.ArrayList;

/**
 * Interface Reportable mendefinisikan perilaku dasar
 * untuk menampilkan transaksi dan saldo.
 * Kelas yang mengimplementasikan interface ini harus
 * menyediakan method untuk mengakses saldo dan daftar transaksi.
 */

public interface Reportable {

    /**
     * Mengambil nilai saldo terkini.
     *
     * @return saldo pengguna
     */

    double getBalance();

    /**
     * Mengambil daftar seluruh transaksi.
     *
     * @return daftar transaksi dalam bentuk ArrayList
     */
    ArrayList<String> getTransactions();

    /**
     * Menampilkan daftar transaksi secara default.
     * Menampilkan nomor urut, deskripsi transaksi, dan saldo akhir.
     */
    default void showTransaction() {
        System.out.println("\n=== Daftar Transaksi ===");
        for (int i = 0; i < getTransactions().size(); i++) {
            System.out.println((i + 1) + ". " + getTransactions().get(i));
        }
        printBalance("Total saldo akhir: " + getBalance(), "-------------------");
    }

    /**
     * Mencetak informasi saldo atau teks lain dengan format dua baris.
     *
     * @param x  baris pertama yang ingin dicetak
     * @param x1 baris kedua yang ingin dicetak
     */
    default void printBalance(String x, String x1) {
        System.out.println(x);
        System.out.println(x1);
    }
}
