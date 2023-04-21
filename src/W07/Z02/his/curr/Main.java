package W07.Z02.his.curr;

import javax.swing.*;
import java.awt.*;

public
    class Main
    extends JFrame{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
            ()->{
                new Main();
            }
        );
    }

    public Main(){


        JPanel controllerPanel = new JPanel();
        MyColorPanel colorPanel1 = new MyColorPanel(Color.RED);
        MyColorPanel colorPanel2 = new MyColorPanel(Color.YELLOW);
        MyColorPanel colorPanel3 = new MyColorPanel(Color.PINK);

        controllerPanel.add(colorPanel1);
        controllerPanel.add(colorPanel2);
        controllerPanel.add(colorPanel3);

        MyColorRes myColorRes = new MyColorRes();

        colorPanel1.addColorListener(myColorRes);
        colorPanel2.addColorListener(myColorRes);
        colorPanel3.addColorListener(myColorRes);


        this.getContentPane().add(
            controllerPanel, BorderLayout.PAGE_END
        );

        this.getContentPane().add(
            myColorRes
        );

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( 640, 480);
        this.setVisible(true);
    }
}
