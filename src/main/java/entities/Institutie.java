package entities;

public class Institutie {
    protected int idInstitutie;
    protected int idAutoritate;
    protected String nume;
    protected String adresa;
    protected String tipInstitutie;

    public Institutie(int idInstitutie, int idAutoritate, String nume, String adresa, String tipInstitutie) {
        this.idInstitutie = idInstitutie;
        this.idAutoritate = idAutoritate;
        this.nume = nume;
        this.adresa = adresa;
        this.tipInstitutie = tipInstitutie;
    }

    public void setIdInstitutie(int idInstitutie) {
        this.idInstitutie = idInstitutie;
    }
    public void setIdAutoritate(int idAutoritate) {
        this.idAutoritate = idAutoritate;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    public void setTipInstitutie(String tipInstitutie) {
        this.tipInstitutie = tipInstitutie;
    }
    public int getIdInstitutie() {
        return this.idInstitutie;
    }
    public int getIdAutoritate() {
        return this.idAutoritate;
    }
    public String getNume() {
        return this.nume;
    }
    public String getAdresa() {
        return this.adresa;
    }
    public String getTipInstitutie() {
        return this.tipInstitutie;
    }
}