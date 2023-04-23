package W07.W01;

import javax.swing.*;
import java.awt.*;

public class Main{
    JFrame jFrame = new JFrame();
    public Main(){


//        this.getContentPane().add(new BorderLayoutPanel(), BorderLayout.CENTER);
        jFrame.getContentPane().add(new GridLayout(), BorderLayout.LINE_END);
        //layout ma zawsze pierszenstwo w ustalaniu wielkosci
        //mozna wymusic rozmiar wywylujac setpreffered size
        //mozna dac set maximum size i set minimum size -> są to sugestie do jakoego rozmariu moze sie powiekszac i pomniejszac




        jFrame.setSize(640, 480);
        jFrame.setVisible(true);

    }
    public static void main(String[] args) {
        //collect vs reduce

        SwingUtilities.invokeLater(Main::new);







    }
}
