package ui;

import model.BankAccount;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class InAccount extends JFrame implements ActionListener {

    BankAccount account;
    JLabel welcome;
    JLabel welcome1;

    private JButton deposit = new JButton("Deposit");
    private JButton withdraw = new JButton("Withdraw");
    private JButton changePass = new JButton("Change Password");
    private JButton deleteAcc = new JButton("Delete Account");
    private JButton gamble = new JButton("Gamble");
    private JButton admin = new JButton("Admin");
    private JButton logout = new JButton("Log Out");

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

        deposit.setBounds(10,70,250,40);
        deposit.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        deposit.setFocusable(false);
        deposit.addActionListener(this);
        add(deposit);

        withdraw.setBounds(10,120,250,40);
        withdraw.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        withdraw.setFocusable(false);
        withdraw.addActionListener(this);
        add(withdraw);

        changePass.setBounds(10,170,250,40);
        changePass.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        changePass.setFocusable(false);
        changePass.addActionListener(this);
        add(changePass);

        deleteAcc.setBounds(10,220,250,40);
        deleteAcc.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        deleteAcc.setFocusable(false);
        deleteAcc.addActionListener(this);
        add(deleteAcc);

        gamble.setBounds(10,270,250,40);
        gamble.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        gamble.setFocusable(false);
        gamble.addActionListener(this);
        add(gamble);

        admin.setBounds(10,320,250,40);
        admin.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        admin.setFocusable(false);
        admin.addActionListener(this);
        add(admin);

        logout.setBounds(10,370,250,40);
        logout.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        logout.setFocusable(false);
        logout.addActionListener(this);
        add(logout);
    }

    public void welcomeMessage() {
        welcome = new JLabel("Hello " + account.getName() + ", Currently: " + Bank.getDate());
        welcome.setBounds(0,0,800,25);
        welcome.setFont(new Font(Font.MONOSPACED, Font.BOLD,25));
        add(welcome);

        welcome1 = new JLabel("Your current balance is $" + account.getBalance());
        welcome1.setBounds(0,35,800,25);
        welcome1.setFont(new Font(Font.MONOSPACED, Font.BOLD,25));
        add(welcome1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Deposit")) {
            print(null);
        }
        if (e.getActionCommand().equals("Withdraw")) {
            print(null);
        }
        if (e.getActionCommand().equals("Change Password")) {
            print(null);
        }
        if (e.getActionCommand().equals("Delete Account")) {
            print(null);
        }
        if (e.getActionCommand().equals("Gamble")) {
            print(null);
        }
        if (e.getActionCommand().equals("Admin")) {
            new Admin();
        }
        if (e.getActionCommand().equals("Log Out")) {
            dispose();
            new Main();
        }
    }
}
