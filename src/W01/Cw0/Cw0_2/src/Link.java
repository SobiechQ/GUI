public class Link {
    private static Link[] links; //All possible links
    private final Element[] elements = new Element[2];

    private Link(Element elementLeft, Element elementRight){
        this.elements[0]=elementLeft;
        this.elements[1]=elementRight;

        this.callConnectionAdd();
    }





    public static void setLinks(int count){
        links = new Link[calculateLinks(count)]; //Array with all possible Links
        int iL=0;
        int iR=1;
        //fill that array with pointers to elements.
        for (int i = 0; i < links.length; i++) {
            if(iR==Element.getElementsLength()){
                iL++;
                iR=iL+1;
            }
            new Link(Element.getElementById(iL),Element.getElementById(iR));
            iR++;
        }



    }
    private static int calculateLinks(int count){
        if(count > 1)
            return count-1+calculateLinks(count-1);
        return 0;
    }

    public static Link[] getLinks() {
        return links;
    }
    public Element getElementById(int index){
        return this.elements[index];
    }
    private void callConnectionAdd(){
        elements[0].connectionAdd(elements[1]);
        elements[1].connectionAdd(elements[0]);
    }
}
