package W04.Z03;


import java.awt.*;
import java.util.Arrays;

public class Circle extends Figura{
    private int radius;
    double[] vector = new double[2];

    public Circle(int x, int y, int radius) {
        super(x+radius/2, y+radius/2);
        this.radius = radius;
        this.vector[0] = -2;
        this.vector[1] = 0;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Figura{" +
                "x=" + this.getCenterX() +
                ", y=" + this.getCenterY() +
                ", id=" + this.getId() +
                '}' +
                "Circle{" +
                "radius=" + radius +
                ", vector=" + Arrays.toString(vector) +
                "} " + super.toString();
    }
    public double getCenterX(){
        return super.getX()-this.radius/2;
    }
    public double getCenterY(){
        return super.getY()-this.radius/2;
    }

    @Override
    public void paint(Graphics g) {
        g.fillArc((int)this.getX(),(int)this.getY(),this.getRadius()*2,this.getRadius()*2,0,360);

        Fizyka.calculateNextFrame(this);






        //change vectors
        this.setX(
                this.getX()+this.vector[0]
                );
        this.setY(
                this.getY()+this.vector[1]
        );
        System.out.println(this.toString());
    }
    private static class Fizyka{
        public static void calculateNextFrame(Circle c){

            //oś X
            if(c.getCenterX() + c.getRadius() <= 0) {
                c.vector[0] = c.vector[0] < 0 ? c.vector[0] * (-1) : c.vector[0];
            }
            if(c.getCenterX() + c.getRadius() >= MyFrame.self.getWidth()) {
                c.vector[0] = c.vector[0] > 0 ? c.vector[0] * (-1) : c.vector[0];
            }





        }
    }



}
