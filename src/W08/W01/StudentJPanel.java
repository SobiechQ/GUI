package W08.W01;

import MODEL.Person;
import W03.Ex01.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

public class StudentJPanel extends JPanel implements UpdateListener {
    private static List<UpdateListener> updatables = new ArrayList<>();
    StudentJPanel(){
        StudentJPanel.updatables.add(this::update);

        Person person = new Person();
        JTextField imie = new JTextField(person.getFirstName());
        imie.setPreferredSize(new Dimension(150,30));
        JTextField wiek = new JTextField(String.valueOf(person.getAge()));
        wiek.setPreferredSize(new Dimension(150,30));



        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);
        GridBagConstraints c = new GridBagConstraints();

        this.add(new JLabel("Imie: "));
        c.gridwidth = GridBagConstraints.REMAINDER; //wymusza koniec lini;
        gridBagLayout.setConstraints(imie,c);
        this.add(imie);


        this.add(new JLabel("Wiek:"));
        c.gridwidth = GridBagConstraints.REMAINDER; //wymusza koniec lini;
        gridBagLayout.setConstraints(wiek,c);
        this.add(wiek);
        JComboBox<Person> jComboBox = new JComboBox<>(new Person[4]);
        this.add(jComboBox);



        this.add(new JLabel("Nowa linia! "));


//        this.getContentPane().add(imie);
//        this.getContentPane().add(wiek);
        //jeden zastępuje drugi bo to ten sam concent pane
        //dlatego:


    }
    public static void fireUpdate(){
        for (UpdateListener updatable : StudentJPanel.updatables) {
            updatable.update();
        }
    }

    @Override
    public void update() {
        System.out.println("teraz monz arobic rzeczy");
    }

}
