package W02;

public interface USB {
    //moze dziedziczyć dowolnie wiele interfejsów.
    //gdy klasa dziedziczy wiele interfejsów
    //a one mają metody o tych samych nazwach
//    public void xxx(){
//        A.super.xxx();
//        B.super.xxx();
//    }

    //nie może mieć konstruktora
    //nie może mieć final



    //nie ma żadnych pól, ma tylko nagłówni metod.
    //nie ma żadnych informacji jak należy te moedy implementować.
    //jest wyłącznie informacja co mamy zrobić.

    void send(byte[] bytes);
    String receive();
}
