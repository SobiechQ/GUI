package W02.Z02;

public class Zakon {
    public String nazwa;
    public Mieszkaniec[] mieszkaniecs = new Mieszkaniec[100];
    private int populacja=0;

    public Zakon(String nazwa) {
        this.nazwa = nazwa;
    }
    public void dodaj(Mieszkaniec mieszkaniec){
        this.mieszkaniecs[populacja++]=mieszkaniec;
    }
    public void urodzinyBoga(){
        for (int i = 0; i < populacja; i++) {
            mieszkaniecs[i].modlSie();
        }
    }
}
