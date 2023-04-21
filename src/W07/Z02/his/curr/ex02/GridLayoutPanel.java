package W07.Z02.his.curr.ex02;

import javax.swing.*;
import java.awt.*;

public
    class GridLayoutPanel
    extends JPanel {

    public GridLayoutPanel() {
        this.setLayout(
            new GridLayout(4, 3)
        );

        for(int i=0; i<15; i++)
            this.add(new JButton("B"+i));
    }
}
