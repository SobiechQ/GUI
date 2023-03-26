package W03;

public class Student {
    private String imie;

    public Student(String imie) {
        this.imie = imie;
    }

    @Override
    public String toString() {
        return this.imie;
    }
}
