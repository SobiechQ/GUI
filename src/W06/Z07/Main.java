package W06.Z07;

import MODEL.Person;

import java.util.List;
import java.util.Stack;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.generate(Person::new)
                .limit(10)
                .flatMap(p->{
                    Stack<String> stringStack = new Stack<>();
                    stringStack.add(p.getFirstName()+" ");
                    stringStack.add(p.getSecondName());
                    stringStack.add("\n");

                    return stringStack.stream();
                })
                .forEach(System.out::print);

        Stream<String> mikolajDebil = "nfjriorkok".lines();
        mikolajDebil
                .forEach(System.out::print);

        Stream.generate(()->"Kiryl powinien wiecej sie uczyc gui").limit(100).forEach(System.out::println);


    }
}
