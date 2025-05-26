package model;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaksi {
    private final String idTransaksi;
    private final List<Produk> daftarProduk;
    private double totalBayar;
    private final Date tanggalTransaksi;
    private final Pelanggan pelanggan;

    public Transaksi(String idTransaksi, Pelanggan pelanggan) {
        if (idTransaksi == null || idTransaksi.trim().isEmpty()) {
            throw new IllegalArgumentException("ID Transaksi tidak boleh kosong");
        }
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.daftarProduk = new ArrayList<>();
        this.tanggalTransaksi = new Date();
    }

    public void tambahProduk(Produk produk) {
        if (produk == null) {
            throw new IllegalArgumentException("Produk tidak boleh null");
        }
        daftarProduk.add(produk);
    }

    public void hitungTotal() {
        totalBayar = daftarProduk.stream()
                         .mapToDouble(Produk::getHarga)
                         .sum();
    }

    public void cetakNota() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
        System.out.println("\n==================================================");
        System.out.println("                NOTA TRANSAKSI BATIK              ");
        System.out.println("==================================================");
        System.out.println("ID Transaksi : " + idTransaksi);
        System.out.println("Tanggal      : " + sdf.format(tanggalTransaksi));
        System.out.println("--------------------------------------------------");
        System.out.println("DATA PELANGGAN:");
        pelanggan.tampilkanInfo();
        
        System.out.println("\nDaftar Produk:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-3s %-20s %15s%n", "No", "Nama Produk", "Harga");
        System.out.println("--------------------------------------------------");
        
        int counter = 1;
        for (Produk p : daftarProduk) {
            System.out.printf("%-3d %-20s Rp%,12.2f%n", counter++, p.getNamaProduk(), p.getHarga());
        }
        
        System.out.println("--------------------------------------------------");
        System.out.printf("%-23s Rp%,12.2f%n", "TOTAL BAYAR:", totalBayar);
        System.out.println("==================================================\n");
    }

    // GETTER
    public String getIdTransaksi() { return idTransaksi; }
    public List<Produk> getDaftarProduk() { return daftarProduk; }
    public double getTotalBayar() { return totalBayar; }
    public Date getTanggalTransaksi() { return tanggalTransaksi; }
    public Pelanggan getPelanggan() { return pelanggan; }
}