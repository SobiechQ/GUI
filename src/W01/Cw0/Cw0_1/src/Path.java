public class Path {
    private static int shortestLength[];
    private static Element start;
    private static Element stop;
    private Element head;
    private Element tail;
    private MyList myList;
    private static MyFrame myFrame;

    public static void setMyFrame(MyFrame myFrame) {
        Path.myFrame = myFrame;
    }
    Path(Element e){
        myList = new MyList();
        this.head=e;


        //add to MyList all Paths that originate at e.
        for (Link l : e.links) {
            myList.add(new Path(this.head, l.getPartner()));
        }


    }
    private Path(Element head, Element tail){
        this.head=head;
        this.tail=tail;
    }

    public static void setStart(Element start) {
        Path.start = start;
    }
    public void soutPaths(){
        System.out.println();
        System.out.println(" Element: "+this.head.index+" connects to: ");
        MyList tmp = myList;
        while (tmp!=null){
            System.out.println("\t -> " + tmp.getHead().tail.index);
            tmp=tmp.getNext();
        }
    }

    public static Element getStart() {
        return start;
    }

    public static Element getStop() {
        return stop;
    }

    public Element getHead() {
        return head;
    }

    public Element getTail() {
        return tail;
    }
}
