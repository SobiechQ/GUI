public class Main {
    public static void main(String[] args) {
        new MyFrame();
        Element.setElements(7);
        Dijkstra.set(Element.getElementById(0),Element.getElementById(1));
        Dijkstra.sout();
    }
}
