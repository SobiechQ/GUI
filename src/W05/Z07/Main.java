package W05.Z07;

import MODEL.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,4,1};
        final int[] iter = {0};
        Stream.of(arr)
                .flatMapToInt(Arrays::stream)
                .flatMap(k->IntStream
                        .generate(()->arr[iter[0]]));
        int[][] arr2 = {
                {1,1,1,1},
                {2,2,2},
                {3,3}
        };
        ArrayList<Person> al = new ArrayList<>();
        Stream.generate(()->new Person(1,"a","a","a"))
                .limit(10)
                .mapToInt(Person::getAge);

        //optional int vs int






    }
}
