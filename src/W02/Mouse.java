package W02;

public class Mouse implements USB{
    //implementować możę dowolnie wiele interfejsów.
    //choć dziedziczyć może jedną klasę.


    @Override
    public void send(byte[] bytes) {
        System.out.println("Connected!");
    }
    @Override
    public String receive() {
        return "Mysz!";
    }
    public void test(){
        System.out.println("test");

    }
}
