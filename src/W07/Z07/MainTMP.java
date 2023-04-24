package W07.Z07;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainTMP {
    public static void main(String[] args) {
        byte[] bytes = {10,30, 50,-30};
        int[] ints = {10,20,30};
        IntStream.range(0,bytes.length).map(i->bytes[i]).forEach(System.out::println);
    }
}
