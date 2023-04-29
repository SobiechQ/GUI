package W07.Z09.Klient;

import W07.Z09.Cennik.Cennik;
import W07.Z09.Cennik.CennikRecord;
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
            this.add(film);
            this.wlasciciel.setStanKonta(this.wlasciciel.getStanKonta() - this.kosztFilmuDlaKlienta(film));
        }
    }
    
    /**
     * Róźni klienci płacą różne ceny za ten sam film.
     */
    private int kosztFilmuDlaKlienta(Film film){
        int koszt = 0;
        int ileWPakiecie = film.getMaksymalnaLiczbaUrzadzen() - Cennik.pobierzCennik().getRecordByKey(film.getTytul()).maksLiczbUrzadzen();




    }

}
