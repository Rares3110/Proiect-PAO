package entities;

import databaseUtils.Date;

public class Pacient implements Comparable<Pacient> {
    private int idPacient;
    private String nume;
    private String prenume;
    private Date ziNastere;

    public Pacient(int idPacient, String nume, String prenume, Date ziNastere) {
        this.idPacient = idPacient;
        this.nume = nume;
        this.prenume = prenume;
        this.ziNastere = ziNastere;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public void setZiNastere(Date ziNastere) {
        this.ziNastere = ziNastere;
    }
    public int getIdPacient() {
        return this.idPacient;
    }
    public String getNume() {
        return this.nume;
    }
    public String getPrenume() {
        return this.prenume;
    }
    public Date getZiNastere() {
        return this.ziNastere;
    }
    public int compareTo(Pacient o) {
        return this.ziNastere.compareTo(o.ziNastere);
    }
}
