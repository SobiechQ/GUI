package W04.Z01;

public class Dziekan {
    public String imie;
    public int eska;
    public int kasa = Integer.MAX_VALUE;

    public Dziekan(String imie, int eska) {
        this.imie = imie;
        this.eska = eska;
    }

    @Override
    public String toString() {
        return "Dziekan{" +
                "imie='" + imie + '\'' +
                ", eska=" + eska +
                ", kasa=" + kasa +
                '}';
    }
}
