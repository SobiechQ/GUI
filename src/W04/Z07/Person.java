
public class Person {
    private String name;
    private int wiek;

    public Person(String name, int wiek) {
        this.name = name;
        this.wiek = wiek;
    }
    public void foo(){
        System.out.println(this.wiek + " Do kwadratu to: "+ Math.pow(this.wiek, 2));
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}