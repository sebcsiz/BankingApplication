package ui.actions;

import model.AccountList;
import model.BankAccount;
import persistence.JsonReader;
import ui.InAdmin;
import ui.Main;

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
    private static JsonReader jsonReader;
    private static final String JSON_STORE = "data/AccountList.json";

    private JList list;
    private JLabel label;
    private JButton button1;
    private JButton button2;

    // REQUIRES: accountList
    // EFFECTS: initializes new window and calls printAccounts()
    public PrintAccounts() throws IOException {
        setBackground("data/linus.png");
        Main.loadAccountList();
        accountList = Main.getAccountList();
        jsonReader = new JsonReader(JSON_STORE);
        try {
            setIconImage(ImageIO.read(new File("data/money.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        printAccounts();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);

    }

    // EFFECTS: prints all saved accounts
    public void printAccounts() {
        list = new JList(accountList.getAccounts().toArray());
        list.setBounds(0,60,1000,600);
        list.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        list.setForeground(Color.red);
        list.setOpaque(false);
        list.setBackground(new Color(0, 0, 0, 0));
        add(list);

        createButtonsAndLabel();
    }

    // EFFECTS: creates label and buttons
    public void createButtonsAndLabel() {
        label = new JLabel("Current Accounts");
        label.setBounds(0,0,300,50);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD,30));
        add(label);

        button1 = new JButton("Back to Admin");
        button1.setBounds(1300,300,200,50);
        button1.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Main Menu");
        button2.setBounds(1300,360,200,50);
        button2.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button2.addActionListener(this);
        add(button2);
    }

    // REQUIRES: fileName
    // MODIFIES: JFrame
    // EFFECTS: changes frame background to the file given by the user
    public void setBackground(String fileName) {
        try {
            final Image backgroundImage = ImageIO.read(new File(fileName));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // REQUIRES: e
    // EFFECTS: nothing
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back to Admin")) {
            dispose();
            new InAdmin();
        }
        if (e.getActionCommand().equals("Main Menu")) {
            dispose();
            new Main();
        }
    }
}
