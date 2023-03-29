package W04.Ex02;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        Stream.iterate(1, el -> el+1)
                .limit(10)
                .dropWhile(e-> e<5)
                .forEach(System.out::println);
    }
}
