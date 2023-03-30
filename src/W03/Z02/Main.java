package W03.Z02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Osoba> lista = Arrays.asList(
                new Osoba("Anna", 23),
                new Osoba("Maria", 22),
                new Osoba("Anna", 20),
                new Osoba("Wojciech", 21)
        );
        Collections.sort(lista, new KomparatorOsob(Kryterium.IMIE));
        System.out.println(lista);

        // sortowanie według podanego komparatora (po wieku)
        Collections.sort(lista, new KomparatorOsob(Kryterium.WIEK));

        // lub zamiast komparatora "po wieku" napisać wyrażenie lambda w miejscu /* ... */
        /*Collections.sort(lista, new Comparator<Osoba>() {
            @Override
            public int compare(Osoba o1, Osoba o2) {
                return o1.getWiek() - o2.getWiek();
            }
        });
        */
        Collections.sort(lista, (o1, o2) -> o1.getWiek() - o2.getWiek());


        System.out.println(lista);

        // sortowanie według porządku naturalnego określonego w klasie Osoba
        Collections.sort(lista);
        System.out.println(lista);

    }
}
