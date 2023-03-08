public class Main {
    public static void main(String[] args) {
        new MyFrame();
        Element.setElements(7);
        Dijkstra.set(Element.getElementById(0),Element.getElementById(1));
//        Dijkstra.sout();
        MyList myList = new MyList(Element.getElementById(0));
        myList.pushTop(Element.getElementById(1));
        myList.pushTop(Element.getElementById(3));
        myList.pushTop(Element.getElementById(4));
        System.out.println(myList.popTop().getIndex());
        System.out.println(myList.popTop().getIndex());
        System.out.println(myList.popTop().getIndex());
//        myList.sout();


    }
}
