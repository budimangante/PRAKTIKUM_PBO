package model;
public abstract class SistemPelaporan {
    private final String tanggalPelaporan;
    private String namaOrangYangDilaporkan;
    private String namaPelapor;
    private String lokasiPelanggaran;
    private String buktiPelanggaran;

    public SistemPelaporan(final String tanggalPelaporan) {
        this.tanggalPelaporan = tanggalPelaporan;
    }

    public String getTanggalPelaporan() {
        return tanggalPelaporan;
    }

    public String getNamaOrangYangDilaporkan() {
        return namaOrangYangDilaporkan;
    }

    public void setNamaOrangYangDilaporkan(String namaOrangYangDilaporkan) {
        this.namaOrangYangDilaporkan = namaOrangYangDilaporkan;
    }

    public String getNamaPelapor() {
        return namaPelapor;
    }

    public void setNamaPelapor(String namaPelapor) {
        this.namaPelapor = namaPelapor;
    }

    public String getLokasiPelanggaran() {
        return lokasiPelanggaran;
    }

    public void setLokasiPelanggaran(String lokasiPelanggaran) {
        this.lokasiPelanggaran = lokasiPelanggaran;
    }

    public String getBuktiPelanggaran() {
        return buktiPelanggaran;
    }

    public void setBuktiPelanggaran(String buktiPelanggaran) {
        this.buktiPelanggaran = buktiPelanggaran;
    }

    public void tampilkanData() {
        System.out.println("Tanggal Pelaporan: " + tanggalPelaporan);
        System.out.println("Nama Orang Yang Dilaporkan: " + namaOrangYangDilaporkan);
        System.out.println("Nama Pelapor: " + namaPelapor);
        System.out.println("Lokasi Pelanggaran: " + lokasiPelanggaran);
        System.out.println("Bukti Pelanggaran: " + buktiPelanggaran);
    }
}