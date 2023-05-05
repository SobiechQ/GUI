package W07.Z09.Gatunki;


import java.util.Objects;

public abstract class Film {
    private final String tytul;
    private final int maksymalnaLiczbaUrzadzen;

    public Film(String tytul, int maksymalnaLiczbaUrzadzen) {
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
        Film film = (Film) o;
        return maksymalnaLiczbaUrzadzen == film.maksymalnaLiczbaUrzadzen && Objects.equals(tytul, film.tytul);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass(), tytul, maksymalnaLiczbaUrzadzen);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "tytul='" + tytul + '\'' +
                ", maksymalnaLiczbaUrzadzen=" + maksymalnaLiczbaUrzadzen +
                '}';
    }

}
