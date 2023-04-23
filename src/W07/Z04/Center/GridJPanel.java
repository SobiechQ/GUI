package W07.Z04.Center;
import W07.Z04.MessageListener.EventMessage;
import W07.Z04.MessageListener.EventMessages;
import W07.Z04.MessageListener.MessageListener;
import javax.swing.*;
import java.awt.*;
import java.util.Stack;


public class GridJPanel extends JPanel implements MessageListener{
    private final GridLayout gridLayout = new GridLayout();
    private final Stack<TicketJPanel> ticketJPanels = new Stack<>();

    GridJPanel(){
        EventMessage.addMessageListener(this);
        this.gridLayout.setColumns(1);
        this.gridLayout.setVgap(10);
        this.setBackground(Color.decode("#005f73"));
        this.setLayout(gridLayout);

    }
    @Override
    public void fireMessage(EventMessage eventMessage) {
        if (eventMessage.getMessage().equals(EventMessages.ADD_NEW_TICKET))
            this.ticketJPanels.add(new TicketJPanel());
        if (this.ticketJPanels.size()>0 && eventMessage.getMessage().equals(EventMessages.REMOVE_TICKET))
            this.ticketJPanels.pop();
        this.repaintAllTickets();
    }
    private void repaintAllTickets(){
        this.removeAll();
        this.gridLayout.setRows(this.ticketJPanels.size());
        for (TicketJPanel ticketJPanel : ticketJPanels)
            this.add(ticketJPanel);
        this.repaint();
        this.revalidate();
    }
}
