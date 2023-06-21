package W11.Z02.Simul;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CardColor {
    HEARTS(1), DIAMONDS(2), SPADES(4), CLUBS(8);
    private final int id;
}
