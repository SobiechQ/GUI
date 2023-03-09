import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame{
        private static final int SIZE = 1000;
        private static int radiusOfElement;
        private static int radiusOfSmall;
        public static MyFrame myFrame;
        private static final Color[] colors = {
                Color.decode("#264653"),
                Color.decode("#e9d8a6"),
                Color.decode("#ee9b00"),
                Color.decode("#ca6702"),
                Color.decode("#bb3e03"),
                Color.decode("#ae2012"),
                Color.decode("#9b2226"),
        };
        private int radiusOfMap;
        MyFrame(){
            super("Dijkstra");
            this.setSize(SIZE,SIZE+20);
            this.setVisible(true);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            ImageIcon img = new ImageIcon("src/W15/W15_7/content/ico.png");
            this.setIconImage(img.getImage());
            setRadiusOfMap(this);
            myFrame = this;
        }
        public void paint (Graphics g){
            setRadiusOfMap(this);
            radiusOfElement = (this.radiusOfMap)/8;
            radiusOfSmall = (this.radiusOfMap)/80;
            Graphics2D g2 = (Graphics2D) g;
            RenderingHints rhints = g2.getRenderingHints();
            boolean antialiasOn = rhints.containsValue(RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(2));
            super.paint(g);
            g.setColor(colors[0]);
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            //map circle
            g.setColor(colors[2]);
            fillRing(g,this.getWidth()/2,this.getHeight()/2,radiusOfMap,4);

            //element circles
            for (Element e : Element.getElements()) {
                fillRing(g,e.getX(),e.getY(), radiusOfElement,4);
            }

            //connections
            for (Element elementBase : Element.getElements()) {
                for (int i = 0; i < elementBase.getPartnersCounter(); i++) {
                    g.fillArc(elementBase.getPartnerById(i).getX() - radiusOfSmall,elementBase.getPartnerById(i).getY()- radiusOfSmall, radiusOfSmall *2, radiusOfSmall *2,0,360);
                    g2.drawLine(elementBase.getX(),elementBase.getY(),elementBase.getPartnerById(i).getX(),elementBase.getPartnerById(i).getY());
                }
            }
            Font font = new Font("Lato", Font.PLAIN, 40);
            g2.setFont(font);

            // Element labels
            g.setColor(colors[4]);
            for (Element e : Element.getElements()) {
                g2.drawString(String.valueOf(e.getIndex()),
                        e.getX() - g2.getFontMetrics().stringWidth(String.valueOf(e.getIndex())) / 2f
                        ,Math.round(e.getY()- radiusOfElement - g2.getFontMetrics().getHeight()/4f )  + g2.getFontMetrics().getHeight()/4f);
            }

            //cost labels
            font = new Font("Lato", Font.PLAIN, 20);
            g2.setColor(colors[3]);
            g2.setFont(font);
            for (Element e : Element.getElements()) {
                for (int i = 0; i < e.getPartnersCounter(); i++) {
                    g2.drawString(String.valueOf(e.getCostById(i)),
                            (e.getPartnerById(i).getX() + e.getX()) / 2,
                            (e.getPartnerById(i).getY() + e.getY()) / 2
                    );
                }
            }
            for (int i = 0; i < Element.getElementsLength(); i++) {
                Element.getElementById(i).setXY();
            }


            //draw found path
            if(!Dijkstra.isDone())
                return;


            g2.setStroke(new BasicStroke(4));
            g2.setColor(colors[5]);
            MyList found = new MyList();
            found.clone(Dijkstra.getPathToTarget());
            Element tmpFrom;
            Element tmpTo = found.popTop();
            int sum=0;
            do {
                tmpFrom = tmpTo;
                tmpTo = found.popTop();
                g2.drawLine(tmpFrom.getX(), tmpFrom.getY(), tmpTo.getX(), tmpTo.getY());
            } while (!found.isEmpty());




        }

        private static void fillRing(Graphics g,int x, int y, int radius, int thickness){
            Color tmpColor = g.getColor();
            g.fillArc(x-radius,y-radius,2*radius,2*radius,0,360);
            g.setColor(colors[0]);
            g.fillArc(x-radius+thickness,y-radius+thickness,(2*radius)-2*thickness,(2*radius)-2*thickness,0,360);
            g.setColor(tmpColor);
        }

        private void setRadiusOfMap(MyFrame myFrame){
            this.radiusOfMap = myFrame.getHeight()>myFrame.getWidth() ?
                    (int) Math.round(myFrame.getWidth() / 3f):
                    (int) Math.round(myFrame.getHeight() / 3f);
        }

    public int getRadiusOfMap() {
        return radiusOfMap;
    }

}
