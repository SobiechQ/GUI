package W11.Z02.Simul;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Hand hand = new Hand(
                new Deck().getCards().stream()
                        .limit(5)
                        .collect(Collectors.toList()));
        hand.forEach(System.out::println);

    }
}
