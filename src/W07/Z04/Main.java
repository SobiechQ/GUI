package W07.Z04;

import W07.Z04.Center.CenterJPanel;
import W07.Z04.Center.CenterScrollPane;
import W07.Z04.LogScreen.LogScreen;
import W07.Z04.MessageListener.EventMessage;
import W07.Z04.MessageListener.EventMessages;
import W07.Z04.MessageListener.MessageListener;
import W07.Z04.PageEnd.PageEndJPanel;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame implements MessageListener {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
    Main(){
        EventMessage.addMessageListener(this);


        JPanel logScreenJPanel = new JPanel();
        logScreenJPanel.add(new LogScreen());
        this.getContentPane().add(logScreenJPanel);
        this.setSize(1280,720);
        this.setVisible(true);
    }

    @Override
    public void fireMessage(EventMessage eventMessage) {
        if(!eventMessage.getMessage().equals(EventMessages.LOG_ON_SUCCESS))
            return;
        this.getContentPane().removeAll();
        this.getContentPane().add(new CenterScrollPane(), BorderLayout.CENTER);
        this.getContentPane().add(new PageEndJPanel(), BorderLayout.PAGE_END);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.repaint();
        this.revalidate();

    }
}
