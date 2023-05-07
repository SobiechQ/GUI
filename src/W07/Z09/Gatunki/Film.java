package W07.Z09.Gatunki;


import java.util.Objects;

/**
 * Abstract klasa Film, łączy wszystkie gatunki filmów które można wynająć.
 * Hermetyzuje niezmienne elementy między klasami dziedziczącymi
 * @see Dramat
 * @see Komedia
 * @see Obyczaj
 * @see Sensacja
 */

public abstract class Film {
    private final String tytul;
    private final int naIluUrzadzeniach;

    /**
     * @param tytul tytul filmu, uzywany do indeksowania filmu w mapie cennika.
     * @param naIluUrzadzeniach im wieksza liczba urządzeń tym większa cena.
     */
    public Film(String tytul, int naIluUrzadzeniach) {
        this.tytul = tytul;
        this.naIluUrzadzeniach = naIluUrzadzeniach;
    }

    public String getTytul() {
        return tytul;
    }

    public int getNaIluUrzadzeniach() {
        return naIluUrzadzeniach;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " (" +
                "tytul: " + tytul +
                ", maksymalnaLiczbaUrzadzen: " + naIluUrzadzeniach +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return naIluUrzadzeniach == film.naIluUrzadzeniach && Objects.equals(tytul, film.tytul);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tytul, naIluUrzadzeniach);
    }
}
