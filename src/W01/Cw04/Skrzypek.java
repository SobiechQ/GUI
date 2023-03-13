package W01.Cw04;

public class Skrzypek extends Muzyk{
    public Skrzypek(String imie, double czasWystapienia) {
        super(imie, czasWystapienia);
    }

    @Override
    public String instrument() {
        return "skrzypce";
    }

    @Override
    public float stawka() {
        return 200F;
    }
}
