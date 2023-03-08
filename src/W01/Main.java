package W01;

public class Main {
    public static void main(String[] args) {
        //klasa zewnętrzna to taka, która nie jest zawarta w innej klasie
        //klasa zewnętrzna może byc tylko publiczna lub pakietowa

        //klasa wewnętrzna jest na rzecz obiektu

        //klasa zanurzona jest na rzecz klasy jest statyczna

        //klasa zawarta może być w metodzie.
        //nie może być zadeklarowana jako statyczna.
        //Klasa działą tylko w obrębie metody. Żyje od momentu zadeklarowania
        //do końca bloku w któej została zadeklarowana.

        //klasa anonimowa
        //zdefiniowa aza fabrykatorem, nie ma ani słowa class ani extends ani inplements
        //klasa anonimowa dziedziczy po wybranej klasie i można do niej dpisać więcej metod i parametrów.
//        Outer.StatInner.dupa();


        //klasa abstrakcyjna

        var abc = new Figura(){
            @Override
            public void test2() {

            } //MUSI zostac nadpisana jak dziedzicze chyba że dziedziczy klasa abtrakcyjna.

            void getA(){
                System.out.println(this.a);
            }
        };
        abc.getA();



    }





}
