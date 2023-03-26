package W03.Ex01;

public enum Card {
    TWO(2), KING(11), ACE(12);

    private int value;
    Card(int value){ //konskruktor jest domyslnie prywatny!
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
