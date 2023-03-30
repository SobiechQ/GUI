package W04.Z03;

import java.awt.*;

public class Circle extends Figura{
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x-radius, y-radius);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "} " + super.toString();
    }

    @Override
    public void paint() {
        super.getGraphics().fillArc(this.getX(),this.getY(),this.getRadius(),this.getRadius(),0,360);
    }
}
