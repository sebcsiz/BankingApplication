package ui.actions;

import model.AccountList;
import model.BankAccount;
import ui.InAccount;
import ui.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

// Allows user to delete their current account
public class DeleteAccount extends Action {

    private AccountList accountList = Main.getAccountList();

    private JLabel label;
    private JButton yes;
    private JButton no;

    // REQUIRES: account
    // EFFECTS: calls deleteAccount()
    public DeleteAccount(BankAccount account) {
        super(account);
        deleteAccount();;
    }

    // EFFECTS: creates text and buttons
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

    // REQUIRES: e
    // EFFECTS: either removes account and goes to main menu, or goes back to account menu
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Yes")) {
            try {
                Main.loadAccountList();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            accountList.removeBankAccount(this.account);
            dispose();
            new Main();
        }
        if (e.getActionCommand().equals("No")) {
            dispose();
            new InAccount(this.account);
        }

    }
}
