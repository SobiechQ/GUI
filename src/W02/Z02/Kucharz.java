package W02.Z02;

public class Kucharz extends Osoba{
    public Kucharz(String imie, int wiek) {
        super(imie, wiek);
    }

    @Override
    public void modlSie() {
        System.out.println("Panie boże daj mi dobre jedzonko");
    }

    @Override
    protected void soutZawod() {
        System.out.println("Przygotuje ztrawe dla dzieci bożych");
    }
}
