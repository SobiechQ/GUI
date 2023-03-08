import java.util.Arrays;

public class Dijkstra {

    private static int[] costToIndex;
    private static MyList[] pathToIndex;
    private static Element from;
    private static Element to;
    private static MyList stack;

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


        //todo
        //może da sie z tego do while
        while (!stack.isEmpty()){
            stack.sout();
            tmp = stack.popTop();
            System.out.println("Zmieniono tmp na: " + tmp.getIndex());
            System.out.println("Obecna droga do tmp to: ");
            pathToIndex[tmp.getIndex()].sout();
            System.out.println();


            for (int i = 0; i < tmp.getPartnersCounter(); i++) {
                System.out.println();
                System.out.println("====");
                System.out.println("Tmp to: " + tmp.getIndex());
                System.out.println();
                if(costToIndex[tmp.getPartnerIndexById(i)] >
                        costToIndex[tmp.getIndex()] + tmp.getCostById(i)
                ){
                    System.out.println("Znaleziono tańszą drogę z " +tmp.getIndex()+" do "+tmp.getPartnerIndexById(i));
                    System.out.println("Kosztotwała: "+costToIndex[tmp.getPartnerIndexById(i)]+" a teraz jest: "+(costToIndex[tmp.getIndex()] + tmp.getCostById(i)));


                    pathToIndex[tmp.getPartnerIndexById(i)].clone(pathToIndex[tmp.getIndex()]);
                    pathToIndex[tmp.getPartnerIndexById(i)].pushBot(tmp.getPartnerById(i));
                    costToIndex[tmp.getPartnerIndexById(i)] = costToIndex[tmp.getIndex()] + tmp.getCostById(i);

                    if(!stack.isElementInList(tmp.getPartnerById(i))) {
                        stack.pushBot(tmp.getPartnerById(i));
                        System.out.println("Do stosu dodano: "+tmp.getPartnerIndexById(i));
                    }
//                    stack.sout();

                } else {
                    System.out.println("Droga jest droższa z: " +tmp.getIndex()+" do "+tmp.getPartnerIndexById(i));
                    System.out.println("Kosztuje: "+(costToIndex[tmp.getIndex()] + tmp.getCostById(i))+" a najtańsza znaleziona to: "+costToIndex[tmp.getPartnerIndexById(i)]);
                }


                System.out.println("koniec fori");
            }
            System.out.println("duzyWhile");
        }
        System.out.println("wyszedlem z whole!!!!");



    }
    public static void sout(){
        for (int i = 0; i < costToIndex.length; i++) {
            System.out.println("Do "+i+", koszt: "+costToIndex[i]);
        }
    }
    public static void soutToTarget(){
        pathToIndex[to.getIndex()].sout();
    }




}
