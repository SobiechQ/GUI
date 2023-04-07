package W05.Z03;

import MODEL.Person;

public class Student extends Person {
    private int eska;

    public Student() {
        this.eska = (int) (Math.random()*9999);
    }

    public Student(int age, String firstName, String secondName, String favMusic, int eska) {
        super(age, firstName, secondName, favMusic);
        this.eska = eska;
    }

    public int getEska() {
        return eska;
    }
}
