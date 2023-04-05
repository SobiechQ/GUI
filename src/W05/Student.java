package W05;

import java.util.Objects;

public class Student {
    private String imie;

    public Student(String imie) {
        this.imie = imie;
    }
    public void tegoNieMa(){
        System.out.println("Nie ma tego");
    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(imie, student.imie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie);
    }
}
