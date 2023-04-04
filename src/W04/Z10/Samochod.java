package W04.Z10;

public class Samochod {
    private String salon;
    private String marka;
    private String cena;

    public Samochod(String salon, String marka, String cena) {
        this.salon = salon;
        this.marka = marka;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "\n\tSamochod{" +
                "salon='" + salon + '\'' +
                ", marka='" + marka + '\'' +
                ", cena='" + cena + '\'' +
                '}';
    }

    public String getCena() {
        return cena;
    }
}
