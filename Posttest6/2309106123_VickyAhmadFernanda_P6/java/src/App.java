
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
                String pilihanInput = input.nextLine();

                if (pilihanInput.isEmpty()) {
                    throw new Exception("Input tidak boleh kosong. Harap masukkan angka.");
                }

                if (!pilihanInput.matches("\\d+")) {
                    throw new Exception("Input harus berupa angka.");
                }

                pilihan = Integer.parseInt(pilihanInput);

                if (pilihan < 1 || pilihan > 6) {
                    throw new Exception("Pilihan tidak valid. Silakan pilih antara 1-6.");
                }
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
        if (tanggal.isEmpty()) {
            System.out.println("Tanggal tidak boleh kosong.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;
            
        }
        if (!tanggal.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Format tanggal tidak valid. Gunakan format dd/MM/yyyy.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        SistemPelaporanKriminal pelaporan = new SistemPelaporanKriminal(tanggal);

        System.out.print("Nama Orang Yang Dilaporkan: ");
        String nama = input.nextLine();
        if (nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        if (nama.length() > 50) {
            System.out.println("Nama tidak boleh lebih dari 50 karakter.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        if (!nama.matches("[a-zA-Z\\s]+")) {
            System.out.println("Nama hanya boleh mengandung huruf dan spasi.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        pelaporan.setNamaOrangYangDilaporkan(nama);

        System.out.print("Nama Pelapor: ");
        String namaPelapor = input.nextLine();
        if (namaPelapor.isEmpty()) {
            System.out.println("Nama Pelapor tidak boleh kosong.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        if (namaPelapor.length() > 50) {
            System.out.println("Nama tidak boleh lebih dari 50 karakter.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        if (!namaPelapor.matches("[a-zA-Z\\s]+")) {
            System.out.println("Nama hanya boleh mengandung huruf dan spasi.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        pelaporan.setNamaPelapor(namaPelapor);

        System.out.print("Lokasi Pelanggaran: ");
        String lokasi = input.nextLine();
        if (lokasi.isEmpty()) {
            System.out.println("Lokasi tidak boleh kosong.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        if (lokasi.length() > 100) {
            System.out.println("Lokasi tidak boleh lebih dari 100 karakter.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        if (!lokasi.matches("[a-zA-Z0-9\\s]+")) {
            System.out.println("Lokasi hanya boleh mengandung huruf, angka, dan spasi.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        if (lokasi.length() < 5) {
            System.out.println("Lokasi tidak boleh kurang dari 5 karakter.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        pelaporan.setLokasiPelanggaran(lokasi);

        System.out.print("Bukti Pelanggaran: ");
        String bukti = input.nextLine();
        if (bukti.isEmpty()) {
            System.out.println("Bukti tidak boleh kosong.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        pelaporan.setBuktiPelanggaran(bukti);

        System.out.print("Jenis Kejahatan: ");
        String jenis = input.nextLine();
        if (jenis.isEmpty()) {
            System.out.println("Jenis Kejahatan tidak boleh kosong.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        if (jenis.length() > 50) {
            System.out.println("Jenis Kejahatan tidak boleh lebih dari 50 karakter.");
            tambahDataPelaporanKriminal(DaftarKriminal, input); 
            return;

        }
        if (!jenis.matches("[a-zA-Z\\s]+")) {
            System.out.println("Jenis Kejahatan hanya boleh mengandung huruf dan spasi.");
            tambahDataPelaporanKriminal(DaftarKriminal, input);
            return;

        }
        pelaporan.setJenisKejahatan(jenis);
        
        

        DaftarKriminal.add(pelaporan);
        System.out.println("Data Berhasil Ditambahkan.");
        return;
    }

    private static void tambahDataPelaporanSosial(ArrayList<SistemPelaporanSosial> DaftarSosial, Scanner input) {
        System.out.println("\n=== Tambah Data Pelaporan Sosial ===");
        System.out.print("Tanggal Pelaporan: ");
        String tanggal = input.nextLine();
        if (tanggal.isEmpty()) {
            System.out.println("Tanggal tidak boleh kosong.");
            tambahDataPelaporanSosial(DaftarSosial, input);
            return;
            
        }
        if (!tanggal.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Format tanggal tidak valid. Gunakan format dd/MM/yyyy.");
            tambahDataPelaporanSosial(DaftarSosial, input);
            return;
        }
        SistemPelaporanSosial pelaporan = new SistemPelaporanSosial(tanggal);

        System.out.print("Nama Orang Yang Dilaporkan: ");
        String nama = input.nextLine();
        if (nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong.");
            tambahDataPelaporanSosial(DaftarSosial, input);
            return;
            
        }
        if (nama.length() > 50) {
            System.out.println("Nama tidak boleh lebih dari 50 karakter.");
            tambahDataPelaporanSosial( DaftarSosial, input);
            return;

        }
        if (!nama.matches("[a-zA-Z\\s]+")) {
            System.out.println("Nama hanya boleh mengandung huruf dan spasi.");
            tambahDataPelaporanSosial( DaftarSosial, input);
            return;
        }

        pelaporan.setNamaOrangYangDilaporkan(nama);

        System.out.print("Nama Pelapor: ");
        String namaPelapor = input.nextLine();
        if (namaPelapor.isEmpty()) {
            System.out.println("Nama Pelapor tidak boleh kosong.");
            tambahDataPelaporanSosial(DaftarSosial, input);
            return;

        }
        if (namaPelapor.length() > 50) {
            System.out.println("Nama tidak boleh lebih dari 50 karakter.");
            tambahDataPelaporanSosial(DaftarSosial, input);
            return;

            
        }
        if (!namaPelapor.matches("[a-zA-Z\\s]+")) {
            System.out.println("Nama hanya boleh mengandung huruf dan spasi.");
            tambahDataPelaporanSosial(DaftarSosial, input);
            return;

        }
        if (namaPelapor.length() < 5) {
            System.out.println("Nama tidak boleh kurang dari 5 karakter.");
            tambahDataPelaporanSosial(DaftarSosial, input);
            return;
            
        }
        pelaporan.setNamaPelapor(namaPelapor);

        System.out.print("Lokasi Pelanggaran: ");
        String lokasi = input.nextLine();
        if (lokasi.isEmpty()) {
            System.out.println("Lokasi tidak boleh kosong.");
            tambahDataPelaporanSosial(DaftarSosial, input);
            return;
        }
        if (lokasi.length() > 100) {
            System.out.println("Lokasi tidak boleh lebih dari 100 karakter.");
            tambahDataPelaporanSosial(DaftarSosial, input);
            return;
        }
        if (!lokasi.matches("[a-zA-Z0-9\\s]+")) {
            System.out.println("Lokasi hanya boleh mengandung huruf, angka, dan spasi.");
            tambahDataPelaporanSosial(DaftarSosial, input);return;
        }
        pelaporan.setLokasiPelanggaran(lokasi);

        System.out.print("Bukti Pelanggaran: ");
        String bukti = input.nextLine();
        if (bukti.isEmpty()) {
            System.out.println("Bukti tidak boleh kosong.");
            tambahDataPelaporanSosial(DaftarSosial, input);
        }

        pelaporan.setBuktiPelanggaran(bukti);
        System.out.print("Dampak Sosial: ");
        String dampak = input.nextLine();
        if (dampak.isEmpty()) {
            System.out.println("Dampak Sosial tidak boleh kosong.");
            tambahDataPelaporanSosial(DaftarSosial, input);return;
        }
        if (dampak.length() > 100) {
            System.out.println("Dampak Sosial tidak boleh lebih dari 100 karakter.");
            tambahDataPelaporanSosial(DaftarSosial, input);return;
        }
        if (!dampak.matches("[a-zA-Z0-9\\s]+")) {
            System.out.println("Dampak Sosial hanya boleh mengandung huruf, angka, dan spasi.");
            tambahDataPelaporanSosial(DaftarSosial, input);return;
        }
        pelaporan.setDampakSosial(dampak);

        DaftarSosial.add(pelaporan);
        System.out.println("Data Berhasil Ditambahkan.");
        return;
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
            System.out.println("Data Pelaporan Kriminal yang Tersedia:");
            tampilkanData(DaftarKriminal, DaftarSosial, input);
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
            System.out.println("Data Pelaporan Sosial yang Tersedia:");
            tampilkanData(DaftarKriminal, DaftarSosial, input);
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
            if (kriminal == null) {
                System.out.println("Data pelaporan tidak ditemukan.");
                return;
            }
        
            System.out.println("\nDetail Data yang Akan Diupdate:");
        
            String namaOrangYangDilaporkan;
            do {
                System.out.print("Nama Orang Yang Dilaporkan: ");
                namaOrangYangDilaporkan = input.nextLine().trim();
                if (namaOrangYangDilaporkan.isEmpty()) {
                    System.out.println("Nama orang yang dilaporkan tidak boleh kosong. Silakan coba lagi.");
                }
            } while (namaOrangYangDilaporkan.isEmpty());
            kriminal.setNamaOrangYangDilaporkan(namaOrangYangDilaporkan);
        
            String namaPelapor;
            do {
                System.out.print("Nama Pelapor: ");
                namaPelapor = input.nextLine().trim();
                if (namaPelapor.isEmpty()) {
                    System.out.println("Nama pelapor tidak boleh kosong. Silakan coba lagi.");
                }
            } while (namaPelapor.isEmpty());
            kriminal.setNamaPelapor(namaPelapor);
        
            String lokasiPelanggaran;
            do {
                System.out.print("Lokasi Pelanggaran: ");
                lokasiPelanggaran = input.nextLine().trim();
                if (lokasiPelanggaran.isEmpty()) {
                    System.out.println("Lokasi pelanggaran tidak boleh kosong. Silakan coba lagi.");
                }
            } while (lokasiPelanggaran.isEmpty());
            kriminal.setLokasiPelanggaran(lokasiPelanggaran);
        
            String buktiPelanggaran;
            do {
                System.out.print("Bukti Pelanggaran: ");
                buktiPelanggaran = input.nextLine().trim();
                if (buktiPelanggaran.isEmpty()) {
                    System.out.println("Bukti pelanggaran tidak boleh kosong. Silakan coba lagi.");
                }
            } while (buktiPelanggaran.isEmpty());
            kriminal.setBuktiPelanggaran(buktiPelanggaran);
        
            String jenisKejahatan;
            do {
                System.out.print("Jenis Kejahatan: ");
                jenisKejahatan = input.nextLine().trim();
                if (jenisKejahatan.isEmpty()) {
                    System.out.println("Jenis kejahatan tidak boleh kosong. Silakan coba lagi.");
                }
            } while (jenisKejahatan.isEmpty());
            if (jenisKejahatan.length() > 50) {
                System.out.println("Jenis kejahatan tidak boleh lebih dari 50 karakter.");
                updateDataPelaporan(kriminal, input);
                return;
                
            }
            if (!jenisKejahatan.matches("[a-zA-Z\\s]+")) {
                System.out.println("Jenis kejahatan hanya boleh mengandung huruf dan spasi.");
                updateDataPelaporan(kriminal, input);
                return;
                
            }
            if (jenisKejahatan.length() < 5) {
                System.out.println("Jenis kejahatan tidak boleh kurang dari 5 karakter.");
                updateDataPelaporan(kriminal, input);
                return;
                
            }
            kriminal.setJenisKejahatan(jenisKejahatan);
        
            System.out.println("Data Pelaporan Kriminal Berhasil Diupdate.");
        }
        
    
        private static void updateDataPelaporan(SistemPelaporanSosial sosial, Scanner input) {
            if (sosial == null) {
                System.out.println("Data pelaporan tidak ditemukan.");
                return;
            }
        
            System.out.println("\nDetail Data yang Akan Diupdate:");

        
            String namaOrangYangDilaporkan;
            do {
                System.out.print("Nama Orang Yang Dilaporkan: ");
                namaOrangYangDilaporkan = input.nextLine().trim();
                if (namaOrangYangDilaporkan.isEmpty()) {
                    System.out.println("Nama orang yang dilaporkan tidak boleh kosong. Silakan coba lagi.");
                }
            } while (namaOrangYangDilaporkan.isEmpty());
            sosial.setNamaOrangYangDilaporkan(namaOrangYangDilaporkan);
        
            String namaPelapor;
            do {
                System.out.print("Nama Pelapor: ");
                namaPelapor = input.nextLine().trim();
                if (namaPelapor.isEmpty()) {
                    System.out.println("Nama pelapor tidak boleh kosong. Silakan coba lagi.");
                }
            } while (namaPelapor.isEmpty());
            sosial.setNamaPelapor(namaPelapor);
        

            String lokasiPelanggaran;
            do {
                System.out.print("Lokasi Pelanggaran: ");
                lokasiPelanggaran = input.nextLine().trim();
                if (lokasiPelanggaran.isEmpty()) {
                    System.out.println("Lokasi pelanggaran tidak boleh kosong. Silakan coba lagi.");
                }
            } while (lokasiPelanggaran.isEmpty());
            sosial.setLokasiPelanggaran(lokasiPelanggaran);

            String buktiPelanggaran;
            do {
                System.out.print("Bukti Pelanggaran: ");
                buktiPelanggaran = input.nextLine().trim();
                if (buktiPelanggaran.isEmpty()) {
                    System.out.println("Bukti pelanggaran tidak boleh kosong. Silakan coba lagi.");
                }
            } while (buktiPelanggaran.isEmpty());
            sosial.setBuktiPelanggaran(buktiPelanggaran);

            String dampakSosial;
            do {
                System.out.print("Dampak Sosial: ");
                dampakSosial = input.nextLine().trim();
                if (dampakSosial.isEmpty()) {
                    System.out.println("Dampak sosial tidak boleh kosong. Silakan coba lagi.");
                }
            } while (dampakSosial.isEmpty());
            if (dampakSosial.length() > 100) {
                System.out.println("Dampak sosial tidak boleh lebih dari 100 karakter.");
                updateDataPelaporan(sosial, input);
                return;
                
            }
            if (!dampakSosial.matches("[a-zA-Z0-9\\s]+")) {
                System.out.println("Dampak sosial hanya boleh mengandung huruf, angka, dan spasi.");
                updateDataPelaporan(sosial, input);
                return;
                
            }
            if (dampakSosial.length() < 5) {
                System.out.println("Dampak sosial tidak boleh kurang dari 5 karakter.");
                updateDataPelaporan(sosial, input);
                return;
                
            }
            sosial.setDampakSosial(dampakSosial);
        
            System.out.println("Data Pelaporan Sosial Berhasil Diupdate.");
        }
        
    

    private static void hapusDataPelaporan(ArrayList<SistemPelaporanKriminal> DaftarKriminal, ArrayList<SistemPelaporanSosial> DaftarSosial, Scanner input) {
        ArrayList<SistemPelaporan> dataPelaporan = new ArrayList<SistemPelaporan>();
        dataPelaporan.addAll(DaftarKriminal);
        dataPelaporan.addAll(DaftarSosial);
        System.out.println("Data Pelaporan yang Tersedia:");
        tampilkanData(DaftarKriminal, DaftarSosial, input);
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
