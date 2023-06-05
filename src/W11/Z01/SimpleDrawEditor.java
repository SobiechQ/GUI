package W11.Z01;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;

public class SimpleDrawEditor {
    private JFrame frame;
    private JPanel drawingArea;
    private JLabel statusLabel;
    private String currentFileName;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SimpleDrawEditor window = new SimpleDrawEditor();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SimpleDrawEditor() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Simple Draw");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.setMnemonic(KeyEvent.VK_O);
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        openMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
        fileMenu.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setMnemonic(KeyEvent.VK_S);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
        fileMenu.add(saveMenuItem);

        JMenuItem saveAsMenuItem = new JMenuItem("Save As...");
        saveAsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        saveAsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveFileAs();
            }
        });
        fileMenu.add(saveAsMenuItem);

        JMenuItem quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.setMnemonic(KeyEvent.VK_Q);
        quitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        quitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quit();
            }
        });
        fileMenu.add(quitMenuItem);

        JMenu drawMenu = new JMenu("Draw");
        menuBar.add(drawMenu);

        JMenu figureMenu = new JMenu("Figure");
        drawMenu.add(figureMenu);

        JMenuItem circleMenuItem = new JMenuItem("Circle");
        circleMenuItem.setMnemonic(KeyEvent.VK_C);
        circleMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        circleMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDrawingMode("Circle");
            }
        });
        figureMenu.add(circleMenuItem);

        JMenuItem squareMenuItem = new JMenuItem("Square");
        squareMenuItem.setMnemonic(KeyEvent.VK_S);
        squareMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        squareMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDrawingMode("Square");
            }
        });
        figureMenu.add(squareMenuItem);

        JMenuItem penMenuItem = new JMenuItem("Pen");
        penMenuItem.setMnemonic(KeyEvent.VK_P);
        penMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        penMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDrawingMode("Pen");
            }
        });
        figureMenu.add(penMenuItem);

        JMenuItem colorMenuItem = new JMenuItem("Color");
        colorMenuItem.setMnemonic(KeyEvent.VK_C);
        colorMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choosePenColor();
            }
        });
        drawMenu.add(colorMenuItem);

        JMenuItem clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.setMnemonic(KeyEvent.VK_C);
        clearMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearDrawingArea();
            }
        });
        drawMenu.add(clearMenuItem);

        JToolBar toolBar = new JToolBar();
        frame.add(toolBar, BorderLayout.PAGE_START);

        JButton circleButton = new JButton("Circle");
        circleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDrawingMode("Circle");
            }
        });
        toolBar.add(circleButton);

        JButton squareButton = new JButton("Square");
        squareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDrawingMode("Square");
            }
        });
        toolBar.add(squareButton);

        JButton penButton = new JButton("Pen");
        penButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setDrawingMode("Pen");
            }
        });
        toolBar.add(penButton);

        drawingArea = new JPanel();
        drawingArea.setBackground(Color.WHITE);
        drawingArea.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.isShiftDown()) {
                    deleteFigure(e.getX(), e.getY());
                }
            }
        });
        frame.add(drawingArea, BorderLayout.CENTER);

        statusLabel = new JLabel("New");
        frame.add(statusLabel, BorderLayout.PAGE_END);
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Logic to open the file goes here
            String fileName = fileChooser.getSelectedFile().getName();
            currentFileName = fileName;
            frame.setTitle(fileName);
            statusLabel.setText("Open: " + fileName);
        }
    }

    private void saveFile() {
        if (currentFileName != null) {
            // Logic to save the file goes here
            statusLabel.setText("Saved: " + currentFileName);
        } else {
            saveFileAs();
        }
    }

    private void saveFileAs() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Logic to save the file goes here
            String fileName = fileChooser.getSelectedFile().getName();
            currentFileName = fileName;
            frame.setTitle(fileName);
            statusLabel.setText("Saved As: " + fileName);
        }
    }

    private void quit() {
        // Logic to check if the current content needs to be saved before quitting goes here
        System.exit(0);
    }

    private void setDrawingMode(String mode) {
        statusLabel.setText("Drawing mode: " + mode);
    }

    private void choosePenColor() {
        Color color = JColorChooser.showDialog(frame, "Choose Pen Color", Color.BLACK);
        if (color != null) {
            // Logic to set the pen color goes here
        }
    }

    private void clearDrawingArea() {
        // Logic to clear the drawing area goes here
        drawingArea.repaint();
    }

    private void deleteFigure(int x, int y) {
        // Logic to delete the figure at the specified coordinates goes here
    }
}
