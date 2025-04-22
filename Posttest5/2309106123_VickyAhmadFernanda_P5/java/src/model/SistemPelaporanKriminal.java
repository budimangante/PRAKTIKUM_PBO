package model;
public class SistemPelaporanKriminal extends SistemPelaporan {
    private String jenisKejahatan;

    public SistemPelaporanKriminal(final String tanggalPelaporan) {
        super(tanggalPelaporan);
    }

    public String getJenisKejahatan() {
        return jenisKejahatan;
    }

    public void setJenisKejahatan(String jenisKejahatan) {
        this.jenisKejahatan = jenisKejahatan;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("Jenis Kejahatan: " + jenisKejahatan);
    }
}
