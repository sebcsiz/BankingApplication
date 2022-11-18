package ui;

import model.AccountList;
import model.BankAccount;
import persistence.JsonReader;
import ui.actions.PrintAccounts;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Lets Admin view a list all accounts or Clears JSON files
public class InAdmin extends JFrame implements ActionListener {

    private BankAccount[] info = new BankAccount[10];
    private AccountList accountList = Main.getAccountList();
    private static JsonReader jsonReader;
    private static final String JSON_STORE = "./data/AccountList.json";

    private JButton button;
    private JButton button1;
    private JButton button2;

    // MODIFIES: jsonReader
    // EFFECTS: creates window and calls actions()
    public InAdmin() {
        jsonReader = new JsonReader(JSON_STORE);
        try {
            setIconImage(ImageIO.read(new File("data/money.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        actions();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    // EFFECTS: calls create button methods and adds picture to frame
    public void actions() {
        createButton();
        createButton1();
        createButton2();

        try {
            BufferedImage picture = ImageIO.read(new File("data/bigbodycle.jpg"));
            JLabel label = new JLabel(new ImageIcon(picture));
            label.setBounds(400, 50, 800, 400);
            add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // EFFECTS: creates list accounts button
    public void createButton() {
        button = new JButton("List Accounts");
        button.setBounds(600,450,400,75);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);
    }

    // EFFECTS: creates clear json button
    public void createButton1() {
        button1 = new JButton("Clear JSON");
        button1.setBounds(600,550,400,75);
        button1.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button1.setFocusable(false);
        button1.addActionListener(this);
        add(button1);
    }

    // EFFECTS: creates back to menu button
    public void createButton2() {
        button2 = new JButton("Back to Menu");
        button2.setBounds(600,650,400,75);
        button2.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button2.setFocusable(false);
        button2.addActionListener(this);
        add(button2);
    }

    // REQUIRES: e
    // EFFECTS either prints accounts, clears menu, or goes back to main menu based on the button the user clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("List Accounts")) {
            new PrintAccounts(accountList);
        }
        if (e.getActionCommand().equals("Clear JSON")) {
            try {
                Bank.clearJson();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getActionCommand().equals("Back to Menu")) {
            new Main();
        }
    }
}
