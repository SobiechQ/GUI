package W04.Z04;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Circle implements Paintable{
    private double xPos;
    private double yPos;
    private double diameter;
    private ArrayList<Circle> circles = new ArrayList<>();
    private double[] vector = new double[2];
    Circle(){
        this(Math.random()*MyFrame.self.getWidth(),
                Math.random()*MyFrame.self.getHeight(),
                -3 + Math.random()*60,
                -3 + Math.random()*60);
    }
    Circle(double x, double y, double vec0, double vec1){
        this.xPos=x;
        this.yPos=y;
        this.vector[0]=vec0;
        this.vector[1]=vec1;
        this.diameter = 40;
        MyFrame.paintableList.add(this::paint);
        circles.add(this);
    }







    @Override
    public void paint(Graphics g) {
        this.checkAll();
        g.fillArc((int)this.getxPos(),(int)this.getyPos(), (int) (this.getDiameter()), (int) (this.getDiameter()),0,360);
    }
    private void checkAll(){
        this.gravitation();
        this.checkBoundries();
        this.move();
        this.colision();
    }
    private void move(){
        this.xPos += this.vector[0];
        this.yPos += this.vector[1];
    }
    private boolean disableGravitation = false;

    private void checkBoundries(){
        //left
        if(this.xPos <= 0)
            this.vector[0] = this.vector[0] < 0 ? this.vector[0] * (-0.7) : this.vector[0];

        //right
        if(this.xPos + this.diameter - MyFrame.self.getWidth() >= 0)
            this.vector[0] = this.vector[0] > 0 ? this.vector[0] * (-0.8) : this.vector[0];

        //down
        if(this.yPos + this.diameter - MyFrame.self.getHeight() >= 0) {
            this.vector[1] = this.vector[1] > 0 ? this.vector[1] * (-0.8) : this.vector[1];
        }

        //up
        if(this.yPos <= 30)
            this.vector[1] = this.vector[1] < 0 ? this.vector[1] * (-0.8) : this.vector[1];



    }
    private void gravitation(){
        if(!this.disableGravitation)
            this.vector[1] += 0.2;
        if(this.disableGravitation)
            this.vector[0] *= (0.999);

        //set vecor as 0 for very small movements
        if(Math.abs(this.vector[1]) <= 0.7 &&
        Math.abs(this.yPos + this.diameter - MyFrame.self.getHeight()) <= 15

        ) {
            this.vector[1] = 0;
            this.disableGravitation = true;
        }
        if(Math.abs(this.vector[0]) <= 0.4){
            this.vector[0] = 0;
        }
    }
    private void colision(){
        for (Circle c : circles) {
//            System.out.println(this.getDistanceTo(c));
            if(this.getDistanceTo(c)<this.getDiameter()/2)
                this.stop();
        }

    }



    private void stop(){
        this.vector[0]=0;
        this.vector[1]=0;
        this.disableGravitation = true;
    }
    private double getDistanceTo(Circle c){
        System.out.println(this.getxPos() + (this.getDiameter()/2) - (
                c.getxPos() + (c.getDiameter()/2)));



        return Math.sqrt(
                Math.pow(this.getxPos() + (this.getDiameter()/2) +
                        c.getxPos() + (c.getDiameter()/2), 2) +
                        Math.pow (this.getyPos() + (this.getDiameter()/2) +
                        c.getyPos() + (c.getDiameter()/2), 2)
        );


    }
























    public double getDiameter() {
        return diameter;
    }

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", diameter=" + diameter +
                ", vector=" + Arrays.toString(vector) +
                ", disableGravitation=" + disableGravitation +
                '}';
    }
}
