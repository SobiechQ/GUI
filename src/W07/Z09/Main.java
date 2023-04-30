package W07.Z09;

import W07.Z09.Cennik.Cennik;
import W07.Z09.Gatunki.Komedia;
import W07.Z09.Klient.Klient;
import W07.Z09.Klient.Koszyk;

public class  Main {
    public static void main(String[] args) {
        Cennik.pobierzCennik().dodaj("raz","abc",11,10,3,1);
        Cennik.pobierzCennik().dodaj("dwa","dwa", 5,40);
        Klient klient = new Klient("Jan",100);
        klient.dodaj(new Komedia("abc",15));
        Koszyk koszyk = new Koszyk(klient);
        klient.przepakuj(koszyk);
        System.out.println(klient.getStanKonta());
    }
}
