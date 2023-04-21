package W07.Z02.his.curr;

import javax.swing.*;
import java.awt.*;

public class MyColorRes
    extends JPanel
    implements ColorListener{

    public MyColorRes() {
        this.setBackground(Color.DARK_GRAY);
    }

    @Override
    public void colorChanged(ColorEvent evt) {
        this.setBackground(evt.getColor());
    }
}
