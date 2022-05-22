package Model;

import Controller.Server.Server;

public class Uplata extends Transakcija{

    private String uplatilac;

    public Uplata(int iznos, String datum, String uplatilac) {
        super(iznos, datum);
        this.uplatilac = uplatilac;
    }

    public String getUplatilac() {
        return uplatilac;
    }

    public void setUplatilac(String uplatilac) {
        this.uplatilac = uplatilac;
    }

    public String getTip(){

        return "UPLATA";

    }

    public String getUplatilacPrimalac(){

        return uplatilac;

    }

    public static int zbirSvihUplata(){

        int zbir = 0;

        for (Transakcija transakcija : Server.SERVER.getTransakcije()) {

            if(transakcija instanceof Uplata){

                zbir += ((Uplata)transakcija).getIznos();

            }

        }

        return zbir;

    }

}
