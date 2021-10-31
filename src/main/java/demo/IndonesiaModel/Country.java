package demo.IndonesiaModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

    @JsonProperty("AMAMAPARE")
    private Port amamapare;

    @JsonProperty("AMAMAPARE, IJ")
    private Port amamapareIj;

    @JsonProperty("AMBON")
    private Port ambon;

    @JsonProperty("AMURANG")
    private Port amurang;

    @JsonProperty("ATAMBUA (U)")
    private Port atambuaU;

    @JsonProperty("ATAPUPU")
    private Port atapupu;

    @JsonProperty("BALANTANG/MALILI")
    private Port balantang;

    @JsonProperty("BALIKPAPAN")
    private Port balikpapan;

    @JsonProperty("BALONGAN")
    private Port balongan;

    @JsonProperty("BANGGAI")
    private Port banggai;

    @JsonProperty("BANJARMASIN")
    private Port banjarmasin;

    @JsonProperty("BANYUWANGI")
    private Port banyuwangi;

    @JsonProperty("BATU AMPAR")
    private Port batuampar;

    @JsonProperty("BAU-BAU")
    private Port baubau;

    @JsonProperty("BELAWAN")
    private Port belawan;

    @JsonProperty("BELINJU")
    private Port belinju;

    @JsonProperty("BENGKALIS")
    private Port bengkalis;

    @JsonProperty("BINTUNI, IRIAN JAYA")
    private Port bintuni;

    @JsonProperty("BITUNG")
    private Port bitung;

    @JsonProperty("BONTANG")
    private Port bontang;

    @JsonProperty("BUATAN")
    private Port buatan;

    @JsonProperty("BULA")
    private Port bula;

    @JsonProperty("CILACAP")
    private Port cilacap;

    @JsonProperty("CINTA, JAVA")
    private Port cinta;

    @JsonProperty("CIWANDAN")
    private Port ciwandan;

    @JsonProperty("DUMAI")
    private Port dumai;

    @JsonProperty("FUTONG TERMINAL")
    private Port futongTerminal;

    @JsonProperty("GRESIK")
    private Port gresik;

    @JsonProperty("HANG NADIM (U)")
    private Port hangNadimU;

    @JsonProperty("JAYAPURA")
    private Port jayapura;

    @JsonProperty("KABIL/PANAU")
    private Port kabilPanau;

    @JsonProperty("KALBUT SITUBONDO")
    private Port kalbutSitubondo;

    @JsonProperty("KALIANGET")
    private Port kalianget;

    @JsonProperty("KARIANGAU")
    private Port kariangau;

    @JsonProperty("KOTABARU")
    private Port kotabaru;

    @JsonProperty("KOTABARU (U)")
    private Port kotabaruU;

    @JsonProperty("KUPANG / EL-TARI (U)")
    private Port kupangU;

    @JsonProperty("LALANG TERMINAL, ST")
    private Port lalangTerminal;

    @JsonProperty("LAWE-LAWE, KL")
    private Port lawelawe;

    @JsonProperty("LOBAM")
    private Port lobam;

    @JsonProperty("LONG BAWAN (U)")
    private Port longBawanU;

    @JsonProperty("LUWUK")
    private Port luwuk;

    @JsonProperty("MAKASSAR")
    private Port makassar;

    @JsonProperty("MALILI, SULAWESI")
    private Port malili;

    @JsonProperty("MERAK")
    private Port merak;

    @JsonProperty("MUARA SABAK")
    private Port muaraSabak;

    @JsonProperty("MUNTOK")
    private Port muntok;

    @JsonProperty("MUSI RIVER/BOOM BARU")
    private Port musiRiverBB;

    @JsonProperty("NGURAH RAI (U)")
    private Port ngurahrai;

    @JsonProperty("NUNUKAN")
    private Port NUNUKAN;

    @JsonProperty("PADANG/TL.BAYUR")
    private Port padang;

    @JsonProperty("PALEMBANG - PLAJU")
    private Port palembang;

    @JsonProperty("PANJANG")
    private Port panjang;

    @JsonProperty("PERAWANG, SUMATRA")
    private Port perawang;

    @JsonProperty("PONTIANAK")
    private Port pontianak;

    @JsonProperty("PULAU LAUT")
    private Port pulauLaut;

    @JsonProperty("SAMARINDA")
    private Port samarinda;

    @JsonProperty("SANGGATA (U)")
    private Port sanggataU;

    @JsonProperty("SANTAN TERMINAL, KL")
    private Port santanTerminal;

    @JsonProperty("SEKUPANG")
    private Port sekupang;

    @JsonProperty("SEMANGKA BAY, ST")
    private Port semangkabay;

    @JsonProperty("SENIPAH")
    private Port senipah;

    @JsonProperty("SOEKARNO-HATTA (U)")
    private Port seokarnohatta;

    @JsonProperty("SUPADIO (U)")
    private Port supadioU;

    @JsonProperty("TANJUNG BALAI KARIMUN")
    private Port tanjungbalaikarimun;

    @JsonProperty("TANJUNG BARA, KL")
    private Port tanjungbara;

    @JsonProperty("TANJUNG EMAS")
    private Port tanjungemas;

    @JsonProperty("TANJUNG LENENG")
    private Port tanjungleneng;

    @JsonProperty("TANJUNG PERAK")
    private Port tanjungperak;

    @JsonProperty("TANJUNG PRIOK")
    private Port tanjungpriok;

    @JsonProperty("TANJUNG SANGATA")
    private Port tanjungsangata;

    @JsonProperty("TANJUNG UBAN")
    private Port tanjunguban;

    @JsonProperty("TENAU")
    private Port tenau;

    @JsonProperty("TEREMPA")
    private Port terempa;

    @JsonProperty("TUBAN")
    private Port tuban;

    @JsonProperty("TULEHU")
    private Port tulehu;

    @JsonProperty("UDANG NATUNA")
    private Port udangNatuna;

    @JsonProperty("WIDURI")
    private Port widuri;


    public Country() {
    }

    public Country(Port ambon, Port balikpapan, Port cilacap, Port semangkabay,
                   Port balongan, Port ngurahrai, Port batuampar, Port banyuwangi,
                   Port seokarnohatta, Port tanjungperak, Port tanjungpriok,
                   Port dumai, Port muntok, Port kalianget, Port kotabaru, Port kotabaruU,
                   Port tanjungbalaikarimun, Port tuban, Port belawan, Port sekupang, Port merak,
                   Port tanjunguban, Port tanjungemas, Port makassar) {
        this.ambon = ambon;
        this.balikpapan = balikpapan;
        this.banyuwangi = banyuwangi;
        this.belawan = belawan;
        this.cilacap = cilacap;
        this.semangkabay = semangkabay;
        this.balongan = balongan;
        this.ngurahrai = ngurahrai;
        this.batuampar = batuampar;
        this.sekupang = sekupang;
        this.seokarnohatta = seokarnohatta;
        this.tanjungperak = tanjungperak;
        this.tanjungpriok = tanjungpriok;
        this.dumai = dumai;
        this.makassar = makassar;
        this.merak = merak;
        this.muntok = muntok;
        this.kalianget = kalianget;
        this.tanjungbalaikarimun = tanjungbalaikarimun;
        this.tanjungemas = tanjungemas;
        this.tanjunguban = tanjunguban;
        this.tuban = tuban;
        this.kotabaru = kotabaru;
        this.kotabaruU = kotabaruU;
    }

    public Port getAmbon() {
        return ambon;
    }

    public void setAmbon(Port ambon) {
        this.ambon = ambon;
    }

    public Port getBalikpapan() {
        return balikpapan;
    }

    public void setBalikpapan(Port balikpapan) {
        this.balikpapan = balikpapan;
    }

    public Port getBaubau() {
        return baubau;
    }

    public void setBaubau(Port baubau) {
        this.baubau = baubau;
    }

    public Port getBanyuwangi() {
        return banyuwangi;
    }

    public void setBanyuwangi(Port banyuwangi) {
        this.banyuwangi = banyuwangi;
    }

    public Port getBelawan() {
        return belawan;
    }

    public void setBelawan(Port belawan) {
        this.belawan = belawan;
    }

    public Port getCilacap() {
        return cilacap;
    }

    public void setCilacap(Port cilacap) {
        this.cilacap = cilacap;
    }

    public Port getSemangkabay() {
        return semangkabay;
    }

    public void setSemangkabay(Port semangkabay) {
        this.semangkabay = semangkabay;
    }

    public Port getBalongan() {
        return balongan;
    }

    public void setBalongan(Port balongan) {
        this.balongan = balongan;
    }

    public Port getNgurahrai() {
        return ngurahrai;
    }

    public void setNgurahrai(Port ngurahrai) {
        this.ngurahrai = ngurahrai;
    }

    public Port getBatuampar() {
        return batuampar;
    }

    public void setBatuampar(Port batuampar) {
        this.batuampar = batuampar;
    }

    public Port getSekupang() {
        return sekupang;
    }

    public void setSekupang(Port sekupang) {
        this.sekupang = sekupang;
    }

    public Port getSeokarnohatta() {
        return seokarnohatta;
    }

    public void setSeokarnohatta(Port seokarnohatta) {
        this.seokarnohatta = seokarnohatta;
    }

    public Port getTanjungperak() {
        return tanjungperak;
    }

    public void setTanjungperak(Port tanjungperak) {
        this.tanjungperak = tanjungperak;
    }

    public Port getTanjungpriok() {
        return tanjungpriok;
    }

    public void setTanjungpriok(Port tanjungpriok) {
        this.tanjungpriok = tanjungpriok;
    }

    public Port getDumai() {
        return dumai;
    }

    public void setDumai(Port dumai) {
        this.dumai = dumai;
    }

    public Port getMuntok() {
        return muntok;
    }

    public void setMuntok(Port muntok) {
        this.muntok = muntok;
    }

    public Port getKalianget() {
        return kalianget;
    }

    public void setKalianget(Port kalianget) {
        this.kalianget = kalianget;
    }

    public Port getKotabaru() {
        return kotabaru;
    }

    public void setKotabaru(Port kotabaru) {
        this.kotabaru = kotabaru;
    }

    public Port getKotabaruU() {
        return kotabaruU;
    }

    public void setKotabaruU(Port kotabaruU) {
        this.kotabaruU = kotabaruU;
    }

    public Port getMerak() {
        return merak;
    }

    public void setMerak(Port merak) {
        this.merak = merak;
    }

    public Port getTanjungbalaikarimun() {
        return tanjungbalaikarimun;
    }

    public void setTanjungbalaikarimun(Port tanjungbalaikarimun) {
        this.tanjungbalaikarimun = tanjungbalaikarimun;
    }

    public Port getTanjungemas() {
        return tanjungemas;
    }

    public void setTanjungemas(Port tanjungemas) {
        this.tanjungemas = tanjungemas;
    }

    public Port getTanjunguban() {
        return tanjunguban;
    }

    public void setTanjunguban(Port tanjunguban) {
        this.tanjunguban = tanjunguban;
    }

    public Port getTuban() {
        return tuban;
    }

    public void setTuban(Port tuban) {
        this.tuban = tuban;
    }

    public Port getMakassar() {
        return makassar;
    }

    public void setMakassar(Port makassar) {
        this.makassar = makassar;
    }

    @Override
    public String toString() {
        return "Country{" +
                "ambon=" + ambon +
                ", balikpapan=" + balikpapan +
                ", balongan=" + balongan +
                ", banyuwangi=" + banyuwangi +
                ", batuampar=" + batuampar +
                ", baubau=" + baubau +
                ", belawan=" + belawan +
                ", cilacap=" + cilacap +
                ", dumai=" + dumai +
                ", kalianget=" + kalianget +
                ", kotabaru=" + kotabaru +
                ", kotabaruU=" + kotabaruU +
                ", kotabaruU=" + kotabaruU +
                ", makassar=" + makassar +
                ", merak=" + merak +
                ", muntok=" + muntok +
                ", ngurahrai=" + ngurahrai +
                ", sekupang=" + sekupang +
                ", semangkabay=" + semangkabay +
                ", seokarnohatta=" + seokarnohatta +
                ", tanjungbalaikarimun=" + tanjungbalaikarimun +
                ", tanjungemas=" + tanjungemas +
                ", tanjungperak=" + tanjungperak +
                ", tanjungpriok=" + tanjungpriok +
                ", tanjunguban=" + tanjunguban +
                ", tuban=" + tuban +
                '}';
    }
}
