package W07.Z04.Center;

import java.awt.*;

public class CenterScrollPane extends ScrollPane {
    public CenterScrollPane(){
        this.add(new CenterJPanel());
        this.setBackground(Color.decode("#005f73"));
    }
}
