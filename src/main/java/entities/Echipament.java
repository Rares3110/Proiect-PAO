package entities;

public class Echipament {
    private int idEchipament;
    private int idSala;
    private int idAmbulanta;
    private String tipEchipament;
    private String stareEchipament;
    private double costAchizitionare;

    public Echipament(int idEchipament, int idSala, int idAmbulanta, String tipEchipament,
                      String stareEchipament, double costAchizitionare){
        this.idEchipament = idEchipament;
        this.idSala = idSala;
        this.idAmbulanta = idAmbulanta;
        this.tipEchipament = tipEchipament;
        this.stareEchipament = stareEchipament;
        this.costAchizitionare = costAchizitionare;
    }
    public void setIdEchipament(int idEchipament) {
        this.idEchipament = idEchipament;
    }
    public void setIdSala(int idSala){
        this.idSala = idSala;
    }
    public void setIdAmbulanta(int idAmbulanta){
        this.idAmbulanta = idAmbulanta;
    }
    public void setTipEchipament(String tipEchipament) {
        this.tipEchipament = tipEchipament;
    }
    public void setStareEchipament(String stareEchipament) {
        this.stareEchipament = stareEchipament;
    }
    public void setCostAchizitionare(double costAchizitionare) {
        this.costAchizitionare = costAchizitionare;
    }
    public int getIdEchipament() {
        return this.idEchipament;
    }
    public int getIdSala(){
        return this.idSala;
    }
    public int getIdAmbulanta(){
        return this.idAmbulanta;
    }
    public String getTipEchipament() {
        return this.tipEchipament;
    }
    public String getStareEchipament() {
        return this.stareEchipament;
    }
    public double getCostAchizitionare() {
        return this.costAchizitionare;
    }
}
