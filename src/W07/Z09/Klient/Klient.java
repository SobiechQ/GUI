package W07.Z09.Klient;

public class Klient {
    private final String imie;
    private int stanKonta;
    private boolean czyMaAbonament;

    public Klient(String imie, int stanKonta, boolean czyMaAbonament) {
        this.imie = imie;
        this.stanKonta = stanKonta;
        this.czyMaAbonament = czyMaAbonament;
    }
    public Klient(String imie, int stanKonta){
        this(imie, stanKonta, false);
    }
}
