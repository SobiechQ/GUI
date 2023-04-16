package W06.Z06;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Slowa implements Iterable<Map.Entry<String, Integer>>{
    String path;
    HashMap<String, Integer> stringIntegerHashMap;

    public Slowa(String path) {
        this.path = path;
        stringIntegerHashMap = wczytajZPliku()
                .collect(HashMap::new,
                        (hashMap, string) -> {
                            hashMap.putIfAbsent(string, 0);
                            hashMap.computeIfPresent(string, (s1, i1) -> i1+1);
                        },
                        (hm1, hm2)->{}
                );
    }


    public Stream<String> wczytajZPliku(){
        Stream<String> wordsFromFile;
        try {
            //clear input of unnesseary data
            wordsFromFile = Files.lines(Paths.get(this.path))
                    .map(String::toLowerCase)
                    //usuwanie niepotrzebych znaków
                    .map(s -> s.replaceAll("[&;,\\-\\]\\[[0-9]]", " "))
                    //wiele spacji do jednej spacji
                    .map(s -> s.trim().replaceAll(" +", " "))
                    //split lini na stream stringów
                    .flatMap(s-> Arrays.stream(s.split(" ")))
            ;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordsFromFile;
    }
    @Override
    public Iterator<Map.Entry<String, Integer>> iterator() {
        Stack<String> stackOfKeys = this.stringIntegerHashMap.keySet().stream()
                .collect(Stack::new,
                    (stack, string)->stack.add(string),
                    (stack1, stack2)->{}
                );
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !stackOfKeys.isEmpty();
            }

            @Override
            public Map.Entry<String, Integer> next() {
                String tmpString = stackOfKeys.pop();
                return Map.entry(tmpString, stringIntegerHashMap.get(tmpString));
            }
        };


    }
}
