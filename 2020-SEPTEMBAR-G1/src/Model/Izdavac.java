package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Izdavac {

    private String naziv;
    private final ArrayList<Udzbenik> udzbenici = new ArrayList<>();

    public Izdavac(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public ArrayList<Udzbenik> getUdzbenici() {
        return udzbenici;
    }

    public ArrayList<Integer> getRazredi(){

        ArrayList<Integer> razredi = new ArrayList<>();

        for (Udzbenik udzbenik : udzbenici) {

            if(!razredi.contains(udzbenik.getRazred())) razredi.add(udzbenik.getRazred());

        }

        return razredi;

    }

    public int getBrojPrimeraka(){

        int brojPrimeraka = 0;

        for (Udzbenik udzbenik : udzbenici) {

            brojPrimeraka += udzbenik.getBrojPrimeraka();

        }

        return brojPrimeraka;

    }

    public double getProsecnaCena(){

        double brojRazlicitihUdzbenika = udzbenici.size();
        double ukupnaCena = 0;

        for (Udzbenik udzbenik : udzbenici) {

            ukupnaCena += udzbenik.getCena();

        }

        return Double.parseDouble(String.format("%.4f", ukupnaCena / brojRazlicitihUdzbenika));

    }

    @Override
    public String toString() {
        return this.naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Izdavac izdavac = (Izdavac) o;
        return Objects.equals(naziv, izdavac.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv);
    }
}
