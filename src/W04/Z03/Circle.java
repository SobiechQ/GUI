package W04.Z03;

import java.awt.*;
import java.util.Arrays;

public class Circle extends Figura{
    private int radius;
    double[] vector = new double[2];

    public Circle(int x, int y, int radius) {
        super(x-radius, y-radius);
        this.radius = radius;
        this.vector[0] = -2;
        this.vector[1] = (0.2);
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", vector=" + Arrays.toString(vector) +
                "} " + super.toString();
    }

    @Override
    public void paint(Graphics g) {
        g.fillArc(this.getX(),this.getY(),this.getRadius(),this.getRadius(),0,360);

        Fizyka.calculateNextFrame(this);






        //change vectors
        this.setX((int)(
                this.getX()+this.vector[0]
                ));
        this.setY((int)(
                this.getY()+this.vector[1]
        ));
        System.out.println(this.toString());
    }
    private static class Fizyka{
        public static void calculateNextFrame(Circle c){
            //oś X
            if(c.getX()<=c.getRadius())
                c.vector[0] = c.vector[0]<0?c.vector[0]*(-1):c.vector[0];



        }
    }



}
