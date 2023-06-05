package W10.W01;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
    Main(){
        this.setVisible(true);
        this.setSize(400,400);
        this.add(new MyPanel());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
