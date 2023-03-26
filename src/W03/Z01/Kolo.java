package W03.Z01;

public class Kolo extends Figura{
    private int radius;

    public Kolo(int xPos, int yPos, int radius) {
        super(xPos, yPos);
        this.radius = radius;
    }

    @Override
    void pozycja(int inputX, int inputY) {
        System.out.println("Punkt znajduje się " +
                (Math.sqrt(Math.pow(inputX - this.getxPos(), 2) + Math.pow(inputY - this.getyPos(), 2)) <= radius ? "wewnątrz" : "na zewnątrz")
                + " koła");
    }
    @Override
    String getName() {
        return "Koło";
    }

    @Override
    public String toString() {
        return super.toString() + "\nWymiary tej figury to: \n\tPromień: ("+this.radius+")";
    }

    @Override
    public long getPole() {
        return Math.round(Math.PI*Math.pow(this.radius,2));
    }

    @Override
    public long getObwod() {
        return Math.round(2*Math.PI*this.radius);
    }

}
