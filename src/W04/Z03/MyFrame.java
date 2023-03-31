package W04.Z03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MyFrame extends Frame {
    public static MyFrame self;
    public static ArrayList<Paintable> paintableList = new ArrayList<>();


    MyFrame(){
        MyFrame.self = this;
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
        buffor = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);


    }

    private BufferedImage buffor;
    public void animate() {
        while (true) {
            //create buffor image
            buffor = (BufferedImage) createImage(this.getWidth(), this.getHeight());
            this.paintFromBuffor((Graphics2D) buffor.getGraphics());


            //draw only after all frames have been sequenced
            this.getGraphics().drawImage(buffor, 0, 0, this);





            try {
                Thread.sleep(1000/75);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void paintFromBuffor(Graphics2D g){
        //antyalias
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        for (Paintable paintable : paintableList)
            paintable.paint(g);
    }
}
