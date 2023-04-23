package W07.Z04.PageEnd;

import W07.Z04.MyEventListener.EventMessage;

import javax.swing.*;
import java.awt.*;

public class PageEndJPanel extends JPanel {
    private static class MyJButton extends JButton{
        MyJButton(String name){
            this.setText(name);
            this.setPreferredSize(new Dimension(100,35));
            this.addActionListener(e -> EventMessage.fireMessageListeners(new EventMessage(this, this.getText())));
        }
    }


    public PageEndJPanel(){
        this.setBackground(Color.decode("#ae2012"));
        this.add(new MyJButton("Dodaj"));
        this.add(new MyJButton("Usun"));
    }
}
