package W07.W01;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutPanel
        extends JPanel {
    public BorderLayoutPanel(){
        this.setLayout(new BorderLayout());
        this.add(new JButton("ClickMe"));

    }

}
