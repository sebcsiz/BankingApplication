package ui;

import model.AccountList;
import model.BankAccount;
import model.Event;
import model.EventLog;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.actions.IDK;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// Main method that creates GUI and runs internal code
public class Main extends JFrame implements ActionListener {
 /** Swing Frame resolution is 1536 x 864 **/

    private static AccountList accountList;
    private static JsonWriter writer;
    private static JsonReader reader;
    private static final String JSON_STORE = "./data/AccountList.json";
    private Icon img;
    private static Clip clip;

    private JButton button;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label;

    // MODIFIES: accountList, writer, reader
    // EFFECTS: renames window and calls initializegraphics()
    public Main() {
        super("LeBank");
        accountList = new AccountList();
        writer = new JsonWriter(JSON_STORE);
        reader = new JsonReader(JSON_STORE);
        initializeGraphics();
    }

    // EFFECTS: create new GUI
    public static void main(String[] args) {
        new Main();
    }

    // EFFECTS: sets window background and changes icon. Calls mainMenuButtons()
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

    // EFFECTS: Calls all create menu buttons
    public void mainMenuButtons() {
        createLabel();
        createButton();
        createButton1();
        createButton2();
        createButton3();
        createButton4();
    }

    // EFFECTS: creates label
    public void createLabel() {
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(600, 130, 700, 130));
        setLayout(null);
        label = new JLabel("LeBank");
        label.setBounds(160,50,200,100);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD,50));
        add(label);
    }

    // EFFECTS: creates admin button
    public void createButton() {
        button1 = new JButton("Admin");
        button1.setBounds(100,250,300,80);
        button1.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button1.setFocusable(false);
        button1.addActionListener(this);
        add(button1);
    }

    // EFFECTS: creates 'create account' button
    public void createButton1() {
        button = new JButton("Create Account");
        button.setBounds(100,150,300,80);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);
    }

    // EFFECTS: creates load account button
    public void createButton2() {
        button2 = new JButton("Load Accounts");
        button2.setBounds(100,350,300,80);
        button2.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button2.setFocusable(false);
        button2.addActionListener(this);
        add(button2);
    }

    // EFFECTS: creates exit button
    public void createButton3() {
        button3 = new JButton("Exit");
        button3.setBounds(100,450,300,80);
        button3.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button3.setFocusable(false);
        button3.addActionListener(this);
        add(button3);
    }

    // EFFECTS: creates exit button
    public void createButton4() {
        img = new ImageIcon("data/p.jpg");
        button4 = new JButton(img);
        button4.setText(" ");
        button4.setBounds(100,550,300,200);
        button4.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button4.setFocusable(false);
        button4.addActionListener(this);
        add(button4);
    }

    // REQUIRES: fileName
    // MODIFIES: JFrame
    // EFFECTS: changes frame background to the file given by the user
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

    // EFFECTS: plays given file
    public void playSound(String fileName) {
        // Method from: https://stackoverflow.com/questions/6045384/playing-mp3-and-wav-in-java
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File(fileName).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public static AccountList getAccountList() {
        return accountList;
    }

    // EFFECTS: stops sound that is playing
    public static void stopSound() {
        clip.stop();
    }

    // MODIFIES: this
    // EFFECTS: loads AccountList from file
    public static void loadAccountList() throws IOException {
        try {
            accountList = reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createAccountListener() {
        dispose();
        try {
            new CreateAccount(accountList);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void loadAccountListener() {
        try {
            loadAccountList();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    // REQUIRES: e
    // EFFECTS: opens new window based on which button the user clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create Account")) {
            dispose();
            createAccountListener();
        }
        if (e.getActionCommand().equals("Admin")) {
            dispose();
            new Admin();
        }
        if (e.getActionCommand().equals("Load Accounts")) {
            loadAccountListener();
            BankAccount.logEvent("Loaded accounts");
        }
        if (e.getActionCommand().equals("Exit")) {
            for (Event event : EventLog.getInstance()) {
                System.out.println(event.toString());
            }
            System.exit(0);
        }

        if (e.getActionCommand().equals(" ")) {
            new IDK();
            playSound("data/griddle.wav");
        }
    }
}