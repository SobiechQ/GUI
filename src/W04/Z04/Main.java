package W04.Z04;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        new MyFrame(75);
        for (int i = 0; i < 40; i++) {
            new Circle();
        }

        MyFrame.self.animate();
    }
}
