package W07.Z04.LogScreen;

import W07.Z04.MyEventListener.EventMessage;

import javax.swing.*;
import java.awt.*;

public class LogScreen extends JPanel {
    public LogScreen(){
        GridLayout gridLayout = new GridLayout(3,2);
        this.setLayout(gridLayout);
        this.add(new JLabel("Email:"));
        this.add(new JTextPane());
        this.add(new JLabel("Password:"));
        this.add(new JTextPane());


        JButton button = new JButton("hello");
        button.addActionListener(e -> EventMessage.fireMessageListeners(new EventMessage(e, "LOG_ON_SUCCESS")));
        this.add(button);


        this.setPreferredSize(new Dimension(400,70));

    }
}
