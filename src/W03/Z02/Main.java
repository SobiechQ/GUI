package W03.Z02;
/*

ZADANIE 8 (3p)

Zdefiniować interfejs funkcyjny, generyczny Transform<T, R> z jedną metodą apply pobierającą
jako argument wartość typu T i zwracającą jako wynik wartość typu R.

Zdefiniować klasę StrToInt implementującą interfejs Transform dla typów T = String,
 R = Integer. Implementacja metody apply polega
  na zwracaniu długości tekstu, podanego jako argument.

W klasie testującej
zdefiniować metodę statyczną:

    private static <T, R>
    void transform(T[] in, R[] out, Transform<T, R> trans) {

            // ...
    }

która pobiera dwie tablice
tej samej długości in typu T[], out typu R[] oraz obiekt
 trans typu Transform. Działanie metody polega na uzupełnieniu
 tablicy out wartościami będącymi wynikami metody apply wywołanej
  ze wszystkimi elementami tablicy in jako argument.

W klasie testującej utworzyć dwie tablice tej samej długości,
wywołać metodę transform przymującą jako argumenty te tablice
oraz obiekt trans na trzy sposoby:

* trans jest obiektem typu StrToInt,

* trans jest wyrażeniem lambda, w którym
metoda apply pobiera argument typu String i zwraca
jego pierwszy znak jako wynik (typu Character),

* trans jest wyrażeniem lambda, w którym metoda
apply pobiera tekst (typu String) i zwraca jako wynik
ten sam tekst, który składa się z samych wielkich liter.

Poniższy program:

import java.util.*;

@FunctionalInterface
interface Transform<T, R> {
    R apply(T arg);
}


// tu dopisać klasę StrToInt



public class Test {

    private static <T, R>
    void transform(T[] in, R[] out, Transform<T, R> trans) {

        // ...
    }

    public static void main(String[] args) {

        String[] sin = {"Alice", "Sue", "Janet", "Bea"};
        System.out.println(Arrays.toString(sin) + '\n');

        Integer[] iout = new Integer[sin.length];
        transform(sin, iout, );
        System.out.println(Arrays.toString(iout));

        Character[] cout = new Character[sin.length];
        transform(sin, cout, );
        System.out.println(Arrays.toString(cout));

        String[] sout = new String[sin.length];
        transform(sin, sout, );
        System.out.println(Arrays.toString(sout));

        }

        }

        powinien wyprowadzić następujące wyniki:

        [Alice, Sue, Janet, Bea]

        [5, 3, 5, 3]
        [A, S, J, B]
        [ALICE, SUE, JANET, BEA]




 */


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Transform<String, Integer> StrToInt = (s) -> s.length();


        class Test{
            private static <T,R> void transform(T[] in, R[] out, Transform<T,R> transform){
                if(in.length!= out.length)
                    throw new IllegalArgumentException("Arrays have to have same length");
                for (int i = 0; i < in.length; i++) {

                }
            }
        }


        /*

W klasie testującej
zdefiniować metodę statyczną:

    private static <T, R>
    void transform(T[] in, R[] out, Transform<T, R> trans) {

            // ...
    }

która pobiera dwie tablice
tej samej długości in typu T[], out typu R[] oraz obiekt
 trans typu Transform. Działanie metody polega na uzupełnieniu
 tablicy out wartościami będącymi wynikami metody apply wywołanej
  ze wszystkimi elementami tablicy in jako argument.

         */
    }


}
