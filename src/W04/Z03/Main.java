package W04.Z03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new MyFrame();
        ArrayList<Figura> figuras = new ArrayList<>();
        figuras.add(new Circle(100,130,20));
        figuras.add(new Circle(70,350,20));
        figuras.add(new Circle(480,500,40));
        figuras.add(new Circle(380,200,5));
        while(true) {
            MyFrame.mf.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            for (Figura figura : figuras) {
                figura.setX((int)(
                        figura.getX() +
                                (-1) + (Math.random() * 3)
                ));
                figura.setY((int)(
                        figura.getY() +
                                (-1) + (Math.random() * 3))
                );

            }


        }

    }
}
