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
