package ui.actions;

import model.BankAccount;
import ui.InAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Deposit extends Action {

    private JTextField text;
    private JLabel label;
    private JButton button;


    public Deposit(BankAccount account) {
        super(account);
        deposit();
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Continue")) {
            account.deposit(Double.parseDouble(text.getText()));
            dispose();
            new InAccount(this.account);
        }
    }
}
