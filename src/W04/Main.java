package W04;

import W04.model.Student;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        //struktury danych
        Student student1 = new Student("Debil1");
        Student student2 = new Student("Debil2");
        Student student3 = new Student("Debil3");
        MyArrayStack <Student> mas = new MyArrayStack<>();
        mas.push(student1);
        mas.push(student2);
        mas.push(student3);
        for(Student s: mas){
            //własne foreach po własnej stuktorze danych.
            System.out.println(s);
        }
        System.out.println(mas.pop());
        //aby trzymac elementy w własniej strukturze
        //dobrą praktyką jest zaimplementować comparator lub comparable, hashcode, equals, bezagrumentowy konstruktor, hashcode, iterable, serializable

        //istnieje opcja automatycznego tworzenia equals
        //strumien nie przechowuj eelementów na których działa
        //operacje strumieniowe nie modyfikują swojego źródł



    }
}
