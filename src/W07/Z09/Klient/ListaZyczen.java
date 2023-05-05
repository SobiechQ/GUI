package W07.Z09.Klient;

import W07.Z09.Gatunki.Film;

import java.util.Iterator;
import java.util.List;

public class ListaZyczen implements Iterable<Film>{
    private final List<Film> films;
    public ListaZyczen(List<Film> films) {
        this.films = films;
    }

    public boolean add(Film film) {
        return films.add(film);
    }

    @Override
    public String toString() {
        return "ListaZyczen{" +
                "films=" + films +
                '}';
    }

    public List<Film> getFilms() {
        return films;
    }

    @Override
    public Iterator<Film> iterator() {
        return films.iterator();
    }
}
