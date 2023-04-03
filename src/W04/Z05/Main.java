package W04.Z05;

import java.util.*;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        List<Osoba> lista = Arrays.asList(
                new Osoba("Anna", 2000),
                new Osoba("Bartek", 2001),
                new Osoba("Maria", 2002)
        );
        out.println(Osoba.wKolekcji(lista, "Bartek", 2001));
        out.println(Osoba.wKolekcji(lista, "Daria", 2001));
        Set<Osoba> tZbior = new TreeSet<>(lista);
        out.println(Osoba.wKolekcji(tZbior, "Bartek", 2001));
        out.println(Osoba.wKolekcji(tZbior, "Daria", 2001));
        Set<Osoba> hZbior = new HashSet<>(lista);
        out.println(Osoba.wKolekcji(hZbior, "Bartek", 2001));
        out.println(Osoba.wKolekcji(hZbior, "Daria", 2001));

    }
}
