package Model;

public class Statistika implements Comparable<Statistika> {

    private String zanimanje;
    private int brojZaposlenih;
    private double prosecnaZarada;

    public Statistika(String zanimanje, int brojZaposlenih, double prosecnaZarada) {
        this.zanimanje = zanimanje;
        this.brojZaposlenih = brojZaposlenih;
        this.prosecnaZarada = prosecnaZarada;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    public int getBrojZaposlenih() {
        return brojZaposlenih;
    }

    public void setBrojZaposlenih(int brojZaposlenih) {
        this.brojZaposlenih = brojZaposlenih;
    }

    public double getProsecnaZarada() {
        return prosecnaZarada;
    }

    public void setProsecnaZarada(double prosecnaZarada) {
        this.prosecnaZarada = prosecnaZarada;
    }

    @Override
    public int compareTo(Statistika o) {

        if(this.prosecnaZarada != o.prosecnaZarada) return Double.compare(this.prosecnaZarada, o.prosecnaZarada) * -1;

        return Integer.compare(this.brojZaposlenih, o.brojZaposlenih) * -1;

    }

    @Override
    public String toString() {
        return zanimanje + " " + "(" + brojZaposlenih + ") - " + String.format("%.2f", prosecnaZarada);
    }
}
