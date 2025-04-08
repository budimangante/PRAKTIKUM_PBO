package model;

public class SistemPelaporan {
    private String Nama_Orang_Yang_Dilaporkan;
    private String Nama_Pelapor;
    private String Tanggal_Pelaporan;
    private String Lokasi_Pelanggaran;
    protected String Bukti_Pelanggaran;
    protected String Jenis_Pelanggaran;

    public String getNama_Orang_Yang_Dilaporkan() {
        return Nama_Orang_Yang_Dilaporkan;
    }

    public String getNama_Pelapor() {
        return Nama_Pelapor;
    }

    public String getTanggal_Pelaporan() {
        return Tanggal_Pelaporan;
    }

    public String getLokasi_Pelanggaran() {
        return Lokasi_Pelanggaran;
    }

    public String getBukti_Pelanggaran() {
        return Bukti_Pelanggaran;
    }

    public String getJenis_Pelanggaran() {
        return Jenis_Pelanggaran;
    }

    public void setNama_Orang_Yang_Dilaporkan(String Nama_Orang_Yang_Dilaporkan) {
        this.Nama_Orang_Yang_Dilaporkan = Nama_Orang_Yang_Dilaporkan;
    }

    public void setNama_Pelapor(String Nama_Pelapor) {
        this.Nama_Pelapor = Nama_Pelapor;
    }

    public void setTanggal_Pelaporan(String Tanggal_Pelaporan) {
        this.Tanggal_Pelaporan = Tanggal_Pelaporan;
    }

    public void setLokasi_Pelanggaran(String Lokasi_Pelanggaran) {
        this.Lokasi_Pelanggaran = Lokasi_Pelanggaran;
    }

    public void setBukti_Pelanggaran(String Bukti_Pelanggaran) {
        this.Bukti_Pelanggaran = Bukti_Pelanggaran;
    }

    public void setJenis_Pelanggaran(String Jenis_Pelanggaran) {
        this.Jenis_Pelanggaran = Jenis_Pelanggaran;
    }

    public void TampilkanData() {
        System.out.println("Jenis Pelanggaran: " + getJenis_Pelanggaran());
        System.out.println("Nama Orang Yang Dilaporkan: " + getNama_Orang_Yang_Dilaporkan());
        System.out.println("Nama Pelapor: " + getNama_Pelapor());
        System.out.println("Tanggal Pelaporan: " + getTanggal_Pelaporan());
        System.out.println("Lokasi Pelanggaran: " + getLokasi_Pelanggaran());
        System.out.println("Bukti Pelanggaran: " + Bukti_Pelanggaran);
    }
}
