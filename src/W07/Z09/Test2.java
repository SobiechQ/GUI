package W07.Z09;

import W07.Z09.Cennik.Cennik;
import W07.Z09.Gatunki.*;
import W07.Z09.Klient.FormaPlatnosci;
import W07.Z09.Klient.Klient;
import W07.Z09.Klient.Koszyk;
import W07.Z09.Klient.KoszykException;

import java.util.concurrent.atomic.AtomicInteger;

public class Test2 {

    // cena programów danego typu z koszyka
    static int cena(Koszyk k, String typ) {
        AtomicInteger cena = new AtomicInteger();
        k.getFilms().stream()
                .filter(film -> film.getClass().getSimpleName().equalsIgnoreCase(typ))
                .forEach(film -> {
                    try {
                        cena.addAndGet(k.kosztFilmuDlaKlienta(film));
                    } catch (KoszykException e) {
                        System.out.println(e.getMessage());
                    }
                });
        return cena.get();
    }

    public static void main(String[] args) {

        // cennik
        Cennik cennik = Cennik.pobierzCennik();

        cennik.dodaj("dramat", "Król lew", 6, 12, 3, 5);     // jeśli klient ma abonament: 5 zł/urządzenie (z dowolną liczbą urządzeń)
        cennik.dodaj("obyczaj", "Król Lear", 2, 10, 15);    // niezależnie od tego, czy klient posiada abonament czy nie
        cennik.dodaj("komedia", "Królowa", 14, 7);        // 7 zł/urządzenie jeśli klient ma abonament, wpp. 14 zł/urządzenie
        cennik.dodaj("sensacja", "Król Artur");            // tylko dla abonamentów: darmowy dostęp

        Klient klient = new Klient("Jan", 100, false);
//        klient.dodaj(new Obyczaj("Król Lear", 7));
//        klient.dodaj(new Obyczaj("Król Lear", 5));
//        klient.dodaj(new Obyczaj("Król Lear", 2));
//        klient.dodaj(new Obyczaj("Król Lear", 6));
//        klient.dodaj(new Obyczaj("Król Lear", 8));
//        klient.dodaj(new Obyczaj("Król Lear", 3));
        klient.dodaj(new Obyczaj("Król Lear", 4));
        klient.dodaj(new Obyczaj("Król Lear", 1));
        klient.dodaj(new Obyczaj("Król Lear", 2));
        klient.dodaj(new Obyczaj("Król Lear", 3));



        Koszyk koszyk = new Koszyk(klient);
        klient.przepakuj(koszyk);
        System.out.println(koszyk);

        klient.zaplac(FormaPlatnosci.KARTA, false);
        System.out.println(klient.pobierzPortfel());
        System.out.println(klient.pobierzKoszyk());
        System.out.println(klient.pobierzListeZyczen());
    }
}
