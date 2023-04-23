package W07.Z04.LogScreen;

import W07.Z04.MessageListener.EventMessage;
import W07.Z04.MessageListener.EventMessages;

import javax.swing.*;
import java.awt.*;
import java.util.EventObject;

public class LogScreen extends JPanel {
        private final JTextField jTextFieldEmail = new JTextField();
        private final JTextField jTextFieldPassword = new JTextField();
    public LogScreen(){
        GridLayout gridLayout = new GridLayout(3,2);
        this.setLayout(gridLayout);

        this.add(new JLabel("Email:"));
        this.add(jTextFieldEmail);

        this.add(new JLabel("Password:"));
        this.add(jTextFieldPassword);


        JButton button = new JButton("Log In");
        button.addActionListener(this::handleButtonEvent);
        this.add(button);


        this.setPreferredSize(new Dimension(400,70));
    }
    private void handleButtonEvent(EventObject eventObject){

        if (this.jTextFieldEmail.getText().equals("email"))
            EventMessage.fireMessageListeners(new EventMessage(this, EventMessages.LOG_ON_SUCCESS));
    }


}
