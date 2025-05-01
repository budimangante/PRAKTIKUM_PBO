package model;

public class SistemPelaporanKriminal implements SistemPelaporan {
    private String tanggal;
    private String namaOrangYangDilaporkan;
    private String namaPelapor;
    private String lokasiPelanggaran;
    private String buktiPelanggaran;
    private String jenisKejahatan;

    public SistemPelaporanKriminal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setNamaOrangYangDilaporkan(String nama) {
        this.namaOrangYangDilaporkan = nama;
    }

    public void setNamaPelapor(String nama) {
        this.namaPelapor = nama;
    }

    public void setLokasiPelanggaran(String lokasi) {
        this.lokasiPelanggaran = lokasi;
    }

    public void setBuktiPelanggaran(String bukti) {
        this.buktiPelanggaran = bukti;
    }

    public void setJenisKejahatan(String jenis) {
        this.jenisKejahatan = jenis;
    }

    @Override
    public void tampilkanData() {
        System.out.println("Tanggal: " + this.tanggal);
        System.out.println("Nama Orang Yang Dilaporkan: " + this.namaOrangYangDilaporkan);
        System.out.println("Nama Pelapor: " + this.namaPelapor);
        System.out.println("Lokasi Pelanggaran: " + this.lokasiPelanggaran);
        System.out.println("Bukti Pelanggaran: " + this.buktiPelanggaran);
        System.out.println("Jenis Kejahatan: " + this.jenisKejahatan);
    }

}
