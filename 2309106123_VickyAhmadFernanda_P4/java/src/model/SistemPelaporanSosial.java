package model;

public class SistemPelaporanSosial extends SistemPelaporan {
    private String DampakSosial;

    public String getDampakSosial() {
        return DampakSosial;
    }

    public void setDampakSosial(String DampakSosial) {
        this.DampakSosial = DampakSosial;
    }

    @Override
    public void TampilkanData() {
        super.TampilkanData();
        System.out.println("Dampak Sosial: " + getDampakSosial());
    }
}

