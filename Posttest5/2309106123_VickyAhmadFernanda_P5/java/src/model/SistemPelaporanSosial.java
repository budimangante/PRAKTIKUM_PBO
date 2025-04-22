package model;
public class SistemPelaporanSosial extends SistemPelaporan {
    private String dampakSosial;

    public SistemPelaporanSosial(final String tanggalPelaporan) {
        super(tanggalPelaporan);
    }

    public String getDampakSosial() {
        return dampakSosial;
    }

    public void setDampakSosial(String dampakSosial) {
        this.dampakSosial = dampakSosial;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("Dampak Sosial: " + dampakSosial);
    }
}
