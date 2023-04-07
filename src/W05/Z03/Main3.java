package W05.Z03;

public class Main3 {
    public static void main(String[] args) {
        Osoba osoba1 = new Osoba("ABC", 10);
        Osoba osoba2 = new Osoba("dupa", 12);
        Osoba osoba3 = new Osoba("dupa", 12);
        Koza koza = new Koza();

        System.out.println(osoba2.equals(null));
    }
}
