package Model;

import Controller.Server.Server;

public class Isplata extends Transakcija{

    private String primalac;
    private String kategorija;

    public Isplata(int iznos, String datum, String primalac, String kategorija) {
        super(iznos, datum);
        this.primalac = primalac;
        this.kategorija = kategorija;
    }

    public String getPrimalac() {
        return primalac;
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getTip(){

        return "ISPLATA";

    }

    public String getUplatilacPrimalac(){

        return primalac;

    }

    public static int zbirSvihUplata(){

        int zbir = 0;

        for (Transakcija transakcija : Server.SERVER.getTransakcije()) {

            if(transakcija instanceof Isplata){

                zbir += ((Isplata)transakcija).getIznos();

            }

        }

        return zbir;

    }

}
