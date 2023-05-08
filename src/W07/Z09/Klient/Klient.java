package W07.Z09.Klient;

import W07.Z09.Gatunki.Film;

import java.util.*;

/**
 * Aktor posiadający możliwość wynajmowania filmów. Każdy klient posiada swoją listę życzeń oraz swój koszyk.
 * Zainterezowany klient dodaje filmy do listy życzeń. Aby móc wynająć filmy musi je najpierwsz prepakować do koszyka
 * (z wawartości koszyka wykonywana jest płatność) oraz zapłacić.
 * @see ListaZyczen
 * @see Koszyk
 * @see Klient#przepakuj(Koszyk)
 * @see Klient#zaplac(FormaPlatnosci, boolean)
 */

public class Klient {
    private final String imie;
    private ListaZyczen listaZyczen;
    private Koszyk koszyk;
    private double stanKonta;
    private boolean czyMaAbonament;

    /**
     * @param imie Nazwa klienta, ułatwia testowanie.
     * @param stanKonta Dostępna zadeklaroana kwota na zakupy. klient nie może wydać więcej niż ta kwota.
     * @param czyMaAbonament abonament zmienia ceny niektórych filmów w cenniku. Niektóre filmy są dostępne tylko dla osob z abonamentem.
     */
    public Klient(String imie, double stanKonta, boolean czyMaAbonament) {
        this.imie = imie;
        this.stanKonta = stanKonta;
        this.czyMaAbonament = czyMaAbonament;
    }

    /**
     * Przeciążenie konstruktora, tworzy klienta który nie ma abonamentu
     * @param imie Nazwa klienta, ułatwia testowanie.
     * @param stanKonta Dostępna zadeklaroana kwota na zakupy. klient nie może wydać więcej niż ta kwota.
     * @see Klient#Klient(String, double, boolean)  Klient
     */
    public Klient(String imie, int stanKonta) {
        this(imie, stanKonta, false);
    }

    public ListaZyczen pobierzListeZyczen() {
        //Takie rozwiązanie chroni przed null pointer exception.
        //pobierając geterem nigdy nie zostanie zwrócony null, nawet jak klient nie ma listy życzeń.
        if (this.listaZyczen == null)
            this.listaZyczen = new ListaZyczen(new ArrayList<>(), this);
        return this.listaZyczen;
    }

    /**
     * Przeciążenie metody zapłać. Klient placi za swoj koszyk. Poprawnie wykonana operacja usunie wszystkie pozycje z koszyka i listy życzeń i odejmie kwote od stanu konta. W zaleznosci od flagi czyAplikacjaSamaOdlozy sa rozne zachowania w sytuacji braku odpowiedznich pieniedzy na zakup.
     * @param formaPlatnosci Różne formy płatności mają różne prowizje. Enumerator pilnuje jakie są dostępne metody płatności String tłumaczone jest na enum, sposórd FormaPlatnosci
     * @param czyAplikacjaSamaOdlozy  true oznacza, że w przypadku braku środków aplikacja sam odłoży nadmiarowe programy, wpp. rezygnacja z płacenia razem z czyszczeniem koszyka i listy życzeń
     * @throws EnumConstantNotPresentException Wtedy, gdy nie znaleziono takiej metody płatności
     * @see FormaPlatnosci
     * @see Klient#zaplac(FormaPlatnosci, boolean)
     */
    public void zaplac(String formaPlatnosci, boolean czyAplikacjaSamaOdlozy) throws EnumConstantNotPresentException {
        try {
            this.zaplac(FormaPlatnosci.valueOf(formaPlatnosci.toUpperCase()), czyAplikacjaSamaOdlozy);
        } catch (IllegalArgumentException e) {
            throw new EnumConstantNotPresentException(FormaPlatnosci.class, formaPlatnosci);
        }
    }

