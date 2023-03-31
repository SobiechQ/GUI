package W04.Z03;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new MyFrame();
        ArrayList<Figura> figuras = new ArrayList<>();
        figuras.add(new Circle(100,130,20));
//        figuras.add(new Circle(70,350,20));
//        figuras.add(new Circle(480,500,40));
//        figuras.add(new Circle(380,200,5));
        MyFrame.self.animate();

        //todo w abstract figure x i y muszą być doublami a draw będzie je castować / przybliżać
    }
}
