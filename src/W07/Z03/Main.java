package W07.Z03;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
    public static ArrayList<ChangeColorListener> changeColorListenerArrayList = new ArrayList<>();
    Main(){




        this.getContentPane().add(new Center(), BorderLayout.CENTER);
        JTextField jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(200, 20));
        JButton jButton = new JButton("Wyslij");
        jButton.addActionListener(e -> {
            System.out.println(jTextField.getText());
            for (ChangeColorListener changeColorListener : changeColorListenerArrayList) {
                changeColorListener.chageTo(jTextField.getText());
            }

            jTextField.setText("");
        });
        JPanel jPanelBottom = new JPanel();
        jPanelBottom.add(jTextField);
        jPanelBottom.add(jButton);
        this.getContentPane().add(jPanelBottom, BorderLayout.PAGE_END);




        this.setSize(620,480);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
