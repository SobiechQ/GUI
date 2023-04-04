package W04.Z08;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<Person> personHashSet = new HashSet<>();
        for (int i = 0; i < 20; i++)
            personHashSet.add(new Person());
        TreeSet<Person> personTreeSet = new TreeSet<>(personHashSet);
        System.out.println(personTreeSet);

    }
}
