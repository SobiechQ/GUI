package W01.Cw0;

import java.util.Arrays;

public class Dijkstra {

    private static int[] costToIndex;
    private static MyList[] pathToIndex;
    private static Element from;
    private static Element to;
    private static MyList stack;
    private static boolean done = false;

    public static void set(Element from, Element to){
        costToIndex=new int[Element.getElementsLength()];
        Arrays.fill(costToIndex, Integer.MAX_VALUE/2);
        pathToIndex=new MyList[Element.getElementsLength()];
        for (int i = 0; i < pathToIndex.length; i++) {
            pathToIndex[i]=new MyList();
        }
        Dijkstra.from=from;
        stack = new MyList(Dijkstra.from);
        Dijkstra.to = to;
        checkConnections();
    }
    private static void checkConnections(){
        Element tmp = from;
        //set connection to staring object as 0
        costToIndex[tmp.getIndex()]=0;
        pathToIndex[tmp.getIndex()].pushBot(tmp);
        while (!stack.isEmpty()){
            tmp = stack.popTop();
            for (int i = 0; i < tmp.getPartnersCounter(); i++) {
                if(costToIndex[tmp.getPartnerIndexById(i)] >
                        costToIndex[tmp.getIndex()] + tmp.getCostById(i)
                ){
                    //cheaper way to partner Found.
                    pathToIndex[tmp.getPartnerIndexById(i)].clone(pathToIndex[tmp.getIndex()]);
                    pathToIndex[tmp.getPartnerIndexById(i)].pushBot(tmp.getPartnerById(i));
                    costToIndex[tmp.getPartnerIndexById(i)] = costToIndex[tmp.getIndex()] + tmp.getCostById(i);
                    if(!stack.isElementInList(tmp.getPartnerById(i))) {
                        stack.pushBot(tmp.getPartnerById(i));
                    }
                }
            }
        }
        System.out.println("Lowest found cost: ");
        System.out.println(Dijkstra.getLowestCostToTarget());
        done = true;
        MyFrame.myFrame.repaint(300);
    }
    public static void sout(){
        for (int i = 0; i < costToIndex.length; i++) {
            System.out.println("Do "+i+", koszt: "+costToIndex[i]);
        }
    }
    public static void soutToTarget(){
        pathToIndex[to.getIndex()].sout();
    }

    public static MyList getPathToTarget() {
        return pathToIndex[to.getIndex()];
    }
    public static boolean isDone() {
        return done;
    }
    public static int getLowestCostToTarget(){
        return costToIndex[to.getIndex()];
    }
}
