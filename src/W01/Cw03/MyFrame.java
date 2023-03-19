package W01.Cw03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends Frame {
    MyFrame(){
        this.setVisible(true);
        this.setSize(300,300);
        var wa = new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        };
        this.addWindowListener(wa);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillArc(100,100,30,30,0,360);
    }
}