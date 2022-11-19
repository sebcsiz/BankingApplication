package ui.actions;

import model.BankAccount;
import ui.InAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// Allows user to gamble their balance
public class Gamble extends Action {

    private JTextField amountEntered;
    private JLabel label;
    private JButton button;
    private JButton button1;

    // REQUIRES: account
    // EFFECTS: calls initializeSwing()
    public Gamble(BankAccount account) {
        super(account);
        initializeSwing();
    }

    // EFFECTS: takes in user bet and creates label and buttons
    public void initializeSwing() {
        amountEntered = new JTextField();
        label = new JLabel("Enter Amount (Odds 3:1)");
        button = new JButton("Bet");
        button1 = new JButton("Quit");

        label.setBounds(430,180,2000,75);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD,50));
        add(label);

        amountEntered.setBounds(640,250,300,25);
        amountEntered.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        amountEntered.addActionListener(this);
        add(amountEntered);

        button.setBounds(460,300,300,50);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);

        button1.setBounds(800,300,300,50);
        button1.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button1.setFocusable(false);
        button1.addActionListener(this);
        add(button1);
    }

    // REQUIRES: e
    // EFFECTS: either calls new GambleFinal or goes back to account screen if user doesn't have enough funds
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Bet")) {
            dispose();
            new GambleFinal(this.account, Integer.parseInt(amountEntered.getText()));
        }
        if (e.getActionCommand().equals("Quit")) {
            dispose();
            new InAccount(this.account);
        }
    }
}
