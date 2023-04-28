package W07.Z09.Klient;

import W07.Z09.Gatunki.Film;

import java.util.ArrayList;

public class Koszyk extends ArrayList<Film>{
    private final Klient wlasciciel;
    public Koszyk(Klient wlasciciel) {
        this.wlasciciel = wlasciciel;
    }
    public void przepakuj(Klient klient){
        for (Film film : klient.pobierzListeZyczen()) {
            this.add(film);
            klient.setStanKonta(klient.getStanKonta() - );
        }
    }
    private int kosztFilmuDlaKlienta(Klient klient, Film film){
        int koszt;
        if (klient.isCzyMaAbonament()){
//            koszt =
        //todo

        }




    }

}
