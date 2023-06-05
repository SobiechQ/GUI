package W11.Z01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextFieldAndListApp extends JFrame {
    private JTextField textField;
    private JList<String> list;
    private DefaultListModel<String> listModel;

    public TextFieldAndListApp() {
        setTitle("TextField and List App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText().trim();
                if (!text.isEmpty() && !listModel.contains(text)) {
                    listModel.addElement(text);
                    sortListModel();
                    textField.setText("");
                }
            }
        });
        panel.add(textField, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
                    int index = list.locationToIndex(e.getPoint());
                    String selectedItem = listModel.getElementAt(index);
                    listModel.removeElement(selectedItem);
                }
            }
        });
        panel.add(new JScrollPane(list), BorderLayout.CENTER);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private void sortListModel() {
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < listModel.size(); i++) {
            tempList.add(listModel.getElementAt(i));
        }
        Collections.sort(tempList);
        listModel.clear();
        for (String item : tempList) {
            listModel.addElement(item);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TextFieldAndListApp app = new TextFieldAndListApp();
                app.setVisible(true);
            }
        });
    }
}
