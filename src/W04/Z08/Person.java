package W04.Z08;

import java.util.Comparator;

public class Person implements Comparable<Person>{
    private static final String[] firstNames = {"Kaja", "Lena", "Antoni", "Hanna", "Jakub", "Julia", "Aleksander", "Zofia", "Michał", "Amelia", "Filip", "Maja", "Stanisław", "Natalia", "Adam", "Oliwia", "Franciszek", "Marcelina", "Mateusz", "Laura", "Wiktor", "Kinga", "Iga", "Nikodem", "Weronika", "Ignacy", "Nina", "Adrian", "Emilia", "Krzysztof", "Alicja"};
    private static final String[] secondNames = {"Nowak", "Kowalski", "Wiśniewski", "Dąbrowski", "Lewandowski", "Wójcik", "Kamiński", "Kowalczyk", "Zieliński", "Szymański", "Woźniak", "Kozłowski", "Jankowski", "Mazur", "Wojciechowski", "Kwiatkowski", "Kaczmarek", "Krawczyk", "Piotrowski", "Grabowski", "Nowakowski", "Pawłowski", "Michalski", "Nowicki", "Adamczyk", "Dudek", "Zając", "Wieczorek", "Jabłoński", "Krupa", "Sikora", "Olszewski"};
    private static final String[] favMusics = {"Rock", "Pop", "R&B", "Hip-Hop", "Classical", "Jazz", "Reggae"};

    @Override
    public int compareTo(Person o) {
        return  this.getFavMusic().length() - o.getFavMusic().length() != 0 ?
                this.getFavMusic().length() - o.getFavMusic().length():
                this.getAge() - o.getAge();
    }

    private final int age;
    private final String firstName;
    private final String secondName;
    private final String favMusic;

    public Person() {
        this.age = (int) (Math.random()*80);
        this.firstName = firstNames[(int) (Math.random()* firstNames.length)];
        this.secondName = secondNames[(int) (Math.random()* secondNames.length)];
        this.favMusic = favMusics[(int) (Math.random()* favMusics.length)];
    }

    public Person(int age, String firstName, String secondName, String favMusic) {
        this.age = age;
        this.firstName = firstName;
        this.secondName = secondName;
        this.favMusic = favMusic;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", favMusic='" + favMusic + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFavMusic() {
        return favMusic;
    }
}
