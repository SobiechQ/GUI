package W07.Z04.MessageListener;
import java.util.ArrayList;
import java.util.EventObject;

public class EventMessage extends EventObject {
    private final EventMessages message;
    private static final ArrayList<MessageListener> messageListeners = new ArrayList<>();
    public EventMessage(Object source, EventMessages message) {
        super(source);
        this.message=message;
    }

    public EventMessages getMessage() {
        return message;
    }
    public static void addMessageListener(MessageListener messageListener){
        EventMessage.messageListeners.add(messageListener);
    }
    public static void fireMessageListeners(EventMessage eventMessage){
        System.out.println("Recived event:");
        System.out.println(eventMessage);
        new Thread(()->{
            for (int i = 0; i < messageListeners.size(); i++) {
                messageListeners.get(i).fireMessage(eventMessage);
            }
        }).start();
    }

    @Override
    public String toString() {
        return "EventMessage{" +
                "message=" + message +
                ", source=" + source +
                '}';
    }
}
