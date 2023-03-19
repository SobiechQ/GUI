package W02;

public class Main {
    //interfejsy i lambda

    public static void main(String[] args) {
        Computer computer = new Computer();
        //nie ma sensu robić metody dla każdej jednej klasy
        computer.connect(new Mouse());
    }
}
