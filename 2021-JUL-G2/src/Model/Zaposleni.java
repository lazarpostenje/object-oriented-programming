package Model;

import Controller.Server.Server;

import java.time.LocalDate;

public class Zaposleni {

    private String ime;
    private String prezime;
    private String jmbg;
    private int godinaZaposlenja;
    private String zanimanje;

    private static int cenaRada = 0;

    public Zaposleni(String ime, String prezime, String jmbg, int godinaZaposlenja, String zanimanje) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.godinaZaposlenja = godinaZaposlenja;
        this.zanimanje = zanimanje;
    }

    public static int getCenaRada() {
        return cenaRada;
    }

    public static void setCenaRada(int cenaRada) {
        Zaposleni.cenaRada = cenaRada;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public int getGodinaZaposlenja() {
        return godinaZaposlenja;
    }

    public void setGodinaZaposlenja(int godinaZaposlenja) {
        this.godinaZaposlenja = godinaZaposlenja;
    }

    public double getPlata(){

        double platniKoeficijent = Server.SERVER.getZanimanja().get(this.zanimanje);

        return Math.round(Zaposleni.cenaRada * (platniKoeficijent + 0.05 * (LocalDate.now().getYear() - this.godinaZaposlenja)));


    }

}
