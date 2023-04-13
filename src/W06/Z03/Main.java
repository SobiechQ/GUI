package W06.Z03;

import MODEL.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        class Student {
            private String grupa;
            private String imie;
            private int wynik;

            public Student(String imie, String grupa, int wynik) {
                this.grupa = grupa;
                this.imie = imie;
                this.wynik = wynik;
            }

            @Override
            public String toString() {
                return "Student{" +
                        "grupa='" + grupa + '\'' +
                        ", imie='" + imie + '\'' +
                        ", wynik=" + wynik +
                        '}';
            }

            public String getGrupa() {
                return grupa;
            }

            public String getImie() {
                return imie;
            }

            public int getWynik() {
                return wynik;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Student student = (Student) o;
                return getWynik() == student.getWynik() && Objects.equals(getGrupa(), student.getGrupa()) && Objects.equals(getImie(), student.getImie());
            }

            @Override
            public int hashCode() {
                return Objects.hash(getGrupa(), getImie(), getWynik());
            }
        }


        Stream<String> lineOfText = Main.wczytajZPliku();

        System.out.println("Zadanie A:");
        lineOfText
                .map(s-> new Student(s.split(" ")[0], s.split(" ")[1], Integer.parseInt(s.split(" ")[2])))
                .filter(student -> student.getWynik()>=50)
                .forEach(System.out::println);


        System.out.println("Zadanie B:");
        lineOfText = Main.wczytajZPliku();


        lineOfText
                .map(s-> new Student(s.split(" ")[0], s.split(" ")[1], Integer.parseInt(s.split(" ")[2])))
                .filter(student -> student.getWynik()>=50)
                .sorted((s1, s2) -> s1.getGrupa().compareTo(s2.getGrupa())!=0 ? s1.getGrupa().compareTo(s2.getGrupa()) : Integer.compare(s1.getWynik(), s2.getWynik()))
                .forEach(System.out::println);


        System.out.println("Zadanie C:");
        lineOfText = Main.wczytajZPliku();


        HashMap<String, ArrayList<Student>> hashMap = new HashMap<>();
        lineOfText
                .map(s-> new Student(s.split(" ")[0], s.split(" ")[1], Integer.parseInt(s.split(" ")[2])))
                .forEach(student -> {
                    hashMap.putIfAbsent(student.grupa, new ArrayList<>());
                    hashMap.get(student.grupa).add(student);
                });
        hashMap.entrySet().stream()
                .peek(stringArrayListEntry -> System.out.println(stringArrayListEntry.getKey()))
                .forEach(stringArrayListEntry -> System.out.println(stringArrayListEntry.getValue()));





    }
    private static Stream<String> wczytajZPliku(){
        Stream<String> lineOfText;
        try {
            lineOfText = Files.lines(Paths.get("src/W06/Z03/data.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lineOfText;
    }
}
