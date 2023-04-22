package W07.Z04.Center;
import javax.swing.*;
import java.awt.*;

public class CenterJPanel extends JPanel{
    public CenterJPanel(){
        this.setBackground(Color.decode("#005f73"));
        this.add(new GridJPanel());
    }
}
