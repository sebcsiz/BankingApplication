package ui.actions;

import model.BankAccount;
import ui.InAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChangePass extends Action {

    private JTextField text;
    private JLabel label;
    private JButton button;


    public ChangePass(BankAccount account) {
        super(account);
        changePassword();
    }

    public void changePassword() {
        text = new JTextField();
        label = new JLabel("Change password to");
        button = new JButton("Continue");

        label.setBounds(540,180,2000,75);
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
            account.setPassword(text.getText());
            dispose();
            new InAccount(this.account);
        }
    }
}
