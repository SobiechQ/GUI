package W07.Z09.Klient;

/**
 * Gdy film nie może zostać dodany z listy życzeń do koszyka. Exception posiada wiadomość o powodzie braku możliwości dodania do koszyka.
 * @see Koszyk#przepakuj()
 */
public class KoszykException extends Exception {
    public KoszykException(String message) {
        super(message);
    }
}
