package W10.W01;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    Figure figure;
    MyPanel(){
        this.figure = new Figure(30,30){
            @Override
            public void run() {
                while (true){
                    this.setX(this.getX()+10);
                    this.setY(this.getY()+10);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    repaint();
                }
            }
        };
        new Thread(this.figure).start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(this.figure.getX(), this.figure.getY(), 30, 30);
    }
}
