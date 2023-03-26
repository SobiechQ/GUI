package W03.Z01;

public class Prostokat extends Figura{
    private int width;
    private int height;

    public Prostokat(int xPos, int yPos, int width, int height) {
        super(xPos, yPos);
        this.width = width;
        this.height = height;
    }

    @Override
    String getName() {
        return "Prostokat";
    }

    @Override
    void pozycja(int inputX, int inputY) {
        System.out.println("Punkt znajduje się " +
                (inputX >= this.getxPos() - this.width/2 && inputX <= this.getxPos() + this.width/2 &&
                        inputY >= this.getyPos() - this.height/2 && inputY <= this.getyPos() + this.height/2?
                        "wewnątrz" : "na zewnątrz")
                + " prostokątka.");
    }

    @Override
    public String toString() {
        return super.toString()+"\nWymiary tej figury to: \n\tSzerokość: ("+this.width+") \n\tWysokość: ("+this.height+")";
    }

    @Override
    public long getPole() {
        return this.width*this.height;
    }

    @Override
    public long getObwod() {
        return 2*this.width+2*this.height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
