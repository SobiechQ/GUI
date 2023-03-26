package Z02;

public abstract class Figure {
    private int xAxis;
    private int yAxis;

    public Figure(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    @Override
    public String toString() {
        return "Position: " +
                "\n \t X: ("+this.xAxis+") \n" +
                "\n \t Y: ("+this.yAxis+") \n";
    }
    abstract String getName();
    abstract void pozycja(int xInput, int yInput);

}
