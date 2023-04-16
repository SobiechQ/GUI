package W05.Z09;

import MODEL.Person;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(Stream.generate(Person::new)
                .limit(20)
                .collect(() -> new ArrayList<Person>(),
                        ArrayList::add,
                        (al1, al2)->{
                    al2.add(new Person(1, "abc", "abc", "abc"));
                        })
        );
        System.out.println(Stream.generate(Person::new)
                .limit(20)
                .collect(() -> new ArrayList<Person>(),
                        ArrayList::add,
                        (people, people2) -> people2.add(new Person(1, "abc", "abc", "abc"))
                )
        );
    }
}
