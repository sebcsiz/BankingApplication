package ui.actions;

import model.BankAccount;
import ui.InAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Gamble extends Action {

    private JTextField text;
    private JLabel label;
    private JButton button;


    public Gamble(BankAccount account) {
        super(account);
        gamble();
    }

    public void gamble() {
        initializeSwing();

    }

    public void initializeSwing() {
        text = new JTextField();
        label = new JLabel("Enter Amount (Odds 3:1)");
        button = new JButton("I'm Feeling Lucky");

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
            dispose();
            new InAccount(this.account);
        }
    }
}
