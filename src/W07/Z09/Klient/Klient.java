package W07.Z09.Klient;

import W07.Z09.Gatunki.Film;

import java.util.Objects;

public class Klient {
    private final String imie;
    private ListaZyczen listaZyczen;
    private int stanKonta;
    private boolean czyMaAbonament;

    public Klient(String imie, int stanKonta, boolean czyMaAbonament) {
        this.imie = imie;
        this.stanKonta = stanKonta;
        this.czyMaAbonament = czyMaAbonament;
    }
    public Klient(String imie, int stanKonta){
        this(imie, stanKonta, false);
    }
    public ListaZyczen pobierzListeZyczen(){
        if (this.listaZyczen == null)
            this.listaZyczen = new ListaZyczen();
        return this.listaZyczen;
    }
    public void dodaj(Film film){
        this.pobierzListeZyczen().add(film);
    }

    public String getImie() {
        return imie;
    }
    public void przepakuj(Koszyk koszyk){
        koszyk.przepakuj(this);
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
}
