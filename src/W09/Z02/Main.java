package W09.Z02;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public static Main main;
    public static String[] args;
    public static void main(String[] args) {
        Main.args = args;
        SwingUtilities.invokeLater(Main::new);
    }
    public Main(){
        Main.main = this;
        this.add(new MyColor());


        this.setSize(700,700);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void colorRecived(Color color){
        Main.args = new String[] {"Dialog", "BOLDITALIC", "14"};

        JPanel jPanel =  new JPanel();
        jPanel.setPreferredSize(new Dimension(700,700));
        JTextArea jTextArea = new JTextArea();
        jTextArea.setFont(Font.decode(String.join("-", Main.args)));
        jTextArea.setForeground(color);
        jTextArea.setPreferredSize(new Dimension(700,700));


        jPanel.add(jTextArea);
        this.setContentPane(jPanel);




        this.revalidate();
        this.repaint();
    }

}
