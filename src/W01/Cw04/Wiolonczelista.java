package W01.Cw04;

public class Wiolonczelista extends Muzyk {

    public Wiolonczelista(String imie, double czasWystapienia) {
        super(imie, czasWystapienia);
    }

    @Override
    public String instrument() {
        return "wiolonczela";
    }

    @Override
    public float stawka() {
        return 250F;
    }
}