    /**
     * Klient placi za swoj koszyk. Poprawnie wykonana operacja usunie wszystkie pozycje z koszyka i listy życzeń i odejmie kwote od stanu konta. W zaleznosci od flagi czyAplikacjaSamaOdlozy sa rozne zachowania w sytuacji braku odpowiedznich pieniedzy na zakup.
     * @param formaPlatnosci Różne formy płatności mają różne prowizje. Enumerator pilnuje jakie są dostępne metody płatności
     * @param czyAplikacjaSamaOdlozy  true oznacza, że w przypadku braku środków aplikacja sam odłoży nadmiarowe programy, wpp. rezygnacja z płacenia razem z czyszczeniem koszyka i listy życzeń
     * @see FormaPlatnosci
     */
    public void zaplac(FormaPlatnosci formaPlatnosci, boolean czyAplikacjaSamaOdlozy) {
        //Iterowanie po koszyku, aby uniknąć concurrent modification exception (Podczas iterowania usuwam z kopi koszyka)
        List<Film> kopiaKoszyk = new ArrayList<>(this.koszyk.getFilms());
        List<Film> kopiaListaZyczen = new ArrayList<>(this.pobierzListeZyczen().getFilms());
        double kosztCalkowity = 0;
        for (Film film : this.koszyk) {
                try {
                    if ((formaPlatnosci.equals(FormaPlatnosci.KARTA) ?
                            this.koszyk.kosztFilmuDlaKlienta(film)*1.01:this.koszyk.kosztFilmuDlaKlienta(film)) >
                            this.stanKonta - kosztCalkowity) {
                        //Nie stać na kolejny film wiec zaleznie od czyAplikacjaSamaOdlozy
                        if (!czyAplikacjaSamaOdlozy)
                            //koniec placenia. Nic sie nie dzieje zmiany nie są zapisane
                            return;
                        //wpp koniec iterowania po filmach i zmiany są zapisane
                        break;
                    }
                    kosztCalkowity += formaPlatnosci.equals(FormaPlatnosci.KARTA) ? this.koszyk.kosztFilmuDlaKlienta(film)*1.01:this.koszyk.kosztFilmuDlaKlienta(film);
                    kopiaKoszyk.remove(film);
                    kopiaListaZyczen.remove(film);
                } catch (IllegalFilmAccessException e) {
                    System.out.println(e.getMessage());
                }
        }
        this.stanKonta -= kosztCalkowity;

        //nadpisuje stary koszyk i starą listę życzeń nowymi kopiami, z których wyrzuciłem niepotrzebne filmy
        this.koszyk.getFilms().clear();
        this.koszyk.getFilms().addAll(kopiaKoszyk);
        this.listaZyczen.getFilms().clear();
        this.listaZyczen.getFilms().addAll(kopiaListaZyczen);
    }
    @Override
    public String toString() {
        return "Klient (" +
                "imie: " + imie +
                ", stanKonta: " + stanKonta +
                ", czyMaAbonament: " + czyMaAbonament +
                ')';
    }


    public void setKoszyk(Koszyk koszyk) {
        this.koszyk = koszyk;
    }

    public Koszyk pobierzKoszyk() {
        return this.koszyk;
    }

    public double pobierzPortfel() {
        return this.getStanKonta();
    }

    public void dodaj(Film film) {
        this.pobierzListeZyczen().add(film);
    }

    public String getImie() {
        return imie;
    }

    /**
     * Przenieś te elementy listy życzeń do koszyka, które występują w cenniku i do których klient ma dostęp
     * @param koszyk źródło do którego przenosimy elementy
     * @see Koszyk#przepakuj()
     */
    public void przepakuj(Koszyk koszyk) {
        koszyk.przepakuj();
    }

    public double getStanKonta() {
        return stanKonta;
    }

    public void setStanKonta(double stanKonta) {
        this.stanKonta = stanKonta;
    }

    public boolean isCzyMaAbonament() {
        return czyMaAbonament;
    }

    public void setCzyMaAbonament(boolean czyMaAbonament) {
        this.czyMaAbonament = czyMaAbonament;
    }

    public ListaZyczen getListaZyczen() {
        return this.pobierzListeZyczen();
    }

    public void setListaZyczen(ListaZyczen listaZyczen) {
        this.listaZyczen = listaZyczen;
    }

}
