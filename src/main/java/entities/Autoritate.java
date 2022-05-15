package entities;

public class Autoritate implements Comparable<Autoritate> {
    private int idAutoritate;
    private String nume;
    private String judet;

    public Autoritate(int idAutoritate, String nume, String judet) {
        this.idAutoritate = idAutoritate;
        this.nume = nume;
        this.judet = judet;
    }

    public void setIdAutoritate(int idAutoritate) {
        this.idAutoritate = idAutoritate;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setJudet(String judet) {
        this.judet = judet;
    }
    public int getIdAutoritate() {
        return this.idAutoritate;
    }
    public String getNume() {
        return this.nume;
    }
    public String getJudet() {
        return this.judet;
    }

    public int compareTo(Autoritate o) {
        return this.nume.compareTo(o.nume);
    }
}