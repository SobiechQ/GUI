package W11.Z02.Simul;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
@Getter
@EqualsAndHashCode
public class Hand implements Iterable<Card>{
    private final List<Card> cards;

    public Hand(){
        this.cards = new LinkedList<>();
    }
    public Hand(@NonNull List<Card> cards) {
        this.cards = cards;
    }

    public void add(@NonNull Card card){
        this.cards.add(card);
    }

    @NotNull
    @Override
    public Iterator<Card> iterator() {
        return this.cards.iterator();
    }
}
