package W05.Z02;

import MODEL.Person;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> arrayList = new ArrayList<>();
        Stream.generate(()->arrayList.add(new Person())).limit(10);
        System.out.println(arrayList);
    }
}
