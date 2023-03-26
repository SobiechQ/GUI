package W02.Z04;

public class Kolo extends Figure{
    private int radius;
    public Kolo(int xAxis, int yAxis, int radius) {
        super(xAxis, yAxis);
        this.radius = radius;
    }


    @Override
    void pozycja(int xInput, int yInput) {
        int distanceFromCenter;
        //todo obliczyc odleglosc od srodka i powownac z radius
    }

    @Override
    String getName() {
        return "Kolo";
    }

    @Override
    public String toString() {
        return super.toString()+
                "Size: \n" +
                "\t radius: "+this.radius;
    }
}
