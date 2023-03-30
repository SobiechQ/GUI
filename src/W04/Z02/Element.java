package W04.Z02;

public class Element <T>{
    private T it;
    private Element next;

    public Element(T it) {
        this.it = it;
    }

    public T getIt() {
        return it;
    }

    public void setIt(T it) {
        this.it = it;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return it.toString();
    }
}
