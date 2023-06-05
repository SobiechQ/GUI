package W10.W02;

import MODEL.Person;
import W10.W01.MyPanel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
    Main(){
        this.setVisible(true);
        this.setSize(400,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        AbstractTableModel defaultTableModel = new AbstractTableModel(){
            private Person[] people = {new Person(), new Person(), new Person(), new Person()};


            @Override
            public int getRowCount() {
                return people.length;
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int row, int column) {
                return switch (column){
                    case 0 -> this.people[row].getFirstName();
                    case 1 -> this.people[row].getSecondName();
                    default -> null;
                };
            }
        };
        JTable jTable = new JTable(defaultTableModel);

        this.getContentPane().add(jTable);




    }
}
