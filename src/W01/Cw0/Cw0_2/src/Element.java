public class Element {
    private static Element[] elements;
    private static int creationCounter=0;
    private final int index;
    private int x,y;
    private final double alfa;
    private Element[] elementsLinked;
    private int connectionsCounter=0;


    private Element(){
        this.index = Element.creationCounter++;
        this.alfa = -0.5*Math.PI +(2d*creationCounter*Math.PI/elements.length);
        this.elementsLinked=new Element[elements.length-1];
        this.setXY();
    }
    public void soutPos(){
        System.out.println("Index: " + this.index+", X: ("+this.x+"), Y: ("+this.y+"), Beta: ("+this.alfa +").");
        System.out.println("Connects to: ");
        for (int i = 0; i < connectionsCounter; i++) {
            System.out.println("\t"+elementsLinked[i].getIndex());
        }
    }





    public static void setElements(int length) {
        elements = new Element[length];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = new Element();
        }
        Link.setLinks(length); // Prepare all connections.
    }
    public int getIndex() {
        return index;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Element[] getElements() {
        return elements;
    }
    public static int getElementsLength(){
        return elements.length;
    }
    public static Element getElementById(int index){
        return elements[index];
    }
    public void setXY(){
        this.x = (int) Math.round(MyFrame.myFrame.getWidth()/2f+(MyFrame.myFrame.getRadiusOfMap()*Math.cos(this.alfa)));
        this.y = (int) Math.round(MyFrame.myFrame.getHeight()/2f+(MyFrame.myFrame.getRadiusOfMap()*Math.sin(this.alfa)));
    }
    public void connectionAdd(Element element){
        this.elementsLinked[this.connectionsCounter++]=element;
    }

}
