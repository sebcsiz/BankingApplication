package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Admin extends JFrame implements ActionListener {

    private JLabel passwordLabel = new JLabel("Admin Password");
    private JTextField passwordText = new JTextField(15);
    private JButton button = new JButton("Enter");

    public Admin() {
        try {
            setIconImage(ImageIO.read(new File("data/money.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        adminLogIn();
        button.setBounds(640,380,300,80);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    public void adminLogIn() {
        passwordLabel.setBounds(570,260,500,75);
        passwordLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD,50));
        add(passwordLabel);

        passwordText.setBounds(640,340,300,25);
        passwordText.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        passwordText.addActionListener(this);
        add(passwordText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter")) {
            if (passwordText.getText().equals("scsiz")) {
                new InAdmin();
            }
        }
    }
}
