package W05.Z04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stream.generate(()->(int) (Math.random()*99))
                .limit(40)
                .forEach(arrayList::add);

        arrayList.stream()
                .dropWhile((Integer n)->n%2!=0)
                .map((Integer n)-> (int) Math.pow(n,2))
                .sorted((Integer n1, Integer n2) -> Integer.compare(n2, n1))
                .limit(5)
                .forEach(System.out::println);







    }
}
