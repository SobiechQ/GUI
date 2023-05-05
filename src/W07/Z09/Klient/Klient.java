package W07.Z09.Klient;

import W07.Z09.Gatunki.Film;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Klient {
    private final String imie;
    private ListaZyczen listaZyczen;
    private Koszyk koszyk;
    private int stanKonta;
    private boolean czyMaAbonament;

    public Klient(String imie, int stanKonta, boolean czyMaAbonament) {
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

    public int getStanKonta() {
        return stanKonta;
    }

    public void setStanKonta(int stanKonta) {
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

    public void zaplac(FormaPlatnosci formaPlatnosci, boolean czyAplikacjaSamaDolozy) {
        //todo TEST THIS METHOD

        //Iterowanie po kopi koszyka, aby uniknąć concurrent modification exception (Podczas iterowania usuwam z koszyka)
        Set<Film> kopiaKoszyk = new HashSet<>(this.koszyk.getFilms());
        for (Film film : kopiaKoszyk) {
                try {
                    if (this.koszyk.kosztFilmuDlaKlienta(film) > this.stanKonta)
                        //Jeżeli koszy dla filmu przewyższa możliwości klienta to koniec płacenia.
                        //Filmy są posortowane po cenie wiec jak nie stać go na film n to na film n+1 też go nie stać.
                        return;
                    this.stanKonta -= this.koszyk.kosztFilmuDlaKlienta(film);
                    this.koszyk.getFilms().remove(film);
                    this.listaZyczen.getFilms().remove(film);
                } catch (KoszykException e) {
                    System.out.println(e.getMessage());
                }
        }


    }

    public void setKoszyk(Koszyk koszyk) {
        this.koszyk = koszyk;
    }

    public Koszyk pobierzKoszyk() {
        return this.koszyk;
    }

    public int pobierzPortfel() {
        return this.stanKonta;
    }
}
