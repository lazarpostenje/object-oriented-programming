package Model;

public abstract class Transakcija {

    private int iznos;
    private String datum;

    public Transakcija(int iznos, String datum) {
        this.iznos = iznos;
        this.datum = datum;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Transakcija{" +
                "iznos=" + iznos +
                ", datum='" + datum + '\'' +
                '}';
    }

}
