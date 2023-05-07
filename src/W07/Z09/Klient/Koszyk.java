package W07.Z09.Klient;

import W07.Z09.Cennik.Cennik;
import W07.Z09.Gatunki.Film;

import java.util.*;

/**
 * Uporządkowana i sprawdzona lista filmów.
 * Filmy są uporządkowane w kolejności od najtańszych dla danego klienta do najdroższych.
 * Wszystkie pozycje z koszyka to materiały dostępne dla Klienta.
 */
public class Koszyk implements Iterable<Film>{
    private final Klient wlasciciel;
    private final Set<Film> films;

    /**
     * Koszyk trzyma tylko te filmy do których wlasciciel ma dostep i istnieja w cenniku. Filmy sa posortowane po cenie dla klienta
     * od najtanszych do najdrozszych co pozwala na latwe kupowanie tylko tych filmow na ktore stac klienta. Nowy koszyk jest inicjowany jako pusta lista.
     * @param wlasciciel osoba dla ktorej ceny filmów będą sprawdzane. Ta osoba dokona zakupu elementów z koszyka i od niej zostaną odjęte koszta
     */
    public Koszyk(Klient wlasciciel) {
        this(wlasciciel, new ArrayList<>());
    }
    /**
     * Koszyk trzyma tylko te filmy do których wlasciciel ma dostep i istnieja w cenniku. Filmy sa posortowane po cenie dla klienta
     * od najtanszych do najdrozszych co pozwala na latwe kupowanie tylko tych filmow na ktore stac klienta.
     * Zainicjowane istniejącą listą
     * @param wlasciciel osoba dla ktorej ceny filmów będą sprawdzane. Ta osoba dokona zakupu elementów z koszyka i od niej zostaną odjęte koszta
     */
    public Koszyk(Klient wlasciciel, List<Film> films) {
        this.wlasciciel = wlasciciel;
        this.wlasciciel.setKoszyk(this);
        //poprzez dodadnie do tree set ustawiam że wszystkie podane filmy będą sortowane w danej kolejności.
        //delegowanie konstruktora pozwala tworzyć puste koszyki, oraz nowe koszyki inicjowane już jakąś (nieposortowaną wcześniej) kolekcją
        //która jest sortowana przy tworzeniu koszyka.
        TreeSet<Film> filmTreeSet = new TreeSet<>((o1, o2) -> {
            try {
                return (int) (kosztFilmuDlaKlienta(o1) - kosztFilmuDlaKlienta(o2));
            } catch (KoszykException e) {
                throw new RuntimeException(e);
            }
        });
        filmTreeSet.addAll(films);
        this.films = filmTreeSet;
    }

    /**
     * Przenieś te elementy listy życzeń do koszyka, które występują w cenniku i do których klient ma dostęp
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
     * Oblicza koszt, jaki wlasciciel tego koszyka zapłaci za dany film. Filmy maja różne ceny w zależności od abonamentu klienta.
     * Można wywołać tą metode statycznie dla dowolnego innego klienta.
     * @param film dla jakiego filmu liczony jest koszt.
     * @return koszt który wlasciciel koszyka płaci za dany film
     * @throws KoszykException Wtedy, gdy nie można podać ceny dla klienta. Np. gdy filmu nie ma wcale w cenniku albo gdy dany klient nie ma dostępu do filmu.
     * @see KoszykException
     * @see Koszyk#kosztFilmuDlaKlienta(Film, Klient)
     */
    public double kosztFilmuDlaKlienta(Film film) throws KoszykException {
        return Koszyk.kosztFilmuDlaKlienta(film, wlasciciel);
    }

    /**
     * Oblicza koszt, jaki dany klient zapłaci za dany film. Filmy maja różne ceny w zależności od abonamentu klienta
     * @param film dla jakiego filmu liczony jest koszt.
     * @param klient dla jakiego klienta liczcony jest koszt
     * @return koszt który dany klient płaci za dany film
     * @throws KoszykException Wtedy, gdy nie można podać ceny dla klienta. Np. gdy filmu nie ma wcale w cenniku albo gdy dany klient nie ma dostępu do filmu.
     * @see KoszykException
     */
    public static double kosztFilmuDlaKlienta(Film film, Klient klient) throws KoszykException{
        if (Cennik.pobierzCennik().getRecordByKeyFilm(film).isEmpty())
            throw new KoszykException("Film nie wystepuje w cenniku");
        if (!(Cennik.pobierzCennik().getRecordByKeyFilm(film).get().czyMoznaPozaAbonamentem()||klient.isCzyMaAbonament()))
            throw new KoszykException("Film dostepny tylko dla klientów posiadających abonament");

        int koszt = 0;
        for (int i = 0; i < film.getNaIluUrzadzeniach(); i++) {
            koszt += i >= Cennik.pobierzCennik().getRecordByKeyFilm(film).get().maksLiczbUrzadzen() ?
                    klient.isCzyMaAbonament() ?
                            Cennik.pobierzCennik().getRecordByKeyFilm(film).get().cenaPakietAbo():
                            Cennik.pobierzCennik().getRecordByKeyFilm(film).get().cenaPakietBezAbo():
                    klient.isCzyMaAbonament() ?
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
        StringBuilder output = new StringBuilder(this.wlasciciel.getImie()).append(':');
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

    public Set<Film> getFilms() {
        return films;
    }
}
