package W07.Z02.his.curr.ex03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public
    class MyColorPanel
    extends JPanel {

    private JButton changeColorButton;

    public MyColorPanel(Color color) {
        this.setBackground(color);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(
            new Dimension( 150, 150)
        );

        this.changeColorButton = new JButton("set new color");

        this.changeColorButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MyColorPanel.this.setBackground(
                        new Color(
                            (int)(Math.random()*255),
                            (int)(Math.random()*255),
                            (int)(Math.random()*255)
                        )
                    );

                }
            }
        );

        this.add(
            changeColorButton, BorderLayout.PAGE_END
        );
    }
}
