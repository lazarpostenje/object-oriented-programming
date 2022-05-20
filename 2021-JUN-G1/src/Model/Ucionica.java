package Model;

import java.util.ArrayList;

public class Ucionica {

    private String naziv;
    private boolean amfiteatar;
    private boolean racunari;
    private ArrayList<Student> studenti = new ArrayList<>();
    private static int kapacitetUcionica;
    private static int kapacitetAmfiteatar;

    public ArrayList<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(ArrayList<Student> studenti) {
        this.studenti = studenti;
    }

    public static int getKapacitetUcionica() {
        return kapacitetUcionica;
    }

    public static void setKapacitetUcionica(int kapacitetUcionica) {
        Ucionica.kapacitetUcionica = kapacitetUcionica;
    }

    public static int getKapacitetAmfiteatar() {
        return kapacitetAmfiteatar;
    }

    public static void setKapacitetAmfiteatar(int kapacitetAmfiteatar) {
        Ucionica.kapacitetAmfiteatar = kapacitetAmfiteatar;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isAmfiteatar() {
        return amfiteatar;
    }

    public void setAmfiteatar(boolean amfiteatar) {
        this.amfiteatar = amfiteatar;
    }

    public boolean isRacunari() {
        return racunari;
    }

    public void setRacunari(boolean racunari) {
        this.racunari = racunari;
    }

    public Ucionica(String naziv, boolean amfiteatar, boolean racunari) {
        this.naziv = naziv;
        this.amfiteatar = amfiteatar;
        this.racunari = racunari;
    }

    @Override
    public String toString() {
        if(racunari) return naziv + "(R) - " + (Ucionica.kapacitetUcionica - this.studenti.size());
        else if(amfiteatar) return naziv + "(A) - " + (Ucionica.kapacitetAmfiteatar - this.studenti.size());
        return naziv + " - " + (Ucionica.kapacitetUcionica - this.studenti.size());
    }

    public boolean dodajStudenta(Student s){

        if(this.isAmfiteatar() && kapacitetAmfiteatar <= studenti.size()) return false;
        else if(kapacitetUcionica <= studenti.size()) return false;

        this.studenti.add(s);
        return true;

    }

}
