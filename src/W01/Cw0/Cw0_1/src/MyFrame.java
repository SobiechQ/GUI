import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class MyFrame extends JFrame {


    protected static final int LENGTH = 7; //even length produces graphical conjecture in center
    private final Color BACKGROUND=Color.decode("#264653");
    private static final int SIZE = 700;
    protected static int RADIUS_OF_MAP;
    protected static final int RADIUS_OF_ELEMENT = (SIZE)/20;
    protected static final int RADIUS_OF_SMALL = (SIZE)/200;
    public Element[] elements;
    private Color[] colors = {
            Color.decode("#e9d8a6"),
            Color.decode("#ee9b00"),
            Color.decode("#ca6702"),
            Color.decode("#bb3e03"),
            Color.decode("#ae2012"),
            Color.decode("#9b2226"),
    };
    MyFrame(){
        super("Dijkstra");
        Element.myFrame = this;
        Link.setMyFrame(this);
        this.setSize(SIZE,SIZE+20);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        elements = new Element[LENGTH];

        MyFrame.setRadiusOfMap(this);


        for (int i = 0; i < LENGTH; i++) {
            elements[i]=new Element();
        }
        for(Element e:elements){
            e.addLinks();
        }
        ImageIcon img = new ImageIcon("src/W15/W15_7/content/ico.png");
        this.setIconImage(img.getImage());



    }
    public void paint (Graphics g){
        MyFrame.setRadiusOfMap(this);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        {
            //AntiAliasing
            Graphics2D g2d = (Graphics2D) g;
            RenderingHints rhints = g2d.getRenderingHints();
            boolean antialiasOn = rhints.containsValue(RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }

        //Background Color and map ring
        super.paint(g);
        g.setColor(this.BACKGROUND);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
        g.setColor(Color.decode("#e9c46a"));
        fillRing(g,this.getWidth()/2,this.getHeight()/2,RADIUS_OF_MAP,4);


//        System.out.println(this.getWidth()+", "+this.getHeight());
        //draw all Elements
        for(Element e: elements){
            e.setXY();
            for(Link l: e.links){
//                System.out.println("\t Connected to: "+l.getPartnerIndex()+" and costs: "+l.getCost());
            }

            fillRing(g,e.x,e.y,MyFrame.RADIUS_OF_ELEMENT,3);
        }
        for(Element e:elements){
            for(Link l:e.links){
                if(!l.partnerExists())
                    continue;
                g.fillArc(l.getBaseX()-RADIUS_OF_SMALL,l.getBaseY()-RADIUS_OF_SMALL,RADIUS_OF_SMALL*2,RADIUS_OF_SMALL*2,0,360);
                g.fillArc(l.getPartnerX()-RADIUS_OF_SMALL,l.getPartnerY()-RADIUS_OF_SMALL,RADIUS_OF_SMALL*2,RADIUS_OF_SMALL*2,0,360);
                g2.drawLine(l.getBaseX(),l.getBaseY(),l.getPartnerX(),l.getPartnerY());
            }
        }
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Lato", Font.PLAIN, 40);
        g2d.setFont(font);


        //Element Labels
        g.setColor(colors[4]);
        for (Element e : elements) {
            g2d.drawString(String.valueOf(e.getIndex()),
                    e.getX() - g2.getFontMetrics().stringWidth(String.valueOf(e.getIndex())) / 2f
                    ,Math.round(e.getY()-RADIUS_OF_ELEMENT - g2.getFontMetrics().getHeight()/4f )  + g2.getFontMetrics().getHeight()/4f);
        }



        //Cost Labels
        font = new Font("Lato", Font.PLAIN, 20);
        g2d.setFont(font);
        g.setColor(colors[2]);
        for(Element e:elements){
            for (Link l : e.links) {
                if (!l.partnerExists())
                    continue;
                g2d.drawString(String.valueOf(l.getCost()),
                        (l.getBaseX() + l.getPartnerX()) / 2,
                        (l.getBaseY() + l.getPartnerY()) / 2
                );
            }
        }





    }
    private void fillRing(Graphics g,int x, int y, int radius, int thickness){
        Color tmpColor = g.getColor();
        g.fillArc(x-radius,y-radius,2*radius,2*radius,0,360);
        g.setColor(this.BACKGROUND);
        g.fillArc(x-radius+thickness,y-radius+thickness,(2*radius)-2*thickness,(2*radius)-2*thickness,0,360);
        g.setColor(tmpColor);
    }

    private static void setRadiusOfMap(MyFrame myFrame){

        RADIUS_OF_MAP = myFrame.getHeight()>myFrame.getWidth() ?
                (int) Math.round(myFrame.getWidth() / 3f):
                (int) Math.round(myFrame.getHeight() / 3f);
    }

    public Element getElementByIndex(int index){
        if(index>=MyFrame.LENGTH)
            return null;
        return elements[index];
    }

}
