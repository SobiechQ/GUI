package W07.Z09.Klient;

import W07.Z09.Cennik.Cennik;
import W07.Z09.Gatunki.Film;

import java.util.*;

public class Koszyk implements Iterable<Film>{
    private final Klient wlasciciel;
    private final Set<Film> films;

    public Koszyk(Klient wlasciciel) {
        this(wlasciciel, new ArrayList<>());
    }
    public Koszyk(Klient wlasciciel, List<Film> films) {
        this.wlasciciel = wlasciciel;
        this.wlasciciel.setKoszyk(this);


        //poprzez dodadnie do tree set ustawiam że wszystkie podane filmy będą sortowane w danej kolejności.
        //delegowanie konstruktora pozwala tworzyć puste koszyki, oraz nowe koszyki inicjowane już jakąś (nieposortowaną wcześniej) kolekcją
        //która jest sortowana przy tworzeniu koszyka.
        TreeSet<Film> filmTreeSet = new TreeSet<>((o1, o2) -> {
            try {
                return kosztFilmuDlaKlienta(o1) - kosztFilmuDlaKlienta(o2);
            } catch (KoszykException e) {
                throw new RuntimeException(e);
            }
        });
        filmTreeSet.addAll(films);
        this.films = filmTreeSet;
    }

    /**
     * Dodaje do kosztyka tylko te elementy, na które stać i do których ma dostęp klient.
     */
    public void przepakuj(){
        for (Film film : this.wlasciciel.pobierzListeZyczen()) {
            if (Cennik.pobierzCennik().getRecordByKeyFilm(film).isPresent() &&
                    (this.wlasciciel.isCzyMaAbonament() || Cennik.pobierzCennik().getRecordByKeyFilm(film).get().czyMoznaPozaAbonamentem()))
                //Sprawdzam czy film znajduje się w cenniku ORAZ czy klient ma dostęp do filmu.
                films.add(film);
                //wpp film nie jest dodawany do koszyka
        }
    }
    
    /**
     * Róźni klienci płacą różne ceny za ten sam film.
     */
    public int kosztFilmuDlaKlienta(Film film) throws KoszykException {
        if (Cennik.pobierzCennik().getRecordByKeyFilm(film).isEmpty())
            throw new KoszykException("Film nie wystepuje w cenniku");
        if (!(Cennik.pobierzCennik().getRecordByKeyFilm(film).get().czyMoznaPozaAbonamentem()||wlasciciel.isCzyMaAbonament()))
            throw new KoszykException("Film dostepny tylko dla klientów posiadających abonament");

        int koszt = 0;
        for (int i = 0; i < film.getMaksymalnaLiczbaUrzadzen(); i++) {
             koszt += i >= Cennik.pobierzCennik().getRecordByKeyFilm(film).get().maksLiczbUrzadzen() ?
                        wlasciciel.isCzyMaAbonament() ?
                            Cennik.pobierzCennik().getRecordByKeyFilm(film).get().cenaPakietAbo():
                            Cennik.pobierzCennik().getRecordByKeyFilm(film).get().cenaPakietBezAbo():
                         wlasciciel.isCzyMaAbonament() ?
                            Cennik.pobierzCennik().getRecordByKeyFilm(film).get().cenaBezPakietAbo():
                            Cennik.pobierzCennik().getRecordByKeyFilm(film).get().cenaBezPakietBezAbo();
        }
        return koszt;
    }

    @Override
    public Iterator<Film> iterator() {
        return this.films.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Koszyk koszyk = (Koszyk) o;
        return Objects.equals(wlasciciel, koszyk.wlasciciel) && Objects.equals(films, koszyk.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wlasciciel, films);
    }

    @Override
    public String toString() {
        return "Koszyk{" +
                ", films=" + films +
                '}';
    }

    public Set<Film> getFilms() {
        return films;
    }
}
