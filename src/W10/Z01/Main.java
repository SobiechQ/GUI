package W10.Z01;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main extends JFrame {
    private static final Stack<JButton> myButtons = new Stack<>();

    static {
        String[] buttonNames = {"Przycisk 1", "P 2", "Większy przycisk numer 3", "Przycisk 4", "P5"};
        myButtons.addAll(Arrays.stream(buttonNames).map(JButton::new).toList());
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }

    Main() {
        this.setVisible(true);
        this.setSize(400, 400);
        char c = 'g';

        JPanel wybor = switch (c) {
            case 'a' -> new MyBorderLayout();
            case 'b' -> new MyFlowLayout();
            case 'c' -> new MyFlowLayoutLewy();
            case 'd' -> new MyFlowLayoutPrawy();
            case 'e' -> new MyGridJedenWiersz();
            case 'f' -> new MyGridJednaKolumna();
            case 'g' -> new MyGridTabela();
            default -> throw new IllegalArgumentException("Litera z zakresu [a-g]");
        };


        this.getContentPane().add(wybor);


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public class MyBorderLayout extends JPanel {
        MyBorderLayout() {
            this.setLayout(new BorderLayout());
            this.add(Main.myButtons.pop(), BorderLayout.PAGE_END);
            this.add(Main.myButtons.pop(), BorderLayout.LINE_END);
            this.add(Main.myButtons.pop(), BorderLayout.BEFORE_FIRST_LINE);
            this.add(Main.myButtons.pop(), BorderLayout.CENTER);
            this.add(Main.myButtons.pop(), BorderLayout.BEFORE_LINE_BEGINS);
        }
    }

    public class MyFlowLayout extends JPanel {
        MyFlowLayout() {
            this.setLayout(new FlowLayout());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
        }
    }

    public class MyFlowLayoutLewy extends JPanel {
        MyFlowLayoutLewy() {
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setAlignment(FlowLayout.LEFT);
            this.setLayout(flowLayout);
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
        }
    }

    public class MyFlowLayoutPrawy extends JPanel {
        MyFlowLayoutPrawy() {
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setAlignment(FlowLayout.RIGHT);
            this.setLayout(flowLayout);
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
        }
    }

    public class MyGridJedenWiersz extends JPanel {
        MyGridJedenWiersz() {
            GridLayout gridLayout = new GridLayout(1, 5);
            this.setLayout(gridLayout);
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
        }
    }

    public class MyGridJednaKolumna extends JPanel {
        MyGridJednaKolumna() {
            GridLayout gridLayout = new GridLayout(5, 1);
            this.setLayout(gridLayout);
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
        }
    }

    public class MyGridTabela extends JPanel {
        MyGridTabela() {
            GridLayout gridLayout = new GridLayout(3, 2);
            this.setLayout(gridLayout);
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
            this.add(Main.myButtons.pop());
        }
    }


}
