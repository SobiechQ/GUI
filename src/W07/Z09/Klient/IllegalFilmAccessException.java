package W07.Z09.Klient;

/**
 * Gdy film nie może zostać dodany z listy życzeń do koszyka. Exception posiada wiadomość o powodzie braku możliwości dodania do koszyka.
 * @see Koszyk#przepakuj()
 */
public class IllegalFilmAccessException extends Exception {
    public IllegalFilmAccessException(String message) {
        super(message);
    }
}
