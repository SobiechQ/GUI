package W03.Ex01;

public class Student implements Comparable<Student>{
    public int index;

    public Student(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return " "+index;
    }

    @Override
    public int compareTo(Student o) {
        return this.index - o.index;
    }
}
