package entities;

import databaseUtils.Date;

public class Angajat {
    protected int idAngajat;
    protected int idInstitutie;
    protected String nume;
    protected String prenume;
    protected double salariu;
    protected Date dataAngajare;
    protected String denumireJob;

    public Angajat(int idAngajat, int idInstitutie, String nume,
                   String prenume, double salariu, Date dataAngajare, String denumireJob){
        this.idAngajat = idAngajat;
        this.idInstitutie = idInstitutie;
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
        this.dataAngajare = dataAngajare;
        this.denumireJob = denumireJob;
    }
    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }
    public void setIdInstitutie(int idInstitutie) {
        this.idInstitutie = idInstitutie;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public void setSalariu(double salariu){
        this.salariu = salariu;
    }
    public void setDataAngajare(Date dataAngajare){
        this.dataAngajare = dataAngajare;
    }
    public void setDenumireJob(String denumireJob){
        this.denumireJob = denumireJob;
    }
    public int getIdAngajat() {
        return this.idAngajat;
    }
    public int getIdInstitutie() {
        return this.idInstitutie;
    }
    public String getNume(){
        return this.nume;
    }
    public String getPrenume(){
        return this.prenume;
    }
    public double getSalariu(){
        return this.salariu;
    }
    public Date getDataAngajare(){
        return this.dataAngajare;
    }
    public String getDenumireJob(){
        return this.denumireJob;
    }
}
