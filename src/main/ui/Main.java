package ui;

import model.AccountList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// Main method that creates GUI and runs internal code
public class Main extends JFrame implements ActionListener {

    private static AccountList accountList;
    private static JsonWriter writer;
    private static JsonReader reader;
    private static final String JSON_STORE = "./data/AccountList.json";

    private JButton button;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label;

    public Main() {
        super("LeBank");
        accountList = new AccountList("List of Accounts");
        writer = new JsonWriter(JSON_STORE);
        reader = new JsonReader(JSON_STORE);
        initializeGraphics();
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public void initializeGraphics() {
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

    public void mainMenuButtons() {
        createLabel();
        createButton();
        createButton1();
        createButton2();
        createButton3();
    }

    public void createLabel() {
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(600, 130, 700, 130));
        setLayout(null);
        label = new JLabel("LeBank");
        label.setBounds(160,50,200,100);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD,50));
        add(label);
    }

    public void createButton() {
        button1 = new JButton("Admin");
        button1.setBounds(100,250,300,80);
        button1.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button1.setFocusable(false);
        button1.addActionListener(this);
        add(button1);
    }

    public void createButton1() {
        button = new JButton("Create Account");
        button.setBounds(100,150,300,80);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);
    }

    public void createButton2() {
        button2 = new JButton("Load Accounts");
        button2.setBounds(100,350,300,80);
        button2.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button2.setFocusable(false);
        button2.addActionListener(this);
        add(button2);
    }

    public void createButton3() {
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

    public static AccountList getAccountList() {
        return accountList;
    }

    // EFFECTS: saves the AccountList to file
    public static void saveAccountList() {
        try {
            writer.open();
            writer.write(accountList);
            writer.close();
            System.out.println("Saved " + accountList.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
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
            try {
                Bank.loadAccountList();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }

    }
}