package W07.Z03;
import javax.swing.*;
import java.awt.*;

public class Center extends JPanel {
    public Center(){
        this.setLayout(new GridLayout(10,10));
        for (int i = 0; i < 100; i++)
            this.add(new Block());
    }

}
