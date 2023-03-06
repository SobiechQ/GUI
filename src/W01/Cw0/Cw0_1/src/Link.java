public class Link {
    private static MyFrame myFrame;
    private final Element base;

    /**
        Might produce null pointer exception.
        For null partners X and Y getters return 0, and -1 for index.
     */
    private Element partner;
    private int cost =-1;

    Link(Element base){
        this.base=base;
        int partnerId = (base.index+(int)(1+((Math.random())*(myFrame.elements.length-1))))%myFrame.elements.length;

        //check base connection for duplicates.
        int i=0;
        for (Link l : base.links) {
            if(l==null){
                i++;
                continue;
            }
            if(myFrame.elements[partnerId]!=l.partner)
                i++;
        }

        if(i!=base.links.length){
//            System.out.println(base.index+", Tried connecting to: "+partnerId+" but failed. Base already has this connection");
            return;
        }


        //check partners connections for dupilcats.
        i=0;
        if(myFrame.elements[partnerId].links!=null){
            for(Link l:myFrame.elements[partnerId].links){
                //how many conenctins to Elements other than base;
                if(base!=l.partner)
                    i++;
            }
            //create connection only if partner isnt linked with base.
            if(i!=myFrame.elements[partnerId].links.length){
//                System.out.println(base.index+", Tried connecting to: "+partnerId+" but failed. Partner has this connection");
                return;
            }
        }
        partner=myFrame.elements[partnerId];
        this.setCost();

    }



    public static void setMyFrame(MyFrame myFrame) {
        Link.myFrame = myFrame;
    }
    public int getPartnerIndex(){
        return partner==null?-1:partner.index;
    }
    public int getBaseX(){
        return base.x;
    }
    public int getBaseY(){
        return base.y;
    }
    public int getPartnerX(){
        return partnerExists()?partner.x:0;
    }
    public int getPartnerY(){
        return partnerExists()?partner.y:0;
    }
    public boolean partnerExists(){
        return partner!=null;
    }
    private void setCost() {
        if (this.partnerExists())
            this.cost = (int) Math.round(
                    (
                            Math.sqrt(
                                Math.pow(this.getBaseX() - this.getPartnerX(), 2) +
                                Math.pow(this.getBaseY() - this.getPartnerY(), 2)
                            )
                    /20
                    )*(
                    2 * Math.random() + 0.2
                    )

            );
    }

    /**
     * Might return null
     */
    public Element getPartner() {
        return partner;
    }

    public Element getBase() {
        return base;
    }

    public int getCost() {
        return cost;
    }
}
