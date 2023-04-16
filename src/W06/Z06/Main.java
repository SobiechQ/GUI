package W06.Z06;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String file = "src/W06/Z06/slowa.txt";
        for (Map.Entry<String, Integer> e : new Slowa(file))
            System.out.println(e);



    }
}
