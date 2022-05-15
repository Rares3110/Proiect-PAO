package entities;

public class Spital extends Institutie {
    private String specializare;
    private int idAmbulatoriu;

    public Spital(int idInstitutie, int idAutoritate, String nume, String adresa, String tipInstitutie, String specializare, int idAmbulatoriu) {
        super(idInstitutie, idAutoritate, nume, adresa, tipInstitutie);
        this.specializare = specializare;
        this.idAmbulatoriu = idAmbulatoriu;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }
    public void setIdAmbulatoriu(int idAmbulatoriu) {
        this.idAmbulatoriu = idAmbulatoriu;
    }
    public String getSpecializare() {
        return this.specializare;
    }
    public int getIdAmbulatoriu() {
        return this.idAmbulatoriu;
    }
}