package ui;

import model.AccountList;
import model.BankAccount;
import persistence.JsonWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

// Prompts user to enter new account details, and creates a new account
public class CreateAccount extends JFrame implements ActionListener {

    private BankAccount bankAccount;
    private AccountList accountList;
    private static String name;
    private String password;
    private int bal;
    private static JsonWriter jsonWriter;
    private static final String JSON_STORE = "./data/AccountList.json";

    private JLabel userLabel = new JLabel("Name");
    private JTextField userText = new JTextField(15);
    private JLabel passwordLabel = new JLabel("Password");
    private JTextField passwordText = new JTextField(15);
    private JLabel initialBalanceLabel = new JLabel("Initial Balance");
    private JTextField initialBalanceText = new JTextField(15);
    private JButton button = new JButton("Continue");

    // EFFECTS: Creates window and button. Calls createAccountTextFields()
    public CreateAccount() {
        jsonWriter = new JsonWriter(JSON_STORE);
        try {
            setIconImage(ImageIO.read(new File("data/money.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        createAccountTextFields();
        button.setBounds(600,500,400,75);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);
    }

    // EFFECTS: creates labels and text fields
    public void createAccountTextFields() {

        userLabel.setBounds(720,180,300,75);
        userLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD,50));
        add(userLabel);

        userText.setBounds(640,250,300,25);
        userText.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        userText.addActionListener(this);
        add(userText);

        passwordLabel.setBounds(670,270,300,75);
        passwordLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD,50));
        add(passwordLabel);

        passwordText.setBounds(640,340,300,25);
        passwordText.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        passwordText.addActionListener(this);
        add(passwordText);

        initialBalanceLabel.setBounds(560,360,500,75);
        initialBalanceLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD,50));
        add(initialBalanceLabel);

        initialBalanceText.setBounds(640,430,300,25);
        initialBalanceText.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        initialBalanceText.addActionListener(this);
        add(initialBalanceText);
    }

    // REQUIRES: e
    // MODIFIES: name, password, balance, bankAccount, accountList. Adds new bankAccount and goes to account menu
    // EFFECTS:
    @Override
    public void actionPerformed(ActionEvent e) {
        name = userText.getText();
        password = passwordText.getText();
        bal = Integer.parseInt(initialBalanceText.getText());
        bankAccount = new BankAccount(name, password, bal);
        if (e.getActionCommand().equals("Continue")) {
            accountList = Main.getAccountList();
            accountList.addBankAccount(bankAccount);
            dispose();
            new InAccount(bankAccount);
        }
    }
}
