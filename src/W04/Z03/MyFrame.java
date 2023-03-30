package W04.Z03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends Frame {
    public static MyFrame mf;
    public static ArrayList<Paintable> paintableList = new ArrayList<>();
    MyFrame(){
        MyFrame.mf = this;
        this.setVisible(true);
        this.setSize(600,600);
        this.setAlwaysOnTop(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        for (Paintable paintable : paintableList)
            paintable.paint();
    }
}
