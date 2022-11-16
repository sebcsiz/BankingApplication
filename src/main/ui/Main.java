package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main extends JFrame implements ActionListener {

    private JButton button;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label;

    public Main() {
        super("The Bread Bank");
        initializeGraphics();
    }

    public static void main(String[] args) {
        new Main();
    }

    public void initializeGraphics() {
        initializeSwing();
    }

    public void initializeSwing() {
        setBackground("data/bronjam.jpg");
        try {
            setIconImage(ImageIO.read(new File("data/money.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainMenuButtons();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void mainMenuButtons() {
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(600, 130, 700, 130));
        setLayout(null);
        label = new JLabel("LeBank");
        label.setBounds(160,50,200,100);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD,50));
        add(label);

        button = new JButton("Create Account");
        button.setBounds(100,150,300,80);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);

        button1 = new JButton("Admin");
        button1.setBounds(100,250,300,80);
        button1.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button1.setFocusable(false);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Load Accounts");
        button2.setBounds(100,350,300,80);
        button2.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button2.setFocusable(false);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("Exit");
        button3.setBounds(100,450,300,80);
        button3.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button3.setFocusable(false);
        button3.addActionListener(this);
        add(button3);
    }

    public void setBackground(String fileName) {
        try {
            final Image backgroundImage = ImageIO.read(new File(fileName));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create Account")) {
            dispose();
            new CreateAccount();
        }
        if (e.getActionCommand().equals("Admin")) {
            dispose();
            new Admin();
        }
        if (e.getActionCommand().equals("Load Accounts")) {
            print(null);
        }
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }

    }
}