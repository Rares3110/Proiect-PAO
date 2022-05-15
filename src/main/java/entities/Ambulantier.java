package entities;

import databaseUtils.Date;

public class Ambulantier extends Angajat {
    private int idAmbulanta;

    public Ambulantier(int idAngajat, int idInstitutie, String nume, String prenume, double salariu, Date dataAngajare, String denumireJob, int idAmbulanta) {
        super(idAngajat, idInstitutie, nume, prenume, salariu, dataAngajare, denumireJob);
        this.idAmbulanta = idAmbulanta;
    }

    public void setIdAmbulanta(int idAmbulanta) {
        this.idAmbulanta = idAmbulanta;
    }
    public int getIdAmbulanta() {
        return this.idAmbulanta;
    }
}