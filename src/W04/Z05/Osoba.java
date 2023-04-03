package W04.Z05;

import java.util.Collection;
import java.util.Objects;

public class Osoba implements Comparable<Osoba>{
    public static boolean wKolekcji(Collection<Osoba> kol, String imie, int rokUrodzenia) {
        return kol.contains(new Osoba(imie, rokUrodzenia));
    }

    private String imie;
    private int rokUrodzenia;

    public Osoba(String imie, int rokUrodzenia) {
        this.imie = imie;
        this.rokUrodzenia = rokUrodzenia;
    }

    public String getImie() {
        return imie;
    }

    public int getRokUrodzenia() {
        return rokUrodzenia;
    }

    @Override
    public int compareTo(Osoba o) {
        return this.getImie().compareTo(o.getImie());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return rokUrodzenia == osoba.rokUrodzenia && Objects.equals(imie, osoba.imie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, rokUrodzenia);
    }


}
