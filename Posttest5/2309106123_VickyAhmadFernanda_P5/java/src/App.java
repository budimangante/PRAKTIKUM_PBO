
import java.util.Scanner;
import java.util.ArrayList;
import model.SistemPelaporan;
import model.SistemPelaporanKriminal;
import model.SistemPelaporanSosial;
public final class App {
    public static void main(String[] args) {
        ArrayList<SistemPelaporanKriminal> DaftarKriminal = new ArrayList<SistemPelaporanKriminal>();
        ArrayList<SistemPelaporanSosial> DaftarSosial = new ArrayList<SistemPelaporanSosial>();
        Scanner input = new Scanner(System.in);
        int pilihan;
        while (true) {
            try{
                System.out.println("=== Sistem Pelaporan ===");
                System.out.println("1. Tambah Data Pelaporan Kriminal");
                System.out.println("2. Tambah Data Pelaporan Sosial");
                System.out.println("3. Tampilkan Semua Data Pelaporan");
                System.out.println("4. Update Data Pelaporan");
                System.out.println("5. Hapus Data Pelaporan");
                System.out.println("6. Keluar");
                System.out.print("Pilih Menu: ");
                if (!input.hasNextInt()) {
                    throw new Exception("Inputan Harus Angka");
                }
                pilihan = input.nextInt();
                input.nextLine(); 
                switch (pilihan) {
                    case 1:
                        tambahDataPelaporanKriminal(DaftarKriminal, input);
                        break;
                    case 2:
                        tambahDataPelaporanSosial(DaftarSosial, input);
                        break;
                    case 3:
                        tampilkanData(DaftarKriminal, DaftarSosial, input);
                        break;
                    case 4:
                        updateDataPelaporan(DaftarKriminal, DaftarSosial, input);
                        break;
                    case 5:
                        hapusDataPelaporan(DaftarKriminal, DaftarSosial, input);
                        break;
                    case 6:
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

    private static void tampilkanData(ArrayList<SistemPelaporanKriminal> DaftarKriminal, ArrayList<SistemPelaporanSosial> DaftarSosial, Scanner input) {
        System.out.println("\n=== Tampilkan Semua Data Pelaporan ===");
        ArrayList<SistemPelaporan> dataPelaporan = new ArrayList<SistemPelaporan>();
        dataPelaporan.addAll(DaftarKriminal);
        dataPelaporan.addAll(DaftarSosial);
        if (dataPelaporan.isEmpty()) {
            System.out.println("Data Kosong.");
            return;
        }

        for (int i = 0; i < dataPelaporan.size(); i++) {
            System.out.println("\nData Laporan Ke-" + (i + 1));
            dataPelaporan.get(i).tampilkanData();
            System.out.println("-----------------------------------");
        }
    }

    private static void tambahDataPelaporanKriminal(ArrayList<SistemPelaporanKriminal> DaftarKriminal, Scanner input) {
        System.out.println("\n=== Tambah Data Pelaporan Kriminal ===");
        System.out.print("Tanggal Pelaporan: ");
        String tanggal = input.nextLine();
        SistemPelaporanKriminal pelaporan = new SistemPelaporanKriminal(tanggal);

        System.out.print("Nama Orang Yang Dilaporkan: ");
        pelaporan.setNamaOrangYangDilaporkan(input.nextLine());
        System.out.print("Nama Pelapor: ");
        pelaporan.setNamaPelapor(input.nextLine());
        System.out.print("Lokasi Pelanggaran: ");
        pelaporan.setLokasiPelanggaran(input.nextLine());
        System.out.print("Bukti Pelanggaran: ");
        pelaporan.setBuktiPelanggaran(input.nextLine());
        System.out.print("Jenis Kejahatan: ");
        pelaporan.setJenisKejahatan(input.nextLine());

        DaftarKriminal.add(pelaporan);
        System.out.println("Data Berhasil Ditambahkan.");
    }

    private static void tambahDataPelaporanSosial(ArrayList<SistemPelaporanSosial> DaftarSosial, Scanner input) {
        System.out.println("\n=== Tambah Data Pelaporan Sosial ===");
        System.out.print("Tanggal Pelaporan: ");
        String tanggal = input.nextLine();
        SistemPelaporanSosial pelaporan = new SistemPelaporanSosial(tanggal);

        System.out.print("Nama Orang Yang Dilaporkan: ");
        pelaporan.setNamaOrangYangDilaporkan(input.nextLine());
        System.out.print("Nama Pelapor: ");
        pelaporan.setNamaPelapor(input.nextLine());
        System.out.print("Lokasi Pelanggaran: ");
        pelaporan.setLokasiPelanggaran(input.nextLine());
        System.out.print("Bukti Pelanggaran: ");
        pelaporan.setBuktiPelanggaran(input.nextLine());
        System.out.print("Dampak Sosial: ");
        pelaporan.setDampakSosial(input.nextLine());

        DaftarSosial.add(pelaporan);
        System.out.println("Data Berhasil Ditambahkan.");
    }

    private static void updateDataPelaporan(ArrayList<SistemPelaporanKriminal> DaftarKriminal, ArrayList<SistemPelaporanSosial> DaftarSosial, Scanner input) {
        ArrayList<SistemPelaporan> dataPelaporan = new ArrayList<>();
        dataPelaporan.addAll(DaftarKriminal);
        dataPelaporan.addAll(DaftarSosial);
    
        System.out.println("\n=== Update Data Pelaporan ===");
        System.out.println("Data Pelaporan yang Tersedia:");
        System.out.println("1. Data Pelaporan Kriminal:");
        System.out.println("2. Data Pelaporan Sosial:");
        System.out.print("Pilih Data Pelaporan yang Akan Diupdate: ");
        int pilihan = input.nextInt();
        input.nextLine(); 
        if (pilihan == 1) {
            if (DaftarKriminal.isEmpty()) {
                System.out.println("Data Pelaporan Kriminal Kosong.");
                return;
            }
            System.out.print("Masukkan Nomor Data Pelaporan Kriminal yang Akan Diupdate: ");
            int nomor = input.nextInt();
            input.nextLine();
            if (nomor >= 1|| nomor <= DaftarKriminal.size()) {
               updateDataPelaporan(DaftarKriminal.get(nomor - 1), input);
            } else {
                System.out.println("Data Tidak Ditemukan.");
            }
        } else if (pilihan == 2) {
            if (DaftarSosial.isEmpty()) {
                System.out.println("Data Pelaporan Sosial Kosong.");
                return;
            }
            System.out.print("Masukkan Nomor Data Pelaporan Sosial yang Akan Diupdate: ");
            int nomor = input.nextInt();
            input.nextLine();
            if (nomor >= 1 || nomor <= DaftarSosial.size()) {
                updateDataPelaporan(DaftarSosial.get(nomor - 1), input);
            } else {
                System.out.println("Data Tidak Ditemukan.");
        }
        } else {
            System.out.println("Pilihan tidak tersedia.");
        }
    }
    
    private static void updateDataPelaporan(SistemPelaporanKriminal kriminal, Scanner input) {
        System.out.println("\nDetail Data yang Akan Diupdate:");
        System.out.print("Nama Orang Yang Dilaporkan: ");
        kriminal.setNamaOrangYangDilaporkan(input.nextLine());
        System.out.print("Nama Pelapor: ");
        kriminal.setNamaPelapor(input.nextLine());
        System.out.print("Lokasi Pelanggaran: ");
        kriminal.setLokasiPelanggaran(input.nextLine());
        System.out.print("Bukti Pelanggaran: ");
        kriminal.setBuktiPelanggaran(input.nextLine());
        System.out.print("Jenis Kejahatan: ");
        kriminal.setJenisKejahatan(input.nextLine());
    
        System.out.println("Data Pelaporan Kriminal Berhasil Diupdate.");
    }
    
    private static void updateDataPelaporan(SistemPelaporanSosial sosial, Scanner input) {
        System.out.println("\nDetail Data yang Akan Diupdate:");
        System.out.print("Nama Orang Yang Dilaporkan: ");
        sosial.setNamaOrangYangDilaporkan(input.nextLine());
        System.out.print("Nama Pelapor: ");
        sosial.setNamaPelapor(input.nextLine());
        System.out.print("Lokasi Pelanggaran: ");
        sosial.setLokasiPelanggaran(input.nextLine());
        System.out.print("Bukti Pelanggaran: ");
        sosial.setBuktiPelanggaran(input.nextLine());
        System.out.print("Dampak Sosial: ");
        sosial.setDampakSosial(input.nextLine());
    
        System.out.println("Data Pelaporan Sosial Berhasil Diupdate.");
    }
    

    private static void hapusDataPelaporan(ArrayList<SistemPelaporanKriminal> DaftarKriminal, ArrayList<SistemPelaporanSosial> DaftarSosial, Scanner input) {
        ArrayList<SistemPelaporan> dataPelaporan = new ArrayList<SistemPelaporan>();
        dataPelaporan.addAll(DaftarKriminal);
        dataPelaporan.addAll(DaftarSosial);
        System.out.println("\n=== Hapus Data Pelaporan ===");
        System.out.print("Masukkan Nomor Data Pelaporan: ");

        try {
            int nomor = Integer.parseInt(input.nextLine());

            if (nomor < 1 || nomor > dataPelaporan.size()) {
                System.out.println("Data Tidak Ditemukan.");
                return;
            }

            SistemPelaporan pelaporan = dataPelaporan.get(nomor - 1);
            System.out.println("\nDetail Data yang Akan Dihapus:");
            pelaporan.tampilkanData();
            System.out.print("\nApakah Anda yakin ingin menghapus data ini? (y/n): ");
            String konfirmasi = input.nextLine();

            if (konfirmasi.equalsIgnoreCase("y")) {
                dataPelaporan.remove(nomor - 1);
                System.out.println("Data Berhasil Dihapus.");
            } else {
                System.out.println("Penghapusan Dibatalkan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka.");
        }
    }
}
