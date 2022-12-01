package ui;

import model.AccountList;
import model.BankAccount;
import persistence.JsonWriter;
import ui.actions.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

// Allows user to choose different options to change values of Bank Account
public class InAccount extends JFrame implements ActionListener {

    private BankAccount account;
    private AccountList accountList;
    private static JsonWriter jsonWriter;
    private static final String JSON_STORE = "./data/AccountList.json";

    private JButton depositButton = new JButton("Deposit");
    private JButton withdrawButton = new JButton("Withdraw");
    private JButton changePassButton = new JButton("Change Password");
    private JButton deleteAccButton = new JButton("Delete Account");
    private JButton gambleButton = new JButton("Gamble");
    private JButton adminButton = new JButton("Admin");
    private JButton logoutButton = new JButton("Log Out");

    private JTextField textDeposit = new JTextField();
    private JButton buttonDeposit = new JButton("Ok");
    private JTextField textWithdraw = new JTextField();
    private JButton buttonWithdraw = new JButton("Ok");

    // REQUIRES: account
    // MODIFIES: account
    // EFFECTS: creates window and calls listOptions()
    public InAccount(BankAccount account) {
        this.account = account;
        try {
            setIconImage(ImageIO.read(new File("data/money.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        listOptions();
        setBackground(new Color(255,255,255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);
    }

    // EFFECTS: calls all methods to replicate the account CLI
    public void listOptions() {
        welcomeMessage();
        createDepositButton();
        createWithdrawButton();
        createChangePasswordButton();
        createDeleteAccountButton();
        createGambleButton();
        createAdminButton();
        createLogoutButton();
    }

    // EFFECTS: creates deposit button
    public void createDepositButton() {
        depositButton.setBounds(10,70,250,40);
        depositButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        depositButton.setFocusable(false);
        depositButton.addActionListener(this);
        add(depositButton);
    }

    // EFFECTS: creates withdraw button
    public void createWithdrawButton() {
        withdrawButton.setBounds(10,120,250,40);
        withdrawButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        withdrawButton.setFocusable(false);
        withdrawButton.addActionListener(this);
        add(withdrawButton);
    }

    // EFFECTS: creates change password button
    public void createChangePasswordButton() {
        changePassButton.setBounds(10,170,250,40);
        changePassButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        changePassButton.setFocusable(false);
        changePassButton.addActionListener(this);
        add(changePassButton);
    }

    // EFFECTS: creates delete account button
    public void createDeleteAccountButton() {
        deleteAccButton.setBounds(10,220,250,40);
        deleteAccButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        deleteAccButton.setFocusable(false);
        deleteAccButton.addActionListener(this);
        add(deleteAccButton);
    }

    // EFFECTS: creates gamble button
    public void createGambleButton() {
        gambleButton.setBounds(10,270,250,40);
        gambleButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        gambleButton.setFocusable(false);
        gambleButton.addActionListener(this);
        add(gambleButton);
    }

    // EFFECTS: creates admin button
    public void createAdminButton() {
        adminButton.setBounds(10,320,250,40);
        adminButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        adminButton.setFocusable(false);
        adminButton.addActionListener(this);
        add(adminButton);
    }

    // EFFECTS: creates logout button
    public void createLogoutButton() {
        logoutButton.setBounds(10,370,250,40);
        logoutButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);
        add(logoutButton);
    }

    // EFFECTS: creates welcome labels
    public void welcomeMessage() {
        JLabel welcome;
        JLabel welcome1;

        welcome = new JLabel("Hello " + account.getName() + ", Currently: " + Bank.getDate());
        welcome.setBounds(0,0,1000,25);
        welcome.setFont(new Font(Font.MONOSPACED, Font.BOLD,25));
        add(welcome);

        welcome1 = new JLabel("Your current balance is $" + account.getBalance());
        welcome1.setBounds(0,35,800,25);
        welcome1.setFont(new Font(Font.MONOSPACED, Font.BOLD,25));
        add(welcome1);
    }

    // REQUIRES: accountList
    // MODIFIES: jsonWriter
    // EFFECTS: saves account to accountList
    public static void saveAccount(AccountList accountList) {
        jsonWriter = new JsonWriter(JSON_STORE);
        try {
            jsonWriter.open();
            jsonWriter.write(accountList);
            jsonWriter.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    // MODIFIES: accountList
    // EFFECTS: logs user out to main menu and saves their account to JSON file
    public void logOut() {
        dispose();
        accountList = Main.getAccountList();
        saveAccount(accountList);
        new Main();
    }

    // REQUIRES: e
    // EFFECTS: choose which window to open based on which button the user clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        if (e.getActionCommand().equals("Deposit")) {
            new Deposit(this.account);
        }
        if (e.getActionCommand().equals("Withdraw")) {
            new Withdraw(this.account);
        }
        if (e.getActionCommand().equals("Change Password")) {
            new ChangePass(this.account);
        }
        if (e.getActionCommand().equals("Delete Account")) {
            new DeleteAccount(this.account);
        }
        if (e.getActionCommand().equals("Gamble")) {
            new Gamble(this.account);
        }
        if (e.getActionCommand().equals("Admin")) {
            new Admin();
        }
        if (e.getActionCommand().equals("Log Out")) {
            logOut();
        }
    }
}
