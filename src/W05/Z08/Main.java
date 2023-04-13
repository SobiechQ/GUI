package W05.Z08;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.iterate(0, i->i+1)
                .filter(i-> {
                    IntStream.rangeClosed(2, i/2)
                            .forEach(j-> System.out.println(i+" "+j));
                    return true;
                })
                .limit(20)
                .forEach(i-> System.out.println(i+"\n"));
    }
}
