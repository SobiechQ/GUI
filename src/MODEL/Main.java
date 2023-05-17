package MODEL;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
    Main(){
        this.setVisible(true);
        this.setSize(400,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
