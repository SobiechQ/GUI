package W07.Z02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Stack;

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                Main::new
        );
    }
    public static ArrayList<MyClickListener> myClickListeners = new ArrayList<>();
    Main(){
        //Blocks:
        class MyColorBlock extends JPanel implements MyClickListener{
            MyColorBlock(){
                Main.myClickListeners.add(this);
                this.setBackground(Color.PINK);
                this.setLayout(new BorderLayout());
                this.setPreferredSize(new Dimension( 150, 150));

            }

            @Override
            public void myOnClick(EventString eventString) {
                if( eventString.getMessage().equals("Random"))
                    this.setBackground(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));

                if (eventString.getMessage().equals("Reset"))
                    this.setBackground(Color.BLACK);

                System.out.println(eventString.getMessage());
            }
        }
        JPanel centerPanel = new JPanel();
        centerPanel.add(new MyColorBlock());
        centerPanel.add(new MyColorBlock());
        this.getContentPane().add(centerPanel, BorderLayout.CENTER);


        //Buttons:
        class MyButton extends JButton{


            MyButton(String s){
                this.setBackground(Color.CYAN);
                this.setText(s);
                this.addActionListener(e -> {
                    System.out.println(e);
                    this.fireMyClickAction(new EventString(e, this.getText()));
                });

            }
            private void fireMyClickAction(EventString e){
                for (MyClickListener myClickListener : myClickListeners)
                    myClickListener.myOnClick(e);
            }


        }

        Stack<JButton> buttons = new Stack<>();
        buttons.add(new MyButton("Reset"));
        buttons.add(new MyButton("Random"));
        JPanel buttonPanel = new JPanel();
        for (JButton button : buttons)
            buttonPanel.add(button);
        this.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);




        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(640,480);
        this.setVisible(true);
    }
}
