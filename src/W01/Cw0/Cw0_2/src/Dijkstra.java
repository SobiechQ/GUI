import java.util.Arrays;

public class Dijkstra {

    private static int[] costToIndex;
    private static MyList[] shortestPathToIndex;
    private static Element tmp;
    private static Element from;
    private static Element to;
    private static Element[] stackPartner;

    public static void set(Element from, Element to){
        costToIndex=new int[Element.getElementsLength()];
        shortestPathToIndex=new MyList[Element.getElementsLength()];
        Arrays.fill(costToIndex, Integer.MAX_VALUE);
        tmp=from;
        checkConnections();
    }
    private static void checkConnections(){
//        stackPartner=tmp.getPartnersLinked();
        stackPartner = new Element[tmp.getPartnersCounter()];
        for (int i = 0; i < stackPartner.length; i++) {
            stackPartner[i]=tmp.getPartnerById(i);
        }


        for (int i = 0; i < stackPartner.length; i++) {
            //stackPartner[i].getIndex();
            if(costToIndex[stackPartner[i].getIndex()] >
                    tmp.getCostById(i)){
                /*
                todo znaleziono krótszą ścieżkę,
                todo Należy zaktualizować listę MyList do indeksu i do którego znaleziono ścieżkę.
                todo warto zrobić dodatkową listę przechowującą kroki dojścia do obecnego TMP z głowy dijkstry.
                 */

                costToIndex[stackPartner[i].getIndex()]=tmp.getCostById(i);
            }


        }
    }
    public static void sout(){
        for (int i = 0; i < costToIndex.length; i++) {
            System.out.println("Do "+i+", koszt: "+costToIndex[i]);
        }
    }




}
