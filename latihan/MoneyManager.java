package com.ShofaKhafiy.Tugas2dan3.latihan;

import java.util.ArrayList;
import java.util.Scanner;



/**
 * Kelas MoneyManager digunakan untuk mengelola pemasukan,
 * pengeluaran, dan menampilkan laporan transaksi.
 * <p>
 * Kelas ini mewarisi {@link Account} dan mengimplementasikan {@link Reportable}.
 * Pengguna dapat menambahkan pemasukan, pengeluaran, dan melihat saldo akhir.
 */

public class MoneyManager extends Account implements Reportable {
    public static final int RICH_LIMIT = 1000000;
    public static final int LOW_BALANCE_LIMIT = 50000;
    private ArrayList<String> transactions = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    /**
     * Menjalankan aplikasi Money Manager.
     * Menyediakan menu interaktif bagi pengguna.
     */
    public void run() {
        System.out.println("=== Money Manager ===");
        int choice = 0;
        while (choice != 4) {
            choice = showMenu();

            if (choice == 1) {
                addIncome();
            } else if (choice == 2) {
                addExpense();
            } else if (choice == 3) {
                showTransaction();
            } else if (choice == 4) {
                System.out.println("Keluar dari program...");
            } else {
                System.out.println("Pilihan tidak tersedia!");
            }
        }
        // komentar asal-asalan
        // done.
    }

    /// koment

    /**
     * Menambahkan data pengeluaran.
     * Mengurangi saldo dan menampilkan peringatan jika saldo rendah.
     */
    private void addExpense() {
        System.out.print("Masukkan jumlah pengeluaran: ");
        double expenseAmount = getSc().nextDouble();
        setBalance(getBalance() - expenseAmount);
        if (getBalance() < LOW_BALANCE_LIMIT) { // magic number
            System.out.println("Saldo hampir habis!");
        }
        getTransactions().add("Pengeluaran: -" + expenseAmount);
        printBalance("Transaksi ditambahkan!", "-------------------");
        // duplikasi kode cetak saldo
        System.out.println("Saldo sekarang: " + getBalance());


    }

    /**
     * Menambahkan data pemasukan.
     * Menambah saldo dan menampilkan ucapan jika saldo melampaui batas kaya.
     */
    private void addIncome() {
        System.out.print("Masukkan jumlah pemasukan: ");
        double incomeAmount = getSc().nextDouble();
        setBalance(getBalance() + incomeAmount);
        if (getBalance() > RICH_LIMIT) {
            System.out.println("Kamu kaya!");
        }
        getTransactions().add("Pemasukan: +" + incomeAmount);
        printBalance("Transaksi ditambahkan!", "-------------------");
        // duplikasi kode cetak saldo
        System.out.println("Saldo sekarang: " + getBalance());
    }


    /**
     * Menampilkan menu utama dan menerima pilihan pengguna.
     *
     * @return nomor menu yang dipilih
     */

    private int showMenu() {
        int choice;
        printBalance("\n1. Tambah Pemasukan", "2. Tambah Pengeluaran");
        printBalance("3. Tampilkan Transaksi", "4. Keluar");
        System.out.print("Pilih menu: ");
        choice = getSc().nextInt();
        return choice;
    }

   /* *//**
     * Menyimpan daftar transaksi ke file teks.
     * File akan dibuat di direktori proyek dengan nama "riwayat_transaksi.txt".
     *//*
    private void saveTransactionsToFile() {
        try {
            java.io.FileWriter writer = new java.io.FileWriter("riwayat_transaksi.txt");
            writer.write("=== RIWAYAT TRANSAKSI ===\n");
            for (String t : getTransactions()) {
                writer.write(t + "\n");
            }
            writer.write("-------------------------\n");
            writer.write("Saldo Akhir: " + getBalance() + "\n");
            writer.close();
            System.out.println("✅ Transaksi berhasil disimpan ke file riwayat_transaksi.txt");
        } catch (Exception e) {
            System.out.println("❌ Gagal menyimpan transaksi: " + e.getMessage());
        }
    }*/

    /*public void run() {
    System.out.println("=== Money Manager ===");
    int choice = 0;
    while (choice != 5) {
        System.out.println("\n1. Tambah Pemasukan");
        System.out.println("2. Tambah Pengeluaran");
        System.out.println("3. Tampilkan Transaksi");
        System.out.println("4. Keluar");
        System.out.println("5. Simpan ke File");
        System.out.print("Pilih menu: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1 -> addIncome();
            case 2 -> addExpense();
            case 3 -> showTransaction();
            case 4 -> System.out.println("Keluar dari program...");
            case 5 -> saveTransactionsToFile();
            default -> System.out.println("Pilihan tidak tersedia!");
        }
    }
}
*/



    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<String> transactions) {
        this.transactions = transactions;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
}
