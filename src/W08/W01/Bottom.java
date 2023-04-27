package W08.W01;

import javax.swing.*;

public class Bottom extends JPanel {
    Bottom(){
        JButton jButton = new JButton("Zmiana!");
        jButton.addActionListener((s)->new Thread(StudentJPanel::fireUpdate).start());
        this.add(jButton);
    }
}
