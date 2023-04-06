package W05.Z01;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] arr = {
                "salon A", "Mercedes", "130000",
                "salon B", "Mercedes", "120000",
                "salon C", "Ford", "110000",
                "salon B", "Opel", "90000",
                "salon A", "Dodge", "3000",
                "salon C", "Honda", "95000",
                "salon A", "Ford", "105000",
                "salon A", "Renault", "75000",
        };
        final String[] buffor = {null, null};
        HashMap<String, ArrayList<Samochod>> stringListHashMap = new HashMap<>();
        Stream.of(arr).forEach((String s) -> {
            for (int i = 0; i < buffor.length; i++) {
                if (buffor[i] == null) {
                    buffor[i] = s;
                    return;
                }
            }
            stringListHashMap.computeIfAbsent(buffor[0], k -> new ArrayList<>());
            stringListHashMap.get(buffor[0]).add(new Samochod(buffor[0], buffor[1], s));
            Arrays.fill(buffor, null);
            });
        Stream.of(stringListHashMap).forEach(System.out::println);

    }
}
