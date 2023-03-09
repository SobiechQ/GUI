package W01.Cw1;

public class ProstokatException extends Exception{
    @Override
    public String getMessage() {
        return "Bledny prostokat!";
    }
}
