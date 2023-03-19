package W02.Z02;

public class Spowiednik extends Osoba{
    public Spowiednik(String imie, int wiek) {
        super(imie, wiek);
    }

    @Override
    public void modlSie() {
        System.out.println("Przebacz im panie bo zgrzeszyli");
    }

    @Override
    protected void soutZawod() {
        System.out.println("Łącze ludzi z bogiem");
    }
}
