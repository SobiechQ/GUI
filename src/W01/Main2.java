package W01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main2 extends Frame {
    public static void main(String[] args) {
        new Main2();
    }

    public Main2(){
        this.setSize(400,400);
        this.setVisible(true);
//        this.addWindowListener(
//                new MyWindowAdapter()
//        );
        //przy takim rozwiązaniu MyWIndowAdapter nie zna parametó klasy Main2.
        //trzeba by przekazać parametry do środka przez konstruktukor podać This
        //łatwwiej zamiast tworzyć powższej klay łatwiej użyć anonimowej.

        this.addWindowListener(
                new WindowAdapter(){
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        int eee;
                        System.out.println("JEstem tu i mam dostęp do zmiennych");
                        System.exit(0);
                    }
                }
        );


    }
}
