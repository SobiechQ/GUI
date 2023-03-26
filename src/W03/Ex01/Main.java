package W03.Ex01;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student((int) (Math.random()*100));
        }
        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        //sortowanie prez generic i metode sort.

        System.out.println(" ======================== ");
//        //inna implementacja:
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student((int) (Math.random()*100));
        }
        System.out.println(Arrays.toString(students));
//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.index-o2.index;
//            }
//        });
//        System.out.println(Arrays.toString(students));

        //skoro wymagal jednej metody to interfejs byl fukncyjny
        //wiec mozna uzyc lambdy
        Arrays.sort(students,
                (o1, o2) -> {
            return o1.index- o2.index;
        });
        System.out.println(Arrays.toString(students));
        System.out.println(Card.KING);





    }
}
