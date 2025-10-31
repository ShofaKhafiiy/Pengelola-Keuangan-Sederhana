package com.ShofaKhafiy.Tugas2dan3.latihan;

/**
 * Kelas Account merepresentasikan rekening dasar
 * yang menyimpan saldo pengguna.
 * <p>
 * Kelas ini digunakan sebagai superclass bagi MoneyManager.
 *
 * @author Shofa
 */
public class Account {
    // semua field public (tidak ada enkapsulasi)
    private double balance = 0;

    /**
     * Mengambil nilai saldo terkini.
     *
     * @return nilai saldo dalam satuan rupiah
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Mengatur nilai saldo terkini.
     *
     * @param balance nilai saldo baru yang ingin diset
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
