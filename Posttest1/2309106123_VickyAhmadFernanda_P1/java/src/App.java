import model.SistemPelaporan;
import java.util.Scanner;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) {
        ArrayList<SistemPelaporan> dataPelaporan = new ArrayList<SistemPelaporan>();
        Scanner input = new Scanner(System.in);
        int pilihan;
        while (true) {
            try{
                System.out.println("=== Sistem Pelaporan ===");
                System.out.println("1. Tambah Data Pelaporan");
                System.out.println("2. Tampilkan Semua Data Pelaporan");
                System.out.println("3. Update Data Pelaporan");
                System.out.println("4. Hapus Data Pelaporan");
                System.out.println("5. Keluar");
                System.out.print("Pilih Menu: ");
                if (!input.hasNextInt()) {
                    throw new Exception("Inputan Harus Angka");
                }
                pilihan = input.nextInt();
                input.nextLine(); 
                switch (pilihan) {
                    case 1:
                        TambahDataPelaporan(dataPelaporan, input);
                        break;
                    case 2:
                        TampilkanData(dataPelaporan);
                        break;
                    case 3:
                        UpdateDataPelaporan(dataPelaporan, input);
                        break;
                    case 4:
                        HapusDataPelaporan(dataPelaporan, input);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia");
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Terjadi Kesalahan " + e.getMessage());
                   input.nextLine();
            }
        }
    }
    public static void TampilkanData(ArrayList<SistemPelaporan>dataPelaporan){
        System.out.println("\n=== Data Pelaporan ===");
        if (dataPelaporan.isEmpty()){
            System.out.println("Data Kosong");
            return;
        }else{
        for (int i = 0; i < dataPelaporan.size(); i++){
            System.out.println("Data Laporan Ke= " + (i+1));
            dataPelaporan.get(i).TampilkanData();
            System.out.println("=====================================");
            }
        }
    }

    public static void TambahDataPelaporan(ArrayList<SistemPelaporan> dataPelaporan, Scanner input) {
        try {
            System.out.println("\n=== Tambah Data Pelaporan ===");
            System.out.print("Jenis Pelanggaran: ");
            String Jenis_Pelanggaran = input.nextLine();
            System.out.print("Nama Orang Yang Dilaporkan: ");
            String Nama_Orang_Yang_Dilaporkan = input.nextLine();
            System.out.print("Nama Pelapor: ");
            String Nama_Pelapor = input.nextLine();
            System.out.print("Tanggal Pelaporan: ");
            String Tanggal_Pelaporan = input.nextLine();
            System.out.print("Lokasi Pelanggaran: ");
            String Lokasi_Pelanggaran = input.nextLine();
            System.out.print("Bukti Pelanggaran: ");
            String Bukti_Pelanggaran = input.nextLine();

            SistemPelaporan pelaporan = new SistemPelaporan(Jenis_Pelanggaran, Nama_Orang_Yang_Dilaporkan, Nama_Pelapor, Tanggal_Pelaporan, Lokasi_Pelanggaran, Bukti_Pelanggaran);
            dataPelaporan.add(pelaporan);
            System.out.println("Data Berhasil Ditambahkan");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambahkan data: " + e.getMessage());
        }
    }

    public static void UpdateDataPelaporan(ArrayList<SistemPelaporan> dataPelaporan, Scanner input) {
        try {
            System.out.println("\n=== Update Data Pelaporan ===");
            System.out.print("Masukkan Nomor Data Pelaporan: ");

            if (!input.hasNextInt()) {
                System.out.println("Input harus berupa angka.");
                input.next();
                return;
            }

            int nomor = input.nextInt();
            input.nextLine();

            if (nomor < 1 || nomor > dataPelaporan.size()) {
                System.out.println("Data Tidak Ditemukan.");
            } else {
                System.out.print("Jenis Pelanggaran: ");
                String Jenis_Pelanggaran = input.nextLine();
                System.out.print("Nama Orang Yang Dilaporkan: ");
                String Nama_Orang_Yang_Dilaporkan = input.nextLine();
                System.out.print("Nama Pelapor: ");
                String Nama_Pelapor = input.nextLine();
                System.out.print("Tanggal Pelaporan: ");
                String Tanggal_Pelaporan = input.nextLine();
                System.out.print("Lokasi Pelanggaran: ");
                String Lokasi_Pelanggaran = input.nextLine();
                System.out.print("Bukti Pelanggaran: ");
                String Bukti_Pelanggaran = input.nextLine();

                SistemPelaporan pelaporan = new SistemPelaporan(Jenis_Pelanggaran, Nama_Orang_Yang_Dilaporkan, Nama_Pelapor, Tanggal_Pelaporan, Lokasi_Pelanggaran, Bukti_Pelanggaran);
                dataPelaporan.set(nomor - 1, pelaporan);
                System.out.println("Data Berhasil Diupdate");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat mengupdate data: " + e.getMessage());
        }
    }

    public static void HapusDataPelaporan(ArrayList<SistemPelaporan> dataPelaporan, Scanner input) {
        try {
            System.out.println("\n=== Hapus Data Pelaporan ===");
            System.out.print("Masukkan Nomor Data Pelaporan: ");

            if (!input.hasNextInt()) {
                System.out.println("Input harus berupa angka.");
                input.next();
                return;
            }

            int nomor = input.nextInt();
            input.nextLine();

            if (nomor < 1 || nomor > dataPelaporan.size()) {
                System.out.println("Data Tidak Ditemukan.");
            } else {
                dataPelaporan.remove(nomor - 1);
                System.out.println("Data Berhasil Dihapus");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus data: " + e.getMessage());
        }
    }
}