package W07.Z02.his.curr.ex03;

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
        MyColorRes myColorRes = new MyColorRes();

        JPanel controllerPanel = new JPanel();
        MyColorPanel colorPanel1 = new MyColorPanel(Color.RED);
        MyColorPanel colorPanel2 = new MyColorPanel(Color.YELLOW);
        MyColorPanel colorPanel3 = new MyColorPanel(Color.PINK);

        controllerPanel.add(colorPanel1);
        controllerPanel.add(colorPanel2);
        controllerPanel.add(colorPanel3);




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
