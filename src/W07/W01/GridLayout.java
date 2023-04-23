package W07.W01;

import javax.swing.*;

public class GridLayout extends JPanel {
    public static GridLayout gridLayout;
    public GridLayout(){
        this.setLayout(
                new java.awt.GridLayout(3,3)
        );

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton("B"+i);
            button.addActionListener(e -> {
                System.out.println("Hello"); // action listenetr do buttona
            });
            //Wszystkie odłsłuchujące elementy, warto jest zrobić w jednej kolekcji.
            //następnie można dać odzielny wątek który informuje wszystkei te elementy
            //poprzez przejscie przez ta kolekcje i wywolanie actionPerformed



            this.add(button);
        }


    }
}
