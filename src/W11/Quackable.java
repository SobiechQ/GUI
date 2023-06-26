package W11;

public interface Quackable {
    default String quack(){
        return "Quack! Quack!";
    }
}
