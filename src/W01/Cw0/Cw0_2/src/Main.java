public class Main {
    public static void main(String[] args) {
        new MyFrame();
        MyScanner ms = new MyScanner(System.in);
        Element.setElements(9);
        Dijkstra.set(Element.getElementById(ms.readInt()),Element.getElementById(ms.readInt()));
        Dijkstra.soutToTarget();

    }
}
