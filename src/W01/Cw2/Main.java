package W01.Cw2;

public class Main {
    public static void main(String[] args) {
        Osoba.Gracz gracz = new Osoba.Gracz();
        Osoba.Debil debil = new Osoba.Debil();
        Osoba.Debil debil2 = new Osoba.Debil("Jan","0110");
        Osoba.Debil debil3 = new Osoba.Debil("pawel","2137");
        Osoba.Gracz gracz2 = new Osoba.Gracz("jumper","102"){
            @Override
            public void printProfesja() {
                System.out.println("Profesjonalista");
            }
            public void toNieDziala(){
                System.out.println("no nie");
            }

            @Override
            public String getImie() {
                return super.getImie()+" Jumpowski";
            }
        };
        var osubka = new Osoba("taka", "niewielka") {
            @Override
            public void printProfesja() {
                System.out.println("profesja osobowa");
            }
            public void jakiTypOsoby(){

            }
        };



        Osoba[] osobas = new Osoba[6];
        osobas[0]=gracz;
        osobas[1]=debil;
        osobas[2]=debil2;
        osobas[3]=debil3;
        osobas[4]=gracz2;
        osobas[5]=osubka;
        for (Osoba osoba : osobas) {
//            osoba.printBasic();
        }
        gracz2.graj();









    }
}
