package W11;


class DuckFlyAndQuack implements Flyable, Quackable {
    String name;
    public DuckFlyAndQuack(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "My name is: " + this.name + '\n';
    }
    public String commitTaxFraud(){
        return "i am doing illegal things";
    }
}

public class DuckBehaviour {
    public static void main(String[] args) {

        var duck = new DuckFlyAndQuack("Duckie");
        foo(duck);

    }

    public static <T extends Flyable & Quackable> void foo(T object){
        System.out.println(object.toString());
        System.out.println(object.fly());
        System.out.println(object.quack());
        if (object instanceof DuckFlyAndQuack)
            ((DuckFlyAndQuack) object).commitTaxFraud();
    }
}
