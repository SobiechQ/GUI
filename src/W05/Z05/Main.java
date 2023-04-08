package W05.Z05;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] arr = {
                "salon A", "Mercedes", "130000",
                "salon B", "Mercedes", "120000",
                "salon C", "Ford", "110000",
                "salon C", "Ford", "3000",
                "salon B", "Opel", "90000",
                "salon C", "Honda", "95000",
                "salon A", "Ford", "105000",
                "salon A", "Renault", "75000"
        };
        LinkedList<String> queue = new LinkedList<>();
        HashMap<String, LinkedList<Samochod>> hashMap = new HashMap<>();
        Arrays.stream(arr)
                .flatMap(s -> {
                    queue.add(s);
                    return queue.size()<=2 ? null:Stream.of(queue);
                })
                .map(stack -> new Samochod(queue.pop(), queue.pop(), queue.pop()))
                .forEach(samochod -> {
                    hashMap.computeIfAbsent(samochod.getSalon(), k -> new LinkedList<>());
                    hashMap.get(samochod.getSalon()).add(samochod);
                });

        for(String s: hashMap.keySet())
            System.out.println(s+"\n\t"+hashMap.get(s));
        System.out.println();


        Stream.of(hashMap)
                .flatMap(input -> {
                    LinkedList<LinkedList<Samochod>> output = new LinkedList<>();
                    for(String s: input.keySet())
                        output.add(input.get(s));
                    return output.stream();
                })
                .flatMap(input -> new LinkedList<>(input).stream())
                .min(Comparator.comparingInt(s -> Integer.parseInt(s.getCena())))
                .ifPresent(System.out::println);
    }
}
