import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
        private static final int SIZE = 700;
        private static final int RADIUS_OF_ELEMENT = (SIZE)/20;
        private static final int RADIUS_OF_SMALL = (SIZE)/200;
//        public static Element[] elements;
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
                fillRing(g,e.getX(),e.getY(),RADIUS_OF_ELEMENT,4);
            }




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
    //        public static Element getElementByIndex(int index){
//            if(index>= W15.W15_7.MyFrame.LENGTH)
//                return null;
//            return elements[index];
//        }

}
