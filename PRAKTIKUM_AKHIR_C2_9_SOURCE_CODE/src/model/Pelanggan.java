package model;

public class Pelanggan {
    private final String idPelanggan;
    private String nama;
    private String noTelepon;
    private String email;

    public Pelanggan(String idPelanggan, String nama, String noTelepon, String email) {
        if (idPelanggan == null || idPelanggan.trim().isEmpty()) {
            throw new IllegalArgumentException("ID Pelanggan tidak boleh kosong");
        }
        this.idPelanggan = idPelanggan;
        setNama(nama);
        setNoTelepon(noTelepon);
        setEmail(email);
    }

    public void tampilkanInfo() {
        System.out.printf("ID: %s | Nama: %-20s | Telp: %-15s | Email: %s%n", 
                idPelanggan, nama, noTelepon, email);
    }

    // GETTER DAN SETTER DENGAN VALIDASI
    public String getIdPelanggan() { return idPelanggan; }

    public String getNama() { return nama; }
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.nama = nama;
    }

    public String getNoTelepon() { return noTelepon; }
    public void setNoTelepon(String noTelepon) {
        if (noTelepon == null || noTelepon.trim().isEmpty() || !noTelepon.matches("\\d{1,13}")) {
            throw new IllegalArgumentException("Nomor telepon tidak boleh kosong, harus terdiri dari angka dan maksimal 13 digit");
        }
        this.noTelepon = noTelepon;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email tidak boleh kosong");
        }
        this.email = email;
    }
}
