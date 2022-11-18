package ui.actions;

import model.AccountList;
import model.BankAccount;
import persistence.JsonReader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

// Prints all saved accounts
public class PrintAccounts extends JFrame implements ActionListener {

    private AccountList accountList;
    private BankAccount[] info = new BankAccount[10];
    private static JsonReader jsonReader;
    private static final String JSON_STORE = "./data/AccountList.json";

    private JLabel label;
    private JList list;

    // REQUIRES: accountList
    // EFFECTS: initializes new window and calls printAccounts()
    public PrintAccounts(AccountList accountList) {
        this.accountList = accountList;
        jsonReader = new JsonReader(JSON_STORE);
        try {
            setIconImage(ImageIO.read(new File("data/money.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        printAccounts();
        setBackground(new Color(255,255,255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);

    }

    // EFFECTS: prints all saved accounts
    public void printAccounts() {
        label = new JLabel(accountList.getName());
        addJsonItemsToArray();
//        list = new JList<>(info);
        label.add(list);
        label.setBounds(0,0,1000,1000);
        add(label);
//        label
    }

    // MODIFIES: info
    // EFFECTS: adds entries from accountList to info (arrayList => array)
    public void addJsonItemsToArray() {
        for (int i = 0; i < accountList.size(); i++) {
            info[i] = accountList.getAccounts(i);
        }
    }

    // REQUIRES: e
    // EFFECTS: nothing
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
