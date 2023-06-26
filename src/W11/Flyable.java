package W11;

public interface Flyable {
    default String fly(){
        return "I am flying!";
    }
}
