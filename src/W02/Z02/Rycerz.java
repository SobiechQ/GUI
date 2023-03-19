package W02.Z02;

public class Rycerz extends Osoba{
    public Rycerz(String imie, int wiek) {
        super(imie, wiek);
    }

    @Override
    public void modlSie() {
        System.out.println("Bóg miłość ojczyzna!");
    }

    @Override
    protected void soutZawod() {
        System.out.println("Ja: " +this.getImie()+ "Zajmuje się rucerstwem!");
    }
}
