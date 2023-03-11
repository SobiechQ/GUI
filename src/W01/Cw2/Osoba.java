package W01.Cw2;

public abstract class Osoba {
    public static int index;
    private String imie;
    private String pesel;
    private String profesja;
    private Konto konto;
    private int id;

    private Osoba(){
        this.id=Osoba.index++;
        System.out.println("Nowa osoba!");

    }

    Osoba(String imie, String pesel) {
        this();
        this.imie = imie;
        this.pesel = pesel;
    }


    public String getImie() {
        return imie;
    }

    public String getPesel() {
        return pesel;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setProfesja(String profesja) {
        this.profesja = profesja;
    }

    public static void setIndex(int index) {
        Osoba.index = index;
    }

    public String getProfesja() {
        return profesja;
    }

    public int getId() {
        return id;
    }

    public abstract void printProfesja();
    public void printBasic(){
        System.out.println("  ");
        System.out.println(this.imie+", "+this.pesel);
        this.printProfesja();
        System.out.println("  ");
    }





    public class Konto{
        int stanKonta;

        public Konto(int stanKonta) {
            this.stanKonta = stanKonta;
        }

        public void printStan(){
            System.out.println(this.stanKonta);
        }
    }

    public static class Gracz extends Osoba {
        Konto konto;
        Gracz(){
            this("defImie","defPes");
        }


        public Gracz(String imie, String pesel) {
            super(imie, pesel);
            this.konto = new Konto(10);
        }

        @Override
        public void printProfesja() {
            System.out.println("graczzzzzz");
        }
        public static void graj(){
            class Pistolet{
                int naboje=6;
                public void strzel(){
                    if(naboje<=0){
                        System.out.println("Nie masz czym strzelać");
                        return;
                    }


                    System.out.println("strzał!");
                    naboje--;
                }
                public static void getInfo(){
                    System.out.println("To rewolwer");
                }
            }
            Pistolet.getInfo();
            Pistolet pistolet = new Pistolet();
            for (int i = 0; i < 7; i++) {
                pistolet.strzel();
            }
        }

    }
    public static class Debil extends Osoba{
        public Debil() {
            this(null,null);
        }
        public Debil(String imie, String pesel) {
            super(imie, pesel);
        }

        @Override
        public void printProfesja() {
            System.out.println("debilowey aba");
        }
    }

}
