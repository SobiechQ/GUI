package W02.Z02;

public abstract class Osoba implements Mieszkaniec{
    private String imie;
    private int wiek;

    protected Osoba(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

    protected void soutImie(){
        System.out.println("Nazywam się: "+this.imie);
    }
    protected boolean isPelnoletni(){
        return this.wiek>=18;
    }
    protected abstract void soutZawod();

    protected String getImie() {
        return imie;
    }

    protected int getWiek() {
        return wiek;
    }
}
