
public class Main {
    public static void main(String[] args) {
        MyStack<Person> msP = new MyStack<>();
        msP.push(new Person("Jan", 23));
        msP.push(new Person("Kamil", 107));
        msP.push(new Person("Pawel", -98));
        for (Element e : msP) {

        }
    }
}
