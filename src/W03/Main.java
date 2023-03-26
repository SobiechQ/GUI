package W03;

public class Main {
    public static void main(String[] args) {
        //typy generyczne

        //dla typów T - type
        //dla kluczy K
        //N -Numery
        //e element
        //v value
        MyElement<Student> myElement = new MyElement<>(new Student("jan"));
        System.out.println(myElement.data);
        MyElement<Koza> myElement1 = new MyElement<>(new Koza());
        myElement1.data.kaloczynosc+=30;

    }
}
