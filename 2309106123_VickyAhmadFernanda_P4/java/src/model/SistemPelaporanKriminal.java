package model;

public class SistemPelaporanKriminal extends SistemPelaporan {
    private String JenisKejahatan;

    public String getJenisKejahatan() {
        return JenisKejahatan;
    }
    
    public void setJenisKejahatan(String JenisKejahatan) {
        this.JenisKejahatan = JenisKejahatan;
    }
    @Override
    public void TampilkanData() {
        super.TampilkanData();
        System.out.println("Jenis Kejahatan: " + getJenisKejahatan());
    }
}
