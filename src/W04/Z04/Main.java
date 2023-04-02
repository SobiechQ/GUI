package W04.Z04;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new MyFrame(75);
        new Circle(100,100,5,0);
        new Circle(600,100,-5,0);

        MyFrame.self.animate();
    }
}
