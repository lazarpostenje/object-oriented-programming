package Model;

import java.util.ArrayList;

public class Udzbenik {

    private int id;
    private int razred;
    private Izdavac izdavac;
    private String predmet;
    private String naslov;
    private final ArrayList<String> autori = new ArrayList<>();
    private double cena;
    private int brojPrimeraka;

    public Udzbenik(int id, int razred, Izdavac izdavac, String predmet, String naslov, double cena, int brojPrimeraka) {
        this.id = id;
        this.razred = razred;
        this.izdavac = izdavac;
        this.predmet = predmet;
        this.naslov = naslov;
        this.cena = cena;
        this.brojPrimeraka = brojPrimeraka;
    }

    public int getBrojPrimeraka() {
        return brojPrimeraka;
    }

    public void setBrojPrimeraka(int brojPrimeraka) {
        this.brojPrimeraka = brojPrimeraka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRazred() {
        return razred;
    }

    public void setRazred(int razred) {
        this.razred = razred;
    }

    public Izdavac getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(Izdavac izdavac) {
        this.izdavac = izdavac;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public ArrayList<String> getAutori() {
        return autori;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getNaziv(){

        return this.getIzdavac().getNaziv();

    }


}
