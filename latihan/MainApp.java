package com.ShofaKhafiy.Tugas2dan3.latihan;



/**
 * Kelas MainApp berfungsi sebagai titik masuk (entry point)
 * untuk menjalankan program MoneyManager.
 *
 * @author Shofa
 * @version 1.0
 */
public class MainApp {


    /**
     * Method utama program.
     * Membuat objek {@link MoneyManager} dan menjalankan program.
     *
     * @param args argumen dari command line (tidak digunakan)
     */
    public static void main(String[] args) {
        MoneyManager m = new MoneyManager();
        m.run();
    }
}
