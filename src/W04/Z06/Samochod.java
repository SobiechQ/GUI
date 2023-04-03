package W04.Z06;

public class Samochod {
    private int marka;
    private int cena;

    public Samochod(int marka, int cena) {
        this.marka = marka;
        this.cena = cena;
    }

    public int getMarka() {
        return marka;
    }

    public int getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "marka=" + marka +
                ", cena=" + cena +
                '}';
    }
}
