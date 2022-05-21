package Model;

public class Student implements Comparable<Student> {

    private String ime;
    private String prezime;
    private Smer smer;
    private int brojUpisa;
    private int godinaUpisa;
    private int termin;
    private String ucionica;

    public Student(String ime, String prezime, Smer smer, int brojUpisa, int godinaUpisa, int termin, String ucionica) {
        this.ime = ime;
        this.prezime = prezime;
        this.smer = smer;
        this.brojUpisa = brojUpisa;
        this.godinaUpisa = godinaUpisa;
        this.termin = termin;
        this.ucionica = ucionica;
    }

    public int getBrojUpisa() {
        return brojUpisa;
    }

    public void setBrojUpisa(int brojUpisa) {
        this.brojUpisa = brojUpisa;
    }

    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
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

    public Smer getSmer() {
        return smer;
    }

    public void setSmer(Smer smer) {
        this.smer = smer;
    }

    public int getTermin() {
        return termin;
    }

    public void setTermin(int termin) {
        this.termin = termin;
    }

    public String getUcionica() {
        return ucionica;
    }

    public void setUcionica(String ucionica) {
        this.ucionica = ucionica;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " " + brojUpisa + "/" + smer + "-" + godinaUpisa;
    }

    @Override
    public int compareTo(Student o) {
        if(this.termin != o.termin) return Integer.compare(this.termin, o.termin);

        return this.ucionica.compareTo(o.ucionica);
    }
}
