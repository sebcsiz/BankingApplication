package ui.actions;

import model.BankAccount;
import ui.InAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// Allows user to deposit money into their account
public class Deposit extends Action {

    private JTextField text;
    private JLabel label;
    private JButton button;

    // REQUIRES: account
    // EFFECTS: calls deposit()
    public Deposit(BankAccount account) {
        super(account);
        deposit();
    }

    // EFFECTS: creates text, label, and button
    public void deposit() {
        text = new JTextField();
        label = new JLabel("How much would you like to deposit?");
        button = new JButton("Continue");

        label.setBounds(250,180,2000,75);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD,50));
        add(label);

        text.setBounds(640,250,300,25);
        text.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        text.addActionListener(this);
        add(text);

        button.setBounds(600,500,400,75);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);

    }

    // REQUIRES: e
    // EFFECTS: deposits amount into account, then goes back to account menu
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Continue")) {
            account.deposit(Double.parseDouble(text.getText()));
            dispose();
            new InAccount(this.account);
        }
    }
}
