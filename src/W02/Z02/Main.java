package W02.Z02;

public class Main {
    public static void main(String[] args) {

        Zakon zakon = new Zakon("Zakon krzyżacki");
        zakon.dodaj(new Rycerz("Janusz",26));
        zakon.dodaj(new Kucharz("Andrzej",56));
        zakon.dodaj(new Kucharz("Bartłomiej",16));
        zakon.dodaj(new Rycerz("Kazimierz",56));
        zakon.dodaj(new Kucharz("Bożena",56));
        zakon.dodaj(new Spowiednik("Bogumił",57));
        zakon.dodaj(new Spowiednik("Katarzyna",107));
        zakon.urodzinyBoga();
//        System.out.println(zakon.nazwa);

    }
}
