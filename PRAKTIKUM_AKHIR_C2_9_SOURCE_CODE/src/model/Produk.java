package model;
public class Produk {
    private final String idProduk;
    private String namaProduk;
    private String jenisKain;
    private String motif;
    private String ukuran;
    private double harga;
    private int stok;

    public Produk(String idProduk, String namaProduk, String jenisKain, String motif, String ukuran, double harga, int stok) {
        if (idProduk == null || idProduk.trim().isEmpty()) {
            throw new IllegalArgumentException("ID Produk tidak boleh kosong");
        }
        this.idProduk = idProduk;
        setNamaProduk(namaProduk);
        setJenisKain(jenisKain);
        setMotif(motif);
        setUkuran(ukuran);
        setHarga(harga);
        setStok(stok);
    }

    public void tambahStok(int jumlah) throws IllegalArgumentException {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah harus lebih dari 0");
        }
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) throws Exception {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah harus lebih dari 0");
        }
        if (jumlah > stok) {
            throw new Exception("Stok tidak mencukupi! Stok tersedia: " + stok);
        }
        this.stok -= jumlah;
    }

    public void tampilkanInfo() {
        System.out.printf("%s | %-20s | %-10s | %-15s | %-5s | Rp%,10.2f | %3d%n",
                idProduk, namaProduk, jenisKain, motif, ukuran, harga, stok);
    }

    public String getIdProduk() { return idProduk; }

    public String getNamaProduk() { return namaProduk; }
    public void setNamaProduk(String namaProduk) {
        if (namaProduk == null || namaProduk.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong");
        }
        this.namaProduk = namaProduk;
    }

    public String getJenisKain() { return jenisKain; }
    public void setJenisKain(String jenisKain) {
        if (jenisKain == null || jenisKain.trim().isEmpty()) {
            throw new IllegalArgumentException("Jenis kain tidak boleh kosong");
        }
        this.jenisKain = jenisKain;
    }

    public String getMotif() { return motif; }
    public void setMotif(String motif) {
        if (motif == null || motif.trim().isEmpty()) {
            throw new IllegalArgumentException("Motif tidak boleh kosong");
        }
        this.motif = motif;
    }

    public String getUkuran() { return ukuran; }
    public void setUkuran(String ukuran) {
        if (ukuran == null || ukuran.trim().isEmpty()) {
            throw new IllegalArgumentException("Ukuran tidak boleh kosong");
        }
        this.ukuran = ukuran;
    }

    public double getHarga() { return harga; }
    public void setHarga(double harga) {
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari 0");
        }
        this.harga = harga;
    }

    public int getStok() { return stok; }
    public void setStok(int stok) {
        if (stok < 0) {
            throw new IllegalArgumentException("Stok tidak boleh negatif");
        }
        this.stok = stok;
    }
}