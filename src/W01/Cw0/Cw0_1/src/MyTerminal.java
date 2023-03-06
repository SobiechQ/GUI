
public class MyTerminal {
    private final MyFrame myFrame;
    public MyTerminal(MyFrame myFrame) {
        Path.setMyFrame(myFrame);
        this.myFrame= myFrame;
    }
    public void open(){
        MyScanner ms = new MyScanner(System.in);
        Path.setStart(myFrame.getElementByIndex(4));
        for (Link l : Element.myFrame.elements[4].links) {
            System.out.println("CHECK: "+l.getPartnerIndex());
        }


        Path path = new Path(myFrame.getElementByIndex(4));
        path.soutPaths();
    }
}
