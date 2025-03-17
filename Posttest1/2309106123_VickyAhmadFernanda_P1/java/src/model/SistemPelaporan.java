package model;
public class SistemPelaporan{
    private String Jenis_Pelanggaran;
    private String Nama_Orang_Yang_Dilaporkan;
    private String Nama_Pelapor;
    private String Tanggal_Pelaporan;
    private String Lokasi_Pelanggaran;
    private String Bukti_Pelanggaran;
    

    public SistemPelaporan(String Jenis_Pelanggaran, String Nama_Orang_Yang_Dilaporkan, String Nama_Pelapor, String Tanggal_Pelaporan, String Lokasi_Pelanggaran, String Bukti_Pelanggaran){
        this.Jenis_Pelanggaran = Jenis_Pelanggaran;
        this.Nama_Orang_Yang_Dilaporkan = Nama_Orang_Yang_Dilaporkan;
        this.Nama_Pelapor = Nama_Pelapor;
        this.Tanggal_Pelaporan = Tanggal_Pelaporan;
        this.Lokasi_Pelanggaran = Lokasi_Pelanggaran;
        this.Bukti_Pelanggaran = Bukti_Pelanggaran;
    }
    public void TampilkanData(){
        System.out.println("Jenis Pelanggaran: " + this.Jenis_Pelanggaran);
        System.out.println("Nama Orang Yang Dilaporkan: " + this.Nama_Orang_Yang_Dilaporkan);
        System.out.println("Nama Pelapor: " + this.Nama_Pelapor);
        System.out.println("Tanggal Pelaporan: " + this.Tanggal_Pelaporan);
        System.out.println("Lokasi_Pelanggaran: " + this.Lokasi_Pelanggaran);
        System.out.println("Bukti Pelanggaran: " + this.Bukti_Pelanggaran);
    }
}