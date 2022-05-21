package Model;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class Ucionica {

    private String naziv;
    private int kapacitet;
    private int termin;
    private final ArrayList<Student> studenti = new ArrayList<>();

    public Ucionica(String naziv, int kapacitet, int termin) {
        this.naziv = naziv;
        this.kapacitet = kapacitet;
        this.termin = termin;
    }

    public ArrayList<Student> getStudenti() {
        return studenti;
    }

    public int getTermin() {
        return termin;
    }

    public void setTermin(int termin) {
        this.termin = termin;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ucionica ucionica = (Ucionica) o;
        return termin == ucionica.termin && Objects.equals(naziv, ucionica.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naziv, termin);
    }

    public int getBrojSlobodnihMesta(){

        if(kapacitet - studenti.size() < 0) return 0;
        else return kapacitet - studenti.size();

    }

    public int getBrojPrekoracenihMesta(){

        if(kapacitet - studenti.size() < 0) return Math.abs(kapacitet - studenti.size());
        else return 0;

    }

    public int getBrojStudenata(){

        return studenti.size();

    }

    @Override
    public String toString() {
        return naziv;
    }

    public boolean dodajStudente(ObservableList<Student> noviStudenti){

        if(this.getBrojSlobodnihMesta() < noviStudenti.size()) return false;
        else {

            this.studenti.addAll(noviStudenti);
            return true;

        }

    }

}
