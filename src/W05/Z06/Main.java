package W05.Z06;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.of(5,10,15,20,25,30)
                .mapToInt(i -> i)
                .filter(i -> i<15)
                .flatMap(i->
                        Stream.generate(()->i)
                                .mapToInt(j->j)
                                .limit(i))
                .forEach(System.out::println);
        String[] input = {"Jeden", "Dwa", "Trzy", "Cztery"};
        Stream.of(input)
                .map(String::toUpperCase)
                .map(s->{
                    StringBuilder output = new StringBuilder();
                    for (int i = s.length()-1; i >= 0; i--)
                        output.append(s.charAt(i));
                    return output;
                })
                .forEach(System.out::println);





    }
}
