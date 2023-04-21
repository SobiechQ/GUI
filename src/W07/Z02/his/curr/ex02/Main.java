package W07.Z02.his.curr.ex02;

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

        this.getContentPane().add(
            new BorderLayoutPanel(), BorderLayout.CENTER
        );

        this.getContentPane().add(
            new FlowLayoutPanel(), BorderLayout.PAGE_END
        );

        this.getContentPane().add(
            new GridLayoutPanel(), BorderLayout.PAGE_START
        );

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( 640, 480);
        this.setVisible(true);
    }
}
