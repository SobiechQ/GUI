package W05;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Strumienie to Monad, programowanie funkcyjne
        //strumień nie przechowuje, nie modyfikuje źródła
        //strumień jest leniwy


        //do tworzenia można użyć .of()

        //można je zawęźić .filter
        Stream<String> stringStream =  Stream.of(
        "A", "B", "C", "D", "E", "AA", "ABC", "DD", "G", "00"
        );
//        stringStream
//                .filter(s->s.length()==1)
//                .map(String::toLowerCase)
//                .forEach(System.out::println);


        List<String> ls = Arrays.asList("A1", "B311", "C44", "D100", "E01", "A2", "a3", "a1", "a1", "a0");
//        ls.stream()
//                .map(s->s.substring(1))
//                .mapToInt(Integer::parseInt)
//                .forEach(System.out::println);

        //Interfejs Collector




        List<Integer> resList = Stream
                .generate(Math::random)
                .limit(10)
                .map(v->(int)(v*99))
                .collect(Collectors.toList());

        resList.stream().forEach(System.out::println);





    }
}
