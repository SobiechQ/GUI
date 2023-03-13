package W01.Cw04;

public class Flecista extends Muzyk {

    public Flecista(String imie, double czasWystapienia) {
        super(imie, czasWystapienia);
    }

    @Override
    public String instrument() {
        return "flet";
    }

    @Override
    public float stawka() {
        return 300F;
    }
}
