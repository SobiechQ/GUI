package W02;

public class Computer {


    public void connect(USB usb){
        usb.send(new byte[]{1});
        String devId = usb.receive();
        System.out.println("Id is: "+devId);

    }
}
