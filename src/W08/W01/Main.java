package W08.W01;

import MODEL.Person;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
    Main(){

        this.getContentPane().add(new StudentJPanel());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640,480);
        this.setVisible(true);

        this.getContentPane().add(new Bottom(), BorderLayout.PAGE_END);

        foo(new Person(), new Person(), new Person());
    }
    public void foo(Person... i){
        for (Person person : i) {
            System.out.println("multi "+person);
        }
        System.out.println(i.getClass());
    }
    public void foo(Person i1, Person i2){
        System.out.println(i1);
        System.out.println(i2);

    }
}
