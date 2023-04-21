package W07.Z02.his.curr.ex02;

import javax.swing.*;
import java.awt.*;

public
    class FlowLayoutPanel
    extends JPanel {

    public FlowLayoutPanel() {
        this.setLayout(new FlowLayout());

        for(int i=0; i<10; i++)
            this.add( new JButton("B"+i));
    }
}
