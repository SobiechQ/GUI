package MODEL;

import java.awt.*;

public class Utils {
    public static Color getRandomColor(){
        return new Color(
                (int)(Math.random()*255),
                (int)(Math.random()*255),
                (int)(Math.random()*255)
        );
    }

}
