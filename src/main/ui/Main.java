package ui;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main extends JFrame {

    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;

    public Main() {
        super("Bank of CPSC 210");
        initialGraphics();
        addNewBank();

    }

    public static void main(String[] args) throws IOException {
        new Main(); // creates a new Main GUI
    }

    private void initialGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        addNewBank();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addNewBank() {

    }
}
