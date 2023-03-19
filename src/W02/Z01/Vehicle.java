package W02.Z01;

public interface Vehicle {
    //nie ma pól nie ma metod
    //nie można tobić jego obiektów
    //abstrakcyjna ma częsć z zwykłej klasy i część z interfejów,



    //************************8
    //gdy abstrakcyjna dziedziczy po interjesie
    //moze ale nie musi ona implementować moetod
    //wtedy zostają one do zaimplementowania przez następnego usera

    //*****************8
    void startEngine();
    void move();




    //może działać jak abstarkcyjna od java 8.

    default void test(){
        System.out.println("abc");
    }

    //jest uniwersalna dla wszystkich samocodów.
    default boolean isEngineOk(int km){
        return km>=10_000;
    }
}
