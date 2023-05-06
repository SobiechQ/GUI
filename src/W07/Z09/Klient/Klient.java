package W07.Z09.Klient;

import W07.Z09.Gatunki.Film;

import java.util.*;

public class Klient {
    private final String imie;
    private ListaZyczen listaZyczen;
    private Koszyk koszyk;
    private double stanKonta;
    private boolean czyMaAbonament;

    public Klient(String imie, double stanKonta, boolean czyMaAbonament) {
        this.imie = imie;
        this.stanKonta = stanKonta;
        this.czyMaAbonament = czyMaAbonament;
    }

    public Klient(String imie, int stanKonta) {
        this(imie, stanKonta, false);
    }

    public ListaZyczen pobierzListeZyczen() {
        if (this.listaZyczen == null)
            this.listaZyczen = new ListaZyczen(new ArrayList<>());
        return this.listaZyczen;
    }

    public void dodaj(Film film) {
        this.pobierzListeZyczen().add(film);
    }

    public String getImie() {
        return imie;
    }

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
        return listaZyczen;
    }

    public void setListaZyczen(ListaZyczen listaZyczen) {
        this.listaZyczen = listaZyczen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klient klient = (Klient) o;
        return stanKonta == klient.stanKonta && czyMaAbonament == klient.czyMaAbonament && Objects.equals(imie, klient.imie) && Objects.equals(listaZyczen, klient.listaZyczen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, stanKonta, czyMaAbonament, listaZyczen);
    }

    @Override
    public String toString() {
        return "Klient{" +
                "imie='" + imie + '\'' +
                ", stanKonta=" + stanKonta +
                ", czyMaAbonament=" + czyMaAbonament +
                ", listaZyczen=" + listaZyczen +
                '}';
    }

    public void zaplac(String formaPlatnosci, boolean czyAplikacjaSamaDolozy) throws EnumConstantNotPresentException {
        try {
            this.zaplac(FormaPlatnosci.valueOf(formaPlatnosci.toUpperCase()), czyAplikacjaSamaDolozy);
        } catch (IllegalArgumentException e) {
            throw new EnumConstantNotPresentException(FormaPlatnosci.class, formaPlatnosci);
        }
    }

    public void zaplac(FormaPlatnosci formaPlatnosci, boolean czyAplikacjaSamaOdlozy) {
        //Iterowanie po koszyku, aby uniknąć concurrent modification exception (Podczas iterowania usuwam z kopi koszyka)
        List<Film> kopiaKoszyk = new ArrayList<>(this.koszyk.getFilms());
        List<Film> kopiaListaZyczen = new ArrayList<>(this.listaZyczen.getFilms());
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
                } catch (KoszykException e) {
                    System.out.println(e.getMessage());
                }
        }
        this.koszyk = new Koszyk(this, kopiaKoszyk);
        this.listaZyczen = new ListaZyczen(kopiaListaZyczen);
        this.stanKonta -= kosztCalkowity;
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
}
