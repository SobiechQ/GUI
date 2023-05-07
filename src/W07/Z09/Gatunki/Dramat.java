package W07.Z09.Gatunki;

/**
 * Gatunek filmu, dziedziczy po klasie abstrakcyjnej Film
 * @see Film
 */
public class Dramat extends Film {
    /**
     * @param tytul tytul filmu, uzywany do indeksowania filmu w mapie cennika.
     * @param naIluUrzadzeniach im wieksza liczba urządzeń tym większa cena.
     */
    public Dramat(String tytul, int naIluUrzadzeniach) {
        super(tytul, naIluUrzadzeniach);
    }
}
