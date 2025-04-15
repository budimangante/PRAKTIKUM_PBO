import model.SistemPelaporan;
import model.SistemPelaporanKriminal;
import model.SistemPelaporanSosial;

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
                        TambahDataPelaporanSosial(dataPelaporan, input);
                        break;
                    case 2:
                        TambahDataPelaporanKriminal(dataPelaporan, input);
                        break;
                    case 3:
                        TampilkanData(dataPelaporan);
                        break;
                    case 4:
                        UpdateDataPelaporan(dataPelaporan, input);
                        break;
                    case 5:
                        HapusDataPelaporan(dataPelaporan, input);
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

    public static void TampilkanData(ArrayList<SistemPelaporan> dataPelaporan) {
        if (dataPelaporan.isEmpty()) {
            System.out.println("Data Kosong.");
            return;
        }
        for (int i = 0; i < dataPelaporan.size(); i++) {
            System.out.println("Data Laporan Ke-" + (i + 1));
            dataPelaporan.get(i).TampilkanData();
            System.out.println("-----------------------------------");
        }
    }```java
// Add a method to validate user input
public static boolean isValidInput(String input) {
    return input != null && !input.isEmpty();
}

// Modify the main method to handle invalid inputs
public static void main(String[] args) {
    ArrayList<SistemPelaporan> dataPelaporan = new ArrayList<SistemPelaporan>();
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
                    TambahDataPelaporanSosial(dataPelaporan, input);
                    break;
                case 2:
                    TambahDataPelaporanKriminal(dataPelaporan, input);
                    break;
                case 3:
                    TampilkanData(dataPelaporan);
                    break;
                case 4:
                    UpdateDataPelaporan(dataPelaporan, input);
                    break;
                case 5:
                    HapusDataPelaporan(dataPelaporan, input);
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

// Modify the TambahDataPelaporanSosial method to validate user input
public static void TambahDataPelaporanSosial(ArrayList<SistemPelaporan> dataPelaporan, Scanner input) {
    SistemPelaporanSosial pelaporan = new SistemPelaporanSosial();
    System.out.println("=== Tambah Data Pelaporan Sosial ===");
    pelaporan.setJenis_Pelanggaran("Sosial");
    System.out.print("Nama Orang Yang Dilaporkan: ");
    String namaOrangYangDilaporkan = input.nextLine();
    while (!isValidInput(namaOrangYangDilaporkan)) {
        System.out.print("Nama Orang Yang Dilaporkan tidak boleh kosong. Silakan masukkan lagi: ");
        namaOrangYangDilaporkan = input.nextLine();
    }
    pelaporan.setNama_Orang_Yang_Dilaporkan(namaOrangYangDilaporkan);
    System.out.print("Nama Pelapor: ");
    String namaPelapor = input.nextLine();
    while (!isValidInput(namaPelapor)) {
        System.out.print("Nama Pelapor tidak boleh kosong. Silakan masukkan lagi: ");
        namaPelapor = input.nextLine();
    }
    pelaporan.setNama_Pelapor(namaPelapor);
    System.out.print("Tanggal Pelaporan: ");
    String tanggalPelaporan = input.nextLine();
    while (!isValidInput(tanggalPelaporan)) {
        System.out.print("Tanggal Pelaporan tidak boleh kosong. Silakan masukkan lagi: ");
        tanggalPelaporan = input.nextLine();
    }
    pelaporan.setTanggal_Pelaporan(tanggalPelaporan);
    System.out.print("Lokasi Pelanggaran: ");
    String lokasiPelanggaran = input.nextLine();
    while (!isValidInput(lokasiPelanggaran)) {
        System.out.print("Lokasi Pelanggaran tidak boleh kosong. Silakan masukkan lagi: ");
        lokasiPelanggaran = input.nextLine();
    }
    pelaporan.setLokasi_Pelanggaran(lokasiPelanggaran);
    System.out.print("Bukti Pelanggaran: ");
    String buktiPelanggaran = input.nextLine();
    while (!isValidInput(buktiPelanggaran)) {
        System.out.print("Bukti Pelanggaran tidak boleh kosong. Silakan masukkan lagi: ");
        buktiPelanggaran = input.nextLine();
    }
    pelaporan.setBukti_Pelanggaran(buktiPelanggaran);
    System.out.print("Dampak Sosial: ");
    String dampakSosial = input.nextLine();
    while (!isValidInput(dampakSosial)) {
        System.out.print("Dampak Sosial tidak boleh kosong. Silakan masukkan lagi: ");
        dampakSosial = input.nextLine();
    }
    pelaporan.setDampakSosial(dampakSosial);

    dataPelaporan.add(pelaporan);
    System.out.println("Data Berhasil Ditambahkan.");
}

// Modify the TambahDataPelaporanKriminal method to validate user input
public static void TambahDataPelaporanKriminal(ArrayList<SistemPelaporan> dataPelaporan, Scanner input) {
    SistemPelaporanKriminal pelaporan = new SistemPelaporanKriminal();
    System.out.println("=== Tambah Data Pelaporan Kriminal ===");
    pelaporan.setJenis_Pelanggaran("Kriminal");
    System.out.print("Nama Orang Yang Dilaporkan: ");
    String namaOrangYangDilaporkan = input.nextLine();
    while (!isValidInput(namaOrangYangDilaporkan)) {
        System.out.print("Nama Orang Yang Dilaporkan tidak boleh kosong. Silakan masukkan lagi: ");
        namaOrangYangDilaporkan = input.nextLine();
    }
    pelaporan.setNama_Orang_Yang_Dilaporkan(namaOrangYangDilaporkan);
    System.out.print("Nama Pelapor: ");
    String namaPelapor = input.nextLine();
    while (!isValidInput(namaPelapor)) {
        System.out.print("Nama Pelapor tidak boleh kosong. Silakan masukkan lagi: ");
        namaPelapor = input.nextLine();
    }
    pelaporan.setNama_Pelapor(namaPelapor);
    System.out.print("Tanggal Pelaporan: ");
    String tanggalPelaporan = input.nextLine();
    while (!isValidInput(tanggalPelaporan)) {
        System.out.print("Tanggal Pelaporan tidak boleh kosong. Silakan masukkan lagi: ");
        tanggalPelaporan = input.nextLine();
    }
    pelaporan.setTanggal_Pelaporan(tanggalPelaporan);
    System.out.print("Lokasi Pelanggaran: ");
    String lokasiPelanggaran = input.nextLine();
    while (!isValidInput(lokasiPelanggaran)) {
        System.out.print("Lokasi Pelanggaran tidak boleh kosong. Silakan masukkan lagi: ");
        lokasiPelanggaran = input.nextLine();
    }
    pelaporan.setLokasi_Pelanggaran(lokasiPelanggaran);
    System.out.print("Bukti Pelanggaran: ");
    String buktiPelanggaran = input.nextLine();
    while (!isValidInput(buktiPelanggaran)) {
        System.out.print("Bukti Pelanggaran tidak boleh kosong. Silakan masukkan lagi: ");
        buktiPelanggaran = input.nextLine();
    }
    pelaporan.setBukti_Pelanggaran(buktiPelanggaran);
    System.out.print("Jenis Kejahatan: ");
    String jenisKejahatan = input.nextLine();
    while (!isValidInput(jenisKejahatan)) {
        System.out.print("Jenis Kejahatan tidak boleh kosong. Silakan masukkan lagi: ");
        jenisKejahatan = input.nextLine();
    }
    pelaporan.setJenisKejahatan(jenisKejahatan);

    dataPelaporan.add(pelaporan);
    System.out.println("Data Berhasil Ditambahkan.");
}

// Modify the UpdateDataPelaporan method to validate user input
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
            return;
        }
        SistemPelaporan pelaporan = dataPelaporan.get(nomor - 1);
        if (pelaporan instanceof SistemPelaporanKriminal) {
            SistemPelaporanKriminal pelaporanKriminal = (SistemPelaporanKriminal) pelaporan;
            System.out.print("Nama Orang Yang Dilaporkan: ");
            String namaOrangYangDilaporkan = input.nextLine();
            while (!isValidInput(namaOrangYangDilaporkan)) {
                System.out.print("Nama Orang Yang Dilaporkan tidak boleh kosong. Silakan masukkan lagi: ");
                namaOrangYangDilaporkan = input.nextLine();
            }
            pelaporanKriminal.setNama_Orang_Yang_Dilaporkan(namaOrangYangDilaporkan);
            System.out.print("Nama Pelapor: ");
            String namaPelapor = input.nextLine();
            while

    public static void TambahDataPelaporanSosial(ArrayList<SistemPelaporan> dataPelaporan, Scanner input) {
        SistemPelaporanSosial pelaporan = new SistemPelaporanSosial();
        System.out.println("=== Tambah Data Pelaporan Sosial ===");
        pelaporan.setJenis_Pelanggaran("Sosial");
        System.out.print("Nama Orang Yang Dilaporkan: ");
        pelaporan.setNama_Orang_Yang_Dilaporkan(input.nextLine());
        System.out.print("Nama Pelapor: ");
        pelaporan.setNama_Pelapor(input.nextLine());
        System.out.print("Tanggal Pelaporan: ");
        pelaporan.setTanggal_Pelaporan(input.nextLine());
        System.out.print("Lokasi Pelanggaran: ");
        pelaporan.setLokasi_Pelanggaran(input.nextLine());
        System.out.print("Bukti Pelanggaran: ");
        pelaporan.setBukti_Pelanggaran(input.nextLine());
        System.out.print("Dampak Sosial: ");
        pelaporan.setDampakSosial(input.nextLine());

        dataPelaporan.add(pelaporan);
        System.out.println("Data Berhasil Ditambahkan.");
    }

    public static void TambahDataPelaporanKriminal(ArrayList<SistemPelaporan> dataPelaporan, Scanner input) {
        SistemPelaporanKriminal pelaporan = new SistemPelaporanKriminal();
        System.out.println("=== Tambah Data Pelaporan Kriminal ===");
        pelaporan.setJenis_Pelanggaran("Kriminal");
        System.out.print("Nama Orang Yang Dilaporkan: ");
        pelaporan.setNama_Orang_Yang_Dilaporkan(input.nextLine());
        System.out.print("Nama Pelapor: ");
        pelaporan.setNama_Pelapor(input.nextLine());
        System.out.print("Tanggal Pelaporan: ");
        pelaporan.setTanggal_Pelaporan(input.nextLine());
        System.out.print("Lokasi Pelanggaran: ");
        pelaporan.setLokasi_Pelanggaran(input.nextLine());
        System.out.print("Bukti Pelanggaran: ");
        pelaporan.setBukti_Pelanggaran(input.nextLine());
        System.out.print("Jenis Kejahatan: ");
        pelaporan.setJenisKejahatan(input.nextLine());

        dataPelaporan.add(pelaporan);
        System.out.println("Data Berhasil Ditambahkan.");
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
                return;
            }
    
            SistemPelaporan pelaporan = dataPelaporan.get(nomor - 1);
    
            if (pelaporan instanceof SistemPelaporanKriminal) {
                SistemPelaporanKriminal pelaporanKriminal = (SistemPelaporanKriminal) pelaporan;
                System.out.print("Nama Orang Yang Dilaporkan: ");
                pelaporanKriminal.setNama_Orang_Yang_Dilaporkan(input.nextLine());
                System.out.print("Nama Pelapor: ");
                pelaporanKriminal.setNama_Pelapor(input.nextLine());
                System.out.print("Tanggal Pelaporan: ");
                pelaporanKriminal.setTanggal_Pelaporan(input.nextLine());
                System.out.print("Lokasi Pelanggaran: ");
                pelaporanKriminal.setLokasi_Pelanggaran(input.nextLine());
                System.out.print("Bukti Pelanggaran: ");
                pelaporanKriminal.setBukti_Pelanggaran(input.nextLine());
                System.out.print("Jenis Kejahatan: ");
                pelaporanKriminal.setJenisKejahatan(input.nextLine());
                System.out.println("Data Pelaporan Kriminal Berhasil Diupdate.");
    
            } else if (pelaporan instanceof SistemPelaporanSosial) {
                SistemPelaporanSosial pelaporanSosial = (SistemPelaporanSosial) pelaporan;
                System.out.print("Nama Orang Yang Dilaporkan: ");
                pelaporanSosial.setNama_Orang_Yang_Dilaporkan(input.nextLine());
                System.out.print("Nama Pelapor: ");
                pelaporanSosial.setNama_Pelapor(input.nextLine());
                System.out.print("Tanggal Pelaporan: ");
                pelaporanSosial.setTanggal_Pelaporan(input.nextLine());
                System.out.print("Lokasi Pelanggaran: ");
                pelaporanSosial.setLokasi_Pelanggaran(input.nextLine());
                System.out.print("Bukti Pelanggaran: ");
                pelaporanSosial.setBukti_Pelanggaran(input.nextLine());
                System.out.print("Dampak Sosial: ");
                pelaporanSosial.setDampakSosial(input.nextLine());
                System.out.println("Data Pelaporan Sosial Berhasil Diupdate.");
    
            } else {
                System.out.println("Jenis Pelaporan Tidak Dikenali.");
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
                return;
            }
    
            SistemPelaporan pelaporan = dataPelaporan.get(nomor - 1);
    
            // Memberikan detail data yang akan dihapus
            System.out.println("\nDetail Data yang Akan Dihapus:");
            pelaporan.TampilkanData();
            System.out.print("\nApakah Anda yakin ingin menghapus data ini? (y/n): ");
            String konfirmasi = input.nextLine();
    
            if (konfirmasi.equalsIgnoreCase("y")) {
                dataPelaporan.remove(nomor - 1);
                System.out.println("Data Berhasil Dihapus.");
            } else {
                System.out.println("Penghapusan Dibatalkan.");
            }
    
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus data: " + e.getMessage());
        }
    }    
}

