package W07.Z04.PageEnd;

import W07.Z04.MessageListener.EventMessage;
import W07.Z04.MessageListener.EventMessages;

import javax.swing.*;
import java.awt.*;

public class PageEndJPanel extends JPanel {
    private static class MyJButton extends JButton{
        MyJButton(String name){
            this.setText(name);
            this.setPreferredSize(new Dimension(100,35));
            this.addActionListener(e -> EventMessage.fireMessageListeners(new EventMessage(this,
                    this.getText().equals("Dodaj")? EventMessages.ADD_NEW_TICKET:
                            this.getText().equals("Usun")? EventMessages.REMOVE_TICKET:
                                    EventMessages.DO_NOTHING
            )));
        }
    }


    public PageEndJPanel(){
        this.setBackground(Color.decode("#ae2012"));
        this.add(new MyJButton("Dodaj"));
        this.add(new MyJButton("Usun"));
    }
}
