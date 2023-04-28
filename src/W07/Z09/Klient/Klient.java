package W07.Z09.Klient;

import W07.Z09.Gatunki.Film;

public class Klient {
    private final String imie;
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
    private ListaZyczen listaZyczen;
    public ListaZyczen pobierzListeZyczen(){
        if (this.listaZyczen == null)
            this.listaZyczen = new ListaZyczen();
        return this.listaZyczen;
    }
    public void dodaj(Film film){
        this.pobierzListeZyczen().add(film);
    }
}
