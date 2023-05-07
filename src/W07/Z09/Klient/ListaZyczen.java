package W07.Z09.Klient;

import W07.Z09.Gatunki.Film;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Nieuporządkowana lista, która przechowuje informacje o filmach którymi zainteresowany jest klient.
 * Filmy z tej listy mogą nie być dostępne, albo nie figurować w cenniku. Przed zakupem elementów z listy Życzeń
 * należy przepakować jej zawartośc do koszyka. dopoero podczas przepakowania sprawdzana jest dostępnośc filmów.
 * @see Koszyk
 * @see Koszyk#przepakuj()
 * @see Klient#zaplac(FormaPlatnosci, boolean)
 */

public class ListaZyczen implements Iterable<Film>{
    private final List<Film> films;
    private final Klient wlasciciel;
    /**
     * Lista trzyma informacje ktorymi zainteresowany jest klient. Konstruktor inicjowany inną listą która może na start zawierać już jakieś pozycje
     * @param films Lista, którą inicjujemy Listę Życzceń
     * @param wlasciciel klient względem którego będą wykonywane działania na liście życzeń
     */
    public ListaZyczen(List<Film> films, Klient wlasciciel) {
        this.films = films;
        this.wlasciciel = wlasciciel;
    }

    public boolean add(Film film) {
        return films.add(film);
    }

    public List<Film> getFilms() {
        return films;
    }

    @Override
    public Iterator<Film> iterator() {
        return films.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaZyczen films1 = (ListaZyczen) o;
        return Objects.equals(films, films1.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(films);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(this.wlasciciel.getImie()).append(':');
        if (this.films.isEmpty())
            return output.append("\n\t -----Lista życzeń jest pusta-----\n").toString();
        double koszt;
        for (Film film : this) {
            output.append("\n\t");
            try {
                koszt = Koszyk.kosztFilmuDlaKlienta(film, wlasciciel);
                output.append(film.toString()).append(", koszt dla klienta: ").append(koszt);
            } catch (KoszykException e) {
                output.append("Nie mozna obliczyc ceny filmu ").append(film).append(" ponieważ: ").append(e.getMessage());
            }
        }
        return output.append('\n').toString();
    }
}
