package W07.Z09.Gatunki;

import java.util.Objects;

public abstract class Gatunek {
    private final String tytul;
    private final int maksymalnaLiczbaUrzadzen;

    public Gatunek(String tytul, int maksymalnaLiczbaUrzadzen) {
        this.tytul = tytul;
        this.maksymalnaLiczbaUrzadzen = maksymalnaLiczbaUrzadzen;
    }

    public String getTytul() {
        return tytul;
    }

    public int getMaksymalnaLiczbaUrzadzen() {
        return maksymalnaLiczbaUrzadzen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gatunek gatunek = (Gatunek) o;
        return maksymalnaLiczbaUrzadzen == gatunek.maksymalnaLiczbaUrzadzen && Objects.equals(tytul, gatunek.tytul);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass(), tytul, maksymalnaLiczbaUrzadzen);
    }

    @Override
    public String toString() {
        return this.getClass() + " {" +
                "tytul='" + tytul + '\'' +
                ", maksymalnaLiczbaUrzadzen=" + maksymalnaLiczbaUrzadzen +
                '}';
    }
}
