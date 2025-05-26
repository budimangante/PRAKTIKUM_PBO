package model;

import java.util.List;
// CLASS KASIR
public class Kasir extends User {
    private static int totalKasir = 0;

    public Kasir(String username, String password) {
        super(username, password, "kasir");
        totalKasir++;
    }

    public static int getTotalKasir() {
        return totalKasir;
    }

    public void prosesTransaksi(Transaksi transaksi) {
        transaksi.hitungTotal();
        transaksi.cetakNota();
    }

    public Produk cariProduk(List<Produk> produkList, String keyword) {
        return produkList.stream()
                .filter(p -> p.getNamaProduk().toLowerCase().contains(keyword.toLowerCase()) ||
                             p.getIdProduk().equalsIgnoreCase(keyword) ||
                             p.getJenisKain().toLowerCase().contains(keyword.toLowerCase()) ||
                             p.getMotif().toLowerCase().contains(keyword.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public void tampilkanProdukTersedia(List<Produk> produkList) {
        System.out.println("\nPRODUK TERSEDIA:");
        System.out.println("====================================================================================================");
        System.out.printf("%-8s %-20s %-15s %-15s %-8s %-15s%n", 
                "ID", "Nama Produk", "Jenis Kain", "Motif", "Ukuran", "Harga");
        System.out.println("====================================================================================================");
        
        produkList.stream()
            .filter(p -> p.getStok() > 0)
            .forEach(p -> System.out.printf("%-8s %-20s %-15s %-15s %-8s Rp%,12.2f%n",
                    p.getIdProduk(),
                    p.getNamaProduk(),
                    p.getJenisKain(),
                    p.getMotif(),
                    p.getUkuran(),
                    p.getHarga()));
        
        System.out.println("====================================================================================================");
    }
}
