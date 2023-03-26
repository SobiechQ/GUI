package W03.Z01;

public abstract class Figura implements Obliczenie{
    private int xPos;
    private int yPos;

    public Figura(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public String toString() {
        return "\nFigura: \n\t"+this.getName()+" \nWspółrzędne środka to: \n\tX: ("+this.xPos+") \n\tY: ("+this.yPos+")";
    }

    abstract String getName();
    abstract void pozycja(int inputX, int inputY);

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
