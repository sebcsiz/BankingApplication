package ui;

import model.BankAccount;
import ui.actions.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class InAccount extends JFrame implements ActionListener {

    private BankAccount account;

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

    // Suppressed because this is easier than making a separate method to create each new button then call it
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void listOptions() {
        welcomeMessage();

        depositButton.setBounds(10,70,250,40);
        depositButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        depositButton.setFocusable(false);
        depositButton.addActionListener(this);
        add(depositButton);

        withdrawButton.setBounds(10,120,250,40);
        withdrawButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        withdrawButton.setFocusable(false);
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        changePassButton.setBounds(10,170,250,40);
        changePassButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        changePassButton.setFocusable(false);
        changePassButton.addActionListener(this);
        add(changePassButton);

        deleteAccButton.setBounds(10,220,250,40);
        deleteAccButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        deleteAccButton.setFocusable(false);
        deleteAccButton.addActionListener(this);
        add(deleteAccButton);

        gambleButton.setBounds(10,270,250,40);
        gambleButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        gambleButton.setFocusable(false);
        gambleButton.addActionListener(this);
        add(gambleButton);

        adminButton.setBounds(10,320,250,40);
        adminButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        adminButton.setFocusable(false);
        adminButton.addActionListener(this);
        add(adminButton);

        logoutButton.setBounds(10,370,250,40);
        logoutButton.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);
        add(logoutButton);
    }

    public void welcomeMessage() {
        JLabel welcome;
        JLabel welcome1;

        welcome = new JLabel("Hello " + account.getName() + ", Currently: " + Bank.getDate());
        welcome.setBounds(0,0,800,25);
        welcome.setFont(new Font(Font.MONOSPACED, Font.BOLD,25));
        add(welcome);

        welcome1 = new JLabel("Your current balance is $" + account.getBalance());
        welcome1.setBounds(0,35,800,25);
        welcome1.setFont(new Font(Font.MONOSPACED, Font.BOLD,25));
        add(welcome1);
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    public void actionPerformed(ActionEvent e) {
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
            dispose();
            new Main();
        }
        if (e.getActionCommand().equals("Ok")) {
            new InAccount(this.account);
        }
    }
}
