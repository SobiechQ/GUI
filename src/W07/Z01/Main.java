package W07.Z01;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static JFrame jFrame = new JFrame();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
    Main(){
        class PageEndGrid extends JPanel {
            PageEndGrid(){
                this.setLayout(
                        new java.awt.GridLayout(3,3)
                );

                for (int i = 0; i < 9; i++) {
                    JButton button = new JButton("B" + i);
                    button.addActionListener(e -> {
                        System.out.println("Hello");
                    });
                    this.add(button);
                }
            }
        }
        class CenterGrid extends JPanel{
            CenterGrid(){
                this.setLayout(
                        new java.awt.GridLayout(1,3)
                );





                for (int i = 0; i < 9; i++) {
                    Panel panel = new Panel();
                    panel.setSize(20,20);
                    panel.setBackground(new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255)));
                    this.add(panel);
                }
            }

        }

        jFrame.getContentPane().add(new CenterGrid(), BorderLayout.CENTER);
        jFrame.getContentPane().add(new PageEndGrid(), BorderLayout.PAGE_END);
        jFrame.setSize(400,400);
        jFrame.setVisible(true);

    }
}
