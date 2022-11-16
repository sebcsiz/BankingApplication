package ui.actions;

import model.BankAccount;
import ui.InAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GambleFinal extends Action {

    java.util.Random rndNum = new Random();
    int randint = rndNum.nextInt(11);
    int amountEntered;

    private JTextField numberGuessed;
    private JLabel label;
    private JButton button;

    public GambleFinal(BankAccount account, int gambleAmount) {
        super(account);
        amountEntered = gambleAmount;
        gamble();
    }

    public void gamble() {
        label = new JLabel("Choose a number between 1-10");
        numberGuessed = new JTextField();
        button = new JButton("I'm Feeling Lucky");

        label.setBounds(400,180,2000,75);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD,50));
        add(label);

        numberGuessed.setBounds(640,250,300,25);
        numberGuessed.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        numberGuessed.addActionListener(this);
        add(numberGuessed);

        button.setBounds(600,500,400,75);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("I'm Feeling Lucky")) {
            if (Integer.parseInt(numberGuessed.getText()) == randint) {
                account.deposit(3 * amountEntered);
            } else {
                account.withdraw(amountEntered);
            }
            new InAccount(this.account);
        }
    }
}
