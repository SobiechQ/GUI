package W09.Z02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyColor extends JPanel {
    MyColor(){
        this.setSize(300,300);
        this.setVisible(true);
        BorderLayout borderLayout = new BorderLayout();
        JColorChooser jColorChooser = new JColorChooser();



        this.setLayout(borderLayout);
        this.add(jColorChooser, BorderLayout.CENTER);
        this.add(new JButton("Potwierdź"){
            @Override
            protected void fireActionPerformed(ActionEvent event) {
                Main.main.colorRecived(jColorChooser.getColor());
            }
        }, BorderLayout.PAGE_END);
    }

}
