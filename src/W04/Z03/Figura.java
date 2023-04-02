package W04.Z03;

import java.awt.*;

public abstract class Figura implements Paintable, Repaintable{
    private double x;
    private double y;
    private int id;
    private Graphics graphics = MyFrame.self.getGraphics().create();
    private static int count;

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
        this.id = Figura.count++;
        setRepaintable();
    }


    @Override
    public void setRepaintable() {
        MyFrame.paintableList.add(this);
    }

    public int getId() {
        return id;
    }
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public String toString() {
        return "Figura{" +
                "x=" + x +
                ", y=" + y +
                ", id=" + id +
                '}';
    }
}
