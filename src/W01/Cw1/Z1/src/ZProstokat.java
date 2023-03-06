public class ZProstokat extends Prostokat{
    private static int countProstokat=1;
    private static int countKwadrat=1;
    private int index;
    private char borderSymbol;
    private char insideSymbol;

    public ZProstokat(int width, int height, char insideSymbol, char borderSymbol) {
        super(width, height);
        this.borderSymbol = borderSymbol;
        this.insideSymbol = insideSymbol;
        this.index = this.isKwadrat() ? countKwadrat++ : countProstokat++;
    }
    public ZProstokat(int size, char outSymbol, char insideSymbol){
        this(size, size, outSymbol, insideSymbol);
    }

    @Override
    public boolean isPoprawny() {
        if (this.borderSymbol == this.insideSymbol)
            return super.isPoprawny();
        return this.getWidth()>1 &&
                this.getHeight()>1;
    }

    @Override
    public void rysuj() throws ProstokatException {
        System.out.println();

        System.out.print((isKwadrat()?"Kwadrat":"Prostokat")+
                " ("+this.getIndex()+") " +
                "rozmiaru: " + this.getWidth() + " x " + this.getHeight()
        );
        if(!this.isPoprawny()){
            System.out.println();
            throw new ProstokatException();
        }
        //Liczenie ile znaków.
        System.out.println(", "+(
                (this.getInsideSymbol()!=this.getBorderSymbol()) ?
                    this.getInsideSymbol() + "=" + (this.getWidth()*this.getHeight()-this.countBorderElements()) + ", "
                        :"") +
                this.getBorderSymbol() + "=" + this.countBorderElements()
        );







        for (int i = 0; i < this.getHeight(); i++) {


//            System.out.println();
        }




    }






    public static int getCountProstokat() {
        return countProstokat;
    }

    public static int getCountKwadrat() {
        return countKwadrat;
    }

    public int getIndex() {
        return index;
    }

    public char getBorderSymbol() {
        return borderSymbol;
    }

    public char getInsideSymbol() {
        return insideSymbol;
    }
    private int countBorderElements(){
        return this.getWidth()*2 + this.getHeight()*2 - 4;
    }
}
