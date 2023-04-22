package W07.Z04.Center;

import MODEL.Person;
import MODEL.Utils;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class TicketJPanel extends JPanel {
    Person person = new Person();
    private static int colorIndex = 0;
    private static String[] colors = {
            "#ee9b00",
            "#ca6702",
            "#bb3e03",
            "#ae2012",
            "#9b2226"
    };
    TicketJPanel(){
        this.setPreferredSize(new Dimension(500,80));
        this.setBackground(Color.decode(colors[(colorIndex++%colors.length)]));
        this.setLayout(new GridLayout(1,2));
        this.add(new JLabel(person.getFirstName()));
        this.add(new JLabel(person.getSecondName()));


    }
}
