package ui.actions;

import model.BankAccount;
import ui.InAccount;
import ui.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DeleteAccount extends Action {

    private JLabel label;
    private JButton yes;
    private JButton no;


    public DeleteAccount(BankAccount account) {
        super(account);
        deleteAccount();;
    }

    public void deleteAccount() {
        label = new JLabel("Delete account");
        yes = new JButton("Yes");
        no = new JButton("No");

        label.setBounds(560,180,2000,75);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD,50));
        add(label);

        yes.setBounds(350,400,400,75);
        yes.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        yes.setFocusable(false);
        yes.addActionListener(this);
        add(yes);

        no.setBounds(800,400,400,75);
        no.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        no.setFocusable(false);
        no.addActionListener(this);
        add(no);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Yes")) {
            account = null;
            dispose();
            new Main();
        }
        if (e.getActionCommand().equals("No")) {
            dispose();
            new InAccount(this.account);
        }

    }
}
