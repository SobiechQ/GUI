package W05.Z03;

import MODEL.Person;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        class StrToInt implements Transform<String, Integer>{
            @Override
            public Integer apply(String input) {
                return input.length();
            }
        }
        class Test {
            private static <T, R> void transform(T[] in, R[] out, Transform<T,R> transform) {
                for (int i = 0; i < in.length; i++) {
                    out[i] = transform.apply(in[i]);
                }
            }
        }


        Person[] people = new Person[10];
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person();

        }






        Integer[] outInt = new Integer[people.length];

        Test.transform(people, outInt, (Person p) -> p.getFirstName().length());


//        Test.transform(people, outInt, );









        System.out.println(Arrays.toString(outInt));


    }
}
