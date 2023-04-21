package W07.Z02.his.curr;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
                    Color color = new Color(
                        (int)(Math.random()*255),
                        (int)(Math.random()*255),
                        (int)(Math.random()*255)
                    );
                    MyColorPanel.this.setBackground(color);
                    fireColorChanged(
                        new ColorEvent( MyColorPanel.this, color)
                    );
                }
            }
        );

        this.add(
            changeColorButton, BorderLayout.PAGE_END
        );

        this.listeners = new ArrayList<>();
    }

    private List<ColorListener> listeners;

    public void addColorListener(ColorListener colorListener){
        this.listeners.add(colorListener);
    }

    public void removeColorListener(ColorListener colorListener){
        this.listeners.remove(colorListener);
    }

    private void fireColorChanged(ColorEvent evt){
        for(ColorListener colorListener : listeners)
            colorListener.colorChanged(evt);
    }

}
