package W07.Z09.Klient;

import W07.Z09.Cennik.Cennik;
import W07.Z09.Gatunki.Film;

import java.util.ArrayList;

public class Koszyk extends ArrayList<Film>{
    private final Klient wlasciciel;
    public Koszyk(Klient wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    /**
     * Dodaje do kosztyka tylko te elementy, na które stać i do których ma dostęp klient.
     */
    public void przepakuj(){
        for (Film film : this.wlasciciel.pobierzListeZyczen()) {
            try {
                this.wlasciciel.setStanKonta(this.wlasciciel.getStanKonta() - this.kosztFilmuDlaKlienta(film));
                this.add(film);
            } catch (KoszykException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    /**
     * Róźni klienci płacą różne ceny za ten sam film.
     */
    private int kosztFilmuDlaKlienta(Film film) throws KoszykException {
        if (!Cennik.pobierzCennik().getCennikRecords().containsKey(film.getTytul()))
            throw new KoszykException("Film nie wystepuje w cenniku");
        if (!(Cennik.pobierzCennik().getRecordByKeyFilm(film).czyMoznaPozaAbonamentem())&&(!wlasciciel.isCzyMaAbonament()))
            throw new KoszykException("Film dostepny tylko dla klientów posiadających abonament");

        int koszt = 0;
        for (int i = 0; i < film.getMaksymalnaLiczbaUrzadzen(); i++) {
             koszt += i >= Cennik.pobierzCennik().getRecordByKeyFilm(film).maksLiczbUrzadzen() ?
                        wlasciciel.isCzyMaAbonament() ?
                            Cennik.pobierzCennik().getRecordByKeyFilm(film).cenaPakietAbo():
                            Cennik.pobierzCennik().getRecordByKeyFilm(film).cenaPakietBezAbo():
                         wlasciciel.isCzyMaAbonament() ?
                            Cennik.pobierzCennik().getRecordByKeyFilm(film).cenaBezPakietAbo():
                            Cennik.pobierzCennik().getRecordByKeyFilm(film).cenaBezPakietBezAbo();
        }
        if (koszt>this.wlasciciel.getStanKonta())
            throw new KoszykException("Brak wystarczajacych srodow na koncie");
        return koszt;
    }

}
