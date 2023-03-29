package W04.Z01;

public class Student {
    public int eska;
    public String imie;
    public int ocenaZMadow = 2;
    public boolean piwo = true;

    public Student(int eska, String imie) {
        this.eska = eska;
        this.imie = imie;
    }

    @Override
    public String toString() {
        return "Student{" +
                "eska=" + eska +
                ", imie='" + imie + '\'' +
                ", ocenaZMadow=" + ocenaZMadow +
                ", piwo=" + piwo +
                '}';
    }
}
