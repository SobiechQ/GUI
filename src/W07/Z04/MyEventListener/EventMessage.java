package W07.Z04.MyEventListener;
import java.util.ArrayList;
import java.util.EventObject;

public class EventMessage extends EventObject {
    private final String message;
    private static final ArrayList<MessageListener> messageListeners = new ArrayList<>();
    public EventMessage(Object source, String message) {
        super(source);
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
    public static void addMessageListener(MessageListener messageListener){
        EventMessage.messageListeners.add(messageListener);
    }
    public static void fireMessageListeners(EventMessage eventMessage){
        new Thread(()->{
            for (MessageListener messageListener : EventMessage.messageListeners)
                messageListener.fireMessage(eventMessage);
        }).start();
    }

    @Override
    public String toString() {
        return "EventMessage{" +
                "message='" + message + '\'' +
                ", source=" + source +
                '}';
    }
}
