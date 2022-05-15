package entities;

import databaseUtils.Date;

public class Programare implements Comparable<Programare> {
    private int idProgramare;
    private int idPacient;
    private int idAngajat;
    private int idSala;
    private Date zi;
    private String oraStart;
    private String oraIncheiat;

    public Programare(int idProgramare, int idPacient, int idAngajat, int idSala,
                      Date zi, String oraStart, String oraIncheiat){
        this.idProgramare = idProgramare;
        this.idPacient = idPacient;
        this.idAngajat = idAngajat;
        this.idSala = idSala;
        this.zi = zi;
        this.oraStart = oraStart;
        this.oraIncheiat = oraIncheiat;
    }
    public void setIdProgramare(int idProgramare) {
        this.idProgramare = idProgramare;
    }
    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }
    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }
    public void setZi(Date zi) {
        this.zi = zi;
    }
    public void setOraStart(String oraStart) {
        this.oraStart = oraStart;
    }
    public void setOraIncheiat(String oraIncheiat) {
        this.oraIncheiat = oraIncheiat;
    }
    public int getIdProgramare() {
        return this.idProgramare;
    }
    public int getIdPacient() {
        return this.idPacient;
    }
    public int getIdAngajat() {
        return this.idAngajat;
    }
    public int getIdSala() {
        return this.idSala;
    }
    public Date getZi() {
        return this.zi;
    }
    public String getOraStart() {
        return this.oraStart;
    }
    public String getOraIncheiat() {
        return this.oraIncheiat;
    }

    @Override
    public int compareTo(Programare o) {
        return this.zi.compareTo(o.zi);
    }
}
