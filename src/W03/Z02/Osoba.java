package W03.Z02;

import java.util.Comparator;

public class Osoba implements Comparable<Osoba>{
    private String imie;
    private int wiek;

    public Osoba(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

    @Override
    public int compareTo(Osoba o) {
        return this.imie.compareTo(o.imie)!=0?
                this.imie.compareTo(o.imie):
                this.wiek - o.wiek;
    }

    @Override
    public String toString() {
        return "("+this.imie+", "+this.wiek+")";
    }

    public String getImie() {
        return imie;
    }

    public int getWiek() {
        return wiek;
    }
}
