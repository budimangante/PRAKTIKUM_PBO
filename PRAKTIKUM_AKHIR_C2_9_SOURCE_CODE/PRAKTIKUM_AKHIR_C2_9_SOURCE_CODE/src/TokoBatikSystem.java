import model.*;
import java.util.*;
import java.io.Console;

public class TokoBatikSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static Admin admin = new Admin("admin","admin123");
    private static List<Kasir> daftarKasir = new ArrayList<>();
    private static Kasir kasir;


    public static void main(String[] args) {
        tampilkanMenuLogin();
    }

    private static void tampilkanMenuLogin() {
        System.out.println("==================================================");
        System.out.println("          SISTEM MANAJEMEN TOKO BATIK            ");
        System.out.println("==================================================");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Kasir");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu: ");
        int pilihan = -1;  
        try {
                System.out.print("Pilih menu: ");
                pilihan = scanner.nextInt();
                scanner.nextLine(); 

                if (pilihan < 1 || pilihan > 3) {
                    clearScreen();
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    tampilkanMenuLogin();
                    return;
                }

            } catch (InputMismatchException e) {
                clearScreen();
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                scanner.nextLine();
                tampilkanMenuLogin();
                return;
            }
        switch (pilihan) {
            case 1:
                System.out.print("Username: ");
                String usernameAdmin = scanner.nextLine();

                String passwordAdmin;
                Console pwAdmin = System.console();
                if (pwAdmin != null) {
                    System.out.print("Password: ");
                    char[] passwordChars = pwAdmin.readPassword();
                    passwordAdmin = new String(passwordChars);
                } else {
                    System.out.print("Password: ");
                    passwordAdmin = scanner.nextLine();
                }
                if (admin.login(usernameAdmin, passwordAdmin)) {
                    clearScreen();
                    System.out.println("Login berhasil sebagai Admin.");
                    tampilkanMenuAdmin();
                } else {
                    clearScreen();
                    System.out.println("Login gagal. Username atau password salah.");
                    tampilkanMenuLogin();
                }
                break;
            case 2:
                System.out.println("==================================================");
                System.out.println("                MENU LOGIN KASIR                 ");
                System.out.println("==================================================");
                System.out.println("1. Register Kasir");
                System.out.println("2. Login sebagai Kasir");
                System.out.println("3. Kembali ke Menu Utama");
                System.out.println("==================================================");

                int pilihanKasir = -1;  

                try {
                    System.out.print("Pilih menu: ");
                    pilihanKasir = scanner.nextInt();
                    scanner.nextLine(); 

                    if (pilihanKasir < 1 || pilihanKasir > 3) {
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        tampilkanMenuLogin();
                        return;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka. Silakan coba lagi.");
                    scanner.nextLine(); 
                    tampilkanMenuLogin();
                    return;
                }
                switch (pilihanKasir) {
                    case 1:
                        try {
                            if (daftarKasir.size() >= 5) {
                                throw new IllegalStateException("Jumlah kasir sudah mencapai batas maksimum (5 kasir).");
                            }
                            String usernameKasir = "";
                            while (true) {
                                System.out.print("Username: ");
                                String inputUsername = scanner.nextLine();

                                if (inputUsername.trim().isEmpty()) {
                                    clearScreen();
                                    System.out.println("Username tidak boleh kosong atau hanya spasi.");
                                } else if (inputUsername.startsWith(" ")) {
                                    clearScreen();
                                    System.out.println("Username tidak boleh diawali spasi.");
                                } else if (!inputUsername.replaceAll(" ", "").matches("[a-zA-Z0-9]+")) {
                                    clearScreen();
                                    System.out.println("Simbol tidak diperbolehkan.");
                                } else {
                                    boolean usernameSudahAda = daftarKasir.stream()
                                        .anyMatch(k -> k.getUsername().equalsIgnoreCase(inputUsername));
                                    if (usernameSudahAda) {
                                        clearScreen();
                                        System.out.println("Username tersebut sudah terdaftar. Silakan pilih username lain.");
                                    } else {
                                        usernameKasir = inputUsername;
                                        break;
                                    }
                                }
                            }
                            String passwordKasir = "";
                            Console pwKasir = System.console();
                            while (true) {
                                if (pwKasir != null) {
                                    System.out.print("Password: ");
                                    char[] passwordChars = pwKasir.readPassword();
                                    passwordKasir = new String(passwordChars);
                                } else {
                                    System.out.print("Password: ");
                                    passwordKasir = scanner.nextLine();
                                }

                                if (passwordKasir.trim().isEmpty()) {
                                    clearScreen();
                                    System.out.println("Password tidak boleh kosong atau hanya spasi.");
                                } else if (passwordKasir.startsWith(" ")) {
                                    clearScreen();
                                    System.out.println("Password tidak boleh diawali spasi.");
                                } else {
                                    break;
                                }
                            }

                            Kasir kasirBaru = new Kasir(usernameKasir, passwordKasir);
                            daftarKasir.add(kasirBaru);
                            clearScreen();
                            System.out.println("Kasir berhasil didaftarkan.");
                        } catch (IllegalStateException e) {
                            System.out.println( e.getMessage());
                        }
                        tampilkanMenuLogin();
                        break;
                    case 2:
                        loginKasir();
                        break;
                    case 3:
                        clearScreen();
                        System.out.println("Kembali ke Menu Utama.");
                        tampilkanMenuLogin();
                        break;
                    default:
                        clearScreen();
                        System.out.println("Pilihan tidak valid.");
                        tampilkanMenuLogin();
                    } 
            case 3:
                System.out.println("Terima kasih telah menggunakan sistem ini.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                tampilkanMenuLogin();
        }
    }

    private static void loginKasir() {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        String password;
        Console console = System.console();
        if (console != null) {
            System.out.print("Password: ");
            char[] passwordChars = console.readPassword();
            password = new String(passwordChars);
        } else {
            System.out.print("Password: ");
            password = scanner.nextLine();
        }

        try {
            if (username.isEmpty() || password.isEmpty()) {
                clearScreen();
                throw new IllegalArgumentException("Username dan password tidak boleh kosong.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            tampilkanMenuLogin();
        }

        for (Kasir k : daftarKasir) {
            if (k.getUsername().equals(username) && k.getPassword().equals(password)) {
                kasir = k;
                clearScreen();
                System.out.println("Login berhasil sebagai Kasir.");
                tampilkanMenuKasir();
                return;
            }
        }

        clearScreen();
        System.out.println("Login gagal. Username atau password salah.");
        tampilkanMenuLogin();
    }


    private static void tampilkanMenuAdmin() {
        while (true) {
            System.out.println("\n==================================================");
            System.out.println("                MENU ADMIN TOKO BATIK             ");
            System.out.println("==================================================");
            System.out.println("1. Kelola Produk");
            System.out.println("2. Lihat Laporan Penjualan");
            System.out.println("3. Logout");
            System.out.println("==================================================");
            System.out.print("Pilih menu: ");
            
            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
                
                switch (pilihan) {
                    case 1:
                        clearScreen();
                        menuKelolaProduk();
                        break;
                    case 2:
                        clearScreen();
                        admin.lihatLaporan();
                        break;
                    case 3:
                        clearScreen();
                        System.out.println("\nAnda telah logout.\n");
                        tampilkanMenuLogin();
                        return;
                    default:
                        clearScreen();
                        System.out.println("\nPilihan tidak valid. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                clearScreen();
                System.out.println("\nInput harus berupa angka. Silakan coba lagi.");
            } catch (Exception e) {
                clearScreen();
                System.out.println("\nTerjadi kesalahan: " + e.getMessage());
            }
        }
    }

    private static void menuKelolaProduk() {
        while (true) {
            System.out.println("\n==================================================");
            System.out.println("                KELOLA PRODUK BATIK               ");
            System.out.println("==================================================");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Edit Produk");
            System.out.println("3. Hapus Produk");
            System.out.println("4. Lihat Semua Produk");
            System.out.println("5. Kembali ke Menu Admin");
            System.out.print("Pilih menu: ");
            
            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
                
                switch (pilihan) {
                    case 1:
                        tambahProduk();
                        break;
                    case 2:
                        editProduk();
                        break;
                    case 3:
                        hapusProduk();
                        break;
                    case 4:
                        clearScreen();
                        admin.tampilkanSemuaProduk();
                        break;
                    case 5:
                        clearScreen();
                        return;
                    default:
                        clearScreen();
                        System.out.println("\nPilihan tidak valid. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                clearScreen();
                System.out.println("\nInput harus berupa angka. Silakan coba lagi.");
            } catch (Exception e) {
                clearScreen();
                System.out.println("\nTerjadi kesalahan: " + e.getMessage());
            }
        }
    }

    private static void tambahProduk() {
        System.out.println("\nTAMBAH PRODUK BARU");
        System.out.println("--------------------------------------------------");
        
        try {
            System.out.print("ID Produk: ");
            String id = scanner.nextLine();
            
            System.out.print("Nama Produk: ");
            String nama = scanner.nextLine();
            
            System.out.print("Jenis Kain: ");
            String jenis = scanner.nextLine();
            
            System.out.print("Motif: ");
            String motif = scanner.nextLine();
            
            System.out.print("Ukuran: ");
            String ukuran = scanner.nextLine();
            
            System.out.print("Harga: ");
            double harga = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Stok: ");
            int stok = Integer.parseInt(scanner.nextLine());
            
            Produk produkBaru = new Produk(id, nama, jenis, motif, ukuran, harga, stok);
            admin.tambahProduk(produkBaru);
        } catch (Exception e) {
            clearScreen();
            System.out.println(e.getMessage());
            System.out.println("Proses tambah produk dibatalkan.");
        }
    }

    private static void editProduk() {
        clearScreen();
        admin.tampilkanSemuaProduk();
        System.out.print("\nMasukkan ID Produk yang akan diedit: ");
        String id = scanner.nextLine();
        admin.editProduk(id, scanner);
    }

    private static void hapusProduk() {
        clearScreen();
        admin.tampilkanSemuaProduk();
        System.out.print("\nMasukkan ID Produk yang akan dihapus: ");
        String id = scanner.nextLine();
        admin.hapusProduk(id);
    }

    private static void tampilkanMenuKasir() {
        while (true) {
            System.out.println("\n==================================================");
            System.out.println("                MENU KASIR TOKO BATIK             ");
            System.out.println("==================================================");
            System.out.println("1. Buat Transaksi Baru");
            System.out.println("2. Cari Produk");
            System.out.println("3. Lihat Produk Tersedia");
            System.out.println("4. Logout");
            System.out.print("Pilih menu: ");
            
            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
                
                switch (pilihan) {
                    case 1:
                        buatTransaksiBaru();
                        break;
                    case 2:
                        cariProduk();
                        break;
                    case 3:
                        clearScreen();
                        kasir.tampilkanProdukTersedia(admin.getProdukList());
                        break;
                    case 4:
                        System.out.println("\nAnda telah logout.\n");
                        tampilkanMenuLogin();
                        return;
                    default:
                        System.out.println("\nPilihan tidak valid. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInput harus berupa angka. Silakan coba lagi.");
            } catch (Exception e) {
                System.out.println("\nTerjadi kesalahan: " + e.getMessage());
            }
        }
    }

    private static void buatTransaksiBaru() {
        System.out.println("\nBUAT TRANSAKSI BARU");
        System.out.println("--------------------------------------------------");
        
        try {
            System.out.print("ID Pelanggan: ");
            String idPelanggan = scanner.nextLine();
            
            System.out.print("Nama Pelanggan: ");
            String nama = scanner.nextLine();
            
            System.out.print("No. Telepon: ");
            String telp = scanner.nextLine();
            
            System.out.print("Email: ");
            String email = scanner.nextLine();
            
            Pelanggan pelanggan = new Pelanggan(idPelanggan, nama, telp, email);
            String idTransaksi = "TRX" + System.currentTimeMillis();
            Transaksi transaksi = new Transaksi(idTransaksi, pelanggan);
            
            boolean tambahLagi = true;
            while (tambahLagi) {
                kasir.tampilkanProdukTersedia(admin.getProdukList());
                
                System.out.print("\nMasukkan ID/Nama Produk yang dibeli: ");
                String keyword = scanner.nextLine();
                
                Produk produk = kasir.cariProduk(admin.getProdukList(), keyword);
                if (produk == null) {
                    System.out.println("Produk tidak ditemukan.");
                } else {
                    try {
                        // Kurangi stok produk
                        produk.kurangiStok(1);
                        transaksi.tambahProduk(produk);
                        System.out.println(produk.getNamaProduk() + " berhasil ditambahkan ke transaksi");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                
                System.out.print("Tambah produk lagi? (y/n): ");
                tambahLagi = scanner.nextLine().equalsIgnoreCase("y");
            }
            
            if (!transaksi.getDaftarProduk().isEmpty()) {
                kasir.prosesTransaksi(transaksi);
                admin.simpanTransaksi(transaksi);
            } else {
                System.out.println("Transaksi dibatalkan karena tidak ada produk yang dipilih");
            }
        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
            System.out.println("Proses transaksi dibatalkan.");
        }
    }

    private static void cariProduk() {
        System.out.print("\nMasukkan kata kunci pencarian (ID/Nama/Jenis/Motif): ");
        String keyword = scanner.nextLine();
        
        Produk hasil = kasir.cariProduk(admin.getProdukList(), keyword);
        if (hasil != null) {
            clearScreen();
            System.out.println("\nHASIL PENCARIAN:");
            hasil.tampilkanInfo();
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}