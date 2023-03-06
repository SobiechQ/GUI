public class Element {
    protected static MyFrame myFrame;
    private static int creationCounter=0;
    public final int index;
    public int x,y;
    private final double alfa = (2d*creationCounter*Math.PI/MyFrame.LENGTH);
    private final double beta = -0.5*Math.PI-alfa;


    public Link[] links;
    Element(){
        this.index =Element.creationCounter++;
        setXY();
    }
    public void soutPos(){
        System.out.println("Index: " + this.index+", X: ("+this.x+"), Y: ("+this.y+"), Beta: ("+this.beta+").");
    }
    public void addLinks(){
        //define amount of pointers.
        links = new Link[Math.random()<0.2?0:Math.random()<0.7?1:Math.random()<0.7?2:3];
        for (int i = 0; i < links.length; i++) {
            links[i]=new Link(this);
        }
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
    public void setXY(){
        this.x = (int) Math.round(myFrame.getWidth()/2f+(MyFrame.RADIUS_OF_MAP*Math.cos(this.beta)));
        this.y = (int) Math.round(myFrame.getHeight()/2f+(MyFrame.RADIUS_OF_MAP*Math.sin(this.beta)));
    }

}
