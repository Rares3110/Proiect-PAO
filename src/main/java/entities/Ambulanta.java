package entities;

public class Ambulanta {
    private int idAmbulanta;
    private int anAchizitionare;
    private String stareAmbulanta;
    private double costAchizitionare;

    public Ambulanta(int idAmbulanta, int anAchizitionare, String stareAmbulanta, double costAchizitionare){
        this.idAmbulanta = idAmbulanta;
        this.anAchizitionare = anAchizitionare;
        this.stareAmbulanta = stareAmbulanta;
        this.costAchizitionare = costAchizitionare;
    }

    public void setIdAmbulanta(int idAmbulanta) {
        this.idAmbulanta = idAmbulanta;
    }
    public void setAnAchizitionare(int anAchizitionare) {
        this.anAchizitionare = anAchizitionare;
    }
    public void setStareAmbulanta(String stareAmbulanta) {
        this.stareAmbulanta = stareAmbulanta;
    }
    public void setCostAchizitionare(double costAchizitionare) {
        this.costAchizitionare = costAchizitionare;
    }
    public int getIdAmbulanta() {
        return this.idAmbulanta;
    }
    public int getAnAchizitionare() {
        return this.anAchizitionare;
    }
    public String getStareAmbulanta() {
        return this.stareAmbulanta;
    }
    public double getCostAchizitionare() {
        return this.costAchizitionare;
    }
}
