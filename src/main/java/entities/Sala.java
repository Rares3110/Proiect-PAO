package entities;

public class Sala {
    private int idSala;
    private int idInstitutie;
    private String tipSala;
    private double spatiuSala;
    private int etaj;

    public Sala(int idSala, int idInstitutie, String tipSala, double spatiuSala, int etaj){
        this.idSala = idSala;
        this.idInstitutie = idInstitutie;
        this.tipSala = tipSala;
        this.spatiuSala = spatiuSala;
        this.etaj = etaj;
    }
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }
    public void setIdInstitutie(int idInstitutie) {
        this.idInstitutie = idInstitutie;
    }
    public void setTipSala(String tipSala) {
        this.tipSala = tipSala;
    }
    public void setSpatiuSala(double spatiuSala) {
        this.spatiuSala = spatiuSala;
    }
    public void setEtaj(int etaj) {
        this.etaj = etaj;
    }
    public int getIdSala() {
        return this.idSala;
    }
    public int getIdInstitutie() {
        return this.idInstitutie;
    }
    public String getTipSala() {
        return this.tipSala;
    }
    public double getSpatiuSala() {
        return this.spatiuSala;
    }
    public int getEtaj() {
        return this.etaj;
    }
}
