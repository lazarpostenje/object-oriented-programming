package Model;

public class Student implements Comparable<Student> {

    private String ime;
    private String prezime;
    private Smer smer;
    private int brojUpisa;
    private int godinaUpisa;
    private String termin;
    private Ucionica ucionica;

    public String getTermin() {
        return termin;
    }

    public void setTermin(String termin) {
        this.termin = termin;
    }

    public Ucionica getUcionica() {
        return ucionica;
    }

    public void setUcionica(Ucionica ucionica) {
        this.ucionica = ucionica;
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

    public Student(Smer smer, int brojUpisa, int godinaUpisa, String prezime, String ime) {
        this.ime = ime;
        this.prezime = prezime;
        this.smer = smer;
        this.brojUpisa = brojUpisa;
        this.godinaUpisa = godinaUpisa;
    }

    @Override
    public String toString() {

        return ime + " " + prezime + " " + brojUpisa + "/" + smer + "-" + godinaUpisa;

    }

    public String getPrikazImenaZaTabelu(){

        return ime + " " + prezime + " " + brojUpisa + "/" + smer + "-" + godinaUpisa;

    }

    public String getPrikazUcioniceZaTabelu(){

        return ucionica.getNaziv();

    }

    @Override
    public int compareTo(Student o) {

        if(this.termin.equals(o.termin) == false) return this.termin.compareTo(o.termin);

        return this.ucionica.getNaziv().compareTo(o.ucionica.getNaziv());

    }
}
