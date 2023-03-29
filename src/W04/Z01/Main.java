package W04.Z01;

public class Main {
    public static void main(String[] args) {
        /*
        ChangeType<Student, Dziekan> naDziekan = new ChangeType<>() {
            @Override
            public Dziekan changeType(Student student) {
                return new Dziekan(student.imie, student.eska);
            }
        };
         */
        ChangeType<Student, Dziekan> naDziekan = (Student student) -> (new Dziekan(student.imie, student.eska));


        Student sobek = new Student(2137, "Sobekmmmm");
        System.out.println(sobek);
        Dziekan dziekan = naDziekan.changeType(sobek);
        System.out.println(dziekan);


    }
}
