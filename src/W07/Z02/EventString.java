package W07.Z02;

import java.util.EventObject;

public class EventString extends EventObject {
    private String message;
    EventString(Object source,String message){
        super(source);
        this.message =message;
    }

    public String getMessage() {
        return message;
    }
}
