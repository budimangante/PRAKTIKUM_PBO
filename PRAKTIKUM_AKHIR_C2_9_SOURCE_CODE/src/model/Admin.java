package model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Admin extends User implements Laporan {
    private static int totalAdmin = 0;
    private final List<Produk> produkList;
    private final List<Transaksi> historiTransaksi;


    public Admin(String username, String password) {
        super(username, password, "admin");
        this.produkList = new ArrayList<>();
        this.historiTransaksi = new ArrayList<>();
        totalAdmin++;
    }

    public static int getTotalAdmin() {
        return totalAdmin;
    }

    public void tambahProduk(Produk produk) {
        if (produk == null) {
            throw new IllegalArgumentException("Produk tidak boleh null");
        }
        produkList.add(produk);
        System.out.println("Produk berhasil ditambahkan!");
    }

    public void editProduk(String idProduk, Scanner scanner) {
        Produk produk = cariProdukById(idProduk);
        if (produk == null) {
            System.out.println("Produk dengan ID " + idProduk + " tidak ditemukan");
            return;
        }

        System.out.println("\nEDIT PRODUK:");
        produk.tampilkanInfo();
        System.out.println("\nMasukkan data baru (kosongkan jika tidak ingin mengubah):");

        try {
            System.out.print("Nama Produk [" + produk.getNamaProduk() + "]: ");
            String nama = scanner.nextLine();
            if (!nama.isEmpty()) produk.setNamaProduk(nama);

            System.out.print("Jenis Kain [" + produk.getJenisKain() + "]: ");
            String jenis = scanner.nextLine();
            if (!jenis.isEmpty()) produk.setJenisKain(jenis);

            System.out.print("Motif [" + produk.getMotif() + "]: ");
            String motif = scanner.nextLine();
            if (!motif.isEmpty()) produk.setMotif(motif);

            System.out.print("Ukuran [" + produk.getUkuran() + "]: ");
            String ukuran = scanner.nextLine();
            if (!ukuran.isEmpty()) produk.setUkuran(ukuran);

            System.out.print("Harga [" + produk.getHarga() + "]: ");
            String hargaStr = scanner.nextLine();
            if (!hargaStr.isEmpty()) produk.setHarga(Double.parseDouble(hargaStr));

            System.out.print("Stok [" + produk.getStok() + "]: ");
            String stokStr = scanner.nextLine();
            if (!stokStr.isEmpty()) produk.setStok(Integer.parseInt(stokStr));

            System.out.println("Produk berhasil diupdate!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void hapusProduk(String idProduk) {
        if (produkList.removeIf(p -> p.getIdProduk().equals(idProduk))) {
            System.out.println("Produk berhasil dihapus!");
        } else {
            System.out.println("Produk dengan ID " + idProduk + " tidak ditemukan");
        }
    }

    public Produk cariProdukById(String idProduk) {
        return produkList.stream()
                .filter(p -> p.getIdProduk().equals(idProduk))
                .findFirst()
                .orElse(null);
    }

    public void tampilkanSemuaProduk() {
        if (produkList.isEmpty()) {
            System.out.println("Belum ada produk yang terdaftar");
            return;
        }

        System.out.println("\nDAFTAR PRODUK BATIK:");
        System.out.println("====================================================================================================");
        System.out.printf("%-8s %-20s %-15s %-15s %-8s %-15s %-5s%n", 
                "ID", "Nama Produk", "Jenis Kain", "Motif", "Ukuran", "Harga", "Stok");
        System.out.println("====================================================================================================");
        
        produkList.forEach(Produk::tampilkanInfo);
        
        System.out.println("====================================================================================================");
        System.out.println("Total Produk: " + produkList.size());
    }

    public void simpanTransaksi(Transaksi transaksi) {
        historiTransaksi.add(transaksi);
    }

    @Override
    public void lihatLaporan() {
        if (historiTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi yang tercatat");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        Date awalMinggu = cal.getTime();
        cal.add(Calendar.DATE, 6);
        Date akhirMinggu = cal.getTime();

        System.out.println("\n=== LAPORAN PENJUALAN MINGGUAN ===");
        System.out.printf("Periode: %s - %s%n%n", 
                sdf.format(awalMinggu), sdf.format(akhirMinggu));
        
        System.out.printf("%-12s %-20s %-15s %-15s %-10s %-15s%n", 
                "Tanggal", "ID Transaksi", "Nama Produk", "Jenis Kain", "Harga", "Pelanggan");
        System.out.println("====================================================================================================");

        List<Transaksi> transaksiMingguIni = historiTransaksi.stream()
            .filter(t -> !t.getTanggalTransaksi().before(awalMinggu) && 
                         !t.getTanggalTransaksi().after(akhirMinggu))
            .collect(Collectors.toList());

        if (transaksiMingguIni.isEmpty()) {
            System.out.println("Tidak ada transaksi pada minggu ini");
            return;
        }

        for (Transaksi t : transaksiMingguIni) {
            for (Produk p : t.getDaftarProduk()) {
                System.out.printf("%-12s %-20s %-15s %-15s Rp%,10.2f %-15s%n",
                        sdf.format(t.getTanggalTransaksi()),
                        t.getIdTransaksi(),
                        p.getNamaProduk(),
                        p.getJenisKain(),
                        p.getHarga(),
                        t.getPelanggan().getNama());
            }
        }
        
        double totalMingguan = transaksiMingguIni.stream()
            .flatMap(t -> t.getDaftarProduk().stream())
            .mapToDouble(Produk::getHarga)
            .sum();
            
        System.out.println("====================================================================================================");
        System.out.printf("%80sRp%,12.2f%n", "TOTAL PENJUALAN: ", totalMingguan);
    }

    public List<Produk> getProdukList() {
        return produkList;
    }
    
    private List<Pelanggan> pelangganList = new ArrayList<>();

    public void tambahPelanggan(Pelanggan p) {
        pelangganList.add(p);
    }

    public List<Pelanggan> getPelangganList() {
        return pelangganList;
    }


    public List<Transaksi> getHistoriTransaksi() {
        return historiTransaksi;
    }
}
