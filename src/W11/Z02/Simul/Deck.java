package W11.Z02.Simul;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@EqualsAndHashCode
public class Deck {
    private final List<Card> cards;

    Deck() {
        this.cards = Arrays.stream(CardColor.values())
                .flatMap((Function<CardColor, Stream<Map<CardColor, CardValue>>>) cardColor ->
                        Arrays.stream(CardValue.values())
                                .map(cardValue -> {
                                    Map<CardColor, CardValue> pairColorValue = new HashMap<>();
                                    pairColorValue.put(cardColor, cardValue);
                                    return pairColorValue;
                                }))
                .map(cardColorCardValueMap -> {
                    CardColor cardColor = cardColorCardValueMap.keySet().iterator().next();
                    return new Card(cardColor, cardColorCardValueMap.get(cardColor));
                }).collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(this.cards);
    }

}
