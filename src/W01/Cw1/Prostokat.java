package W01.Cw1;

public class Prostokat {
    //Wspólne ID w tej klasie cho c inkrementowane różnie dla kwadratów i prostokatów.
    private int width;
    private int height;

    public Prostokat(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public boolean isKwadrat(){
        return width==height;
    }
    public void rysuj() throws ProstokatException {
        System.out.println();
        System.out.println("Zwykly prostokat rozmiaru: "+this.getWidth()+" x "+this.getHeight());
        if(!isPoprawny())
            throw new ProstokatException();
    }
    public boolean isPoprawny(){
        return this.height>=1 &&
                this.width>=1;
    }


}
