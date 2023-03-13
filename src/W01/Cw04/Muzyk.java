package W01.Cw04;

public abstract class Muzyk {
    private final String imie;
    private final double czasWystapienia;

    public Muzyk(String imie, double czasWystapienia) {
        this.imie = imie;
        this.czasWystapienia = czasWystapienia;
    }

    public abstract String instrument();
    public abstract float stawka();

    public String imie() {
        return imie;
    }

    public double czas() {
        return czasWystapienia;
    }
    public double getHonorarium(){
        //Miejsce wywołania polimorficznego
        return this.czas()*this.stawka();
    }

    public static Muzyk maxHonorarium(Muzyk[] muzyks){
        Muzyk max=muzyks[0];
        for (Muzyk m : muzyks) {
            if(m.getHonorarium()>max.getHonorarium())
                max=m;
        }
        return max;
    }

    @Override
    public String toString() {
        return this.imie()+", czas = "+this.czas()+" godz., stawka = "+this.stawka();
    }
}
