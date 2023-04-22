package W07.Z03;

import MODEL.Utils;

import javax.swing.*;
import java.awt.*;

public class Block extends JPanel implements ChangeColorListener{
    Block(){
        this.setBackground(Utils.getRandomColor());
        this.setPreferredSize(new Dimension(30,30));
        Main.changeColorListenerArrayList.add(this);

    }

    @Override
    public void chageTo(String s) {
        this.setBackground(Color.decode(s));
    }
}
