package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InAdmin extends JFrame implements ActionListener {

    private JButton button;
    private JButton button1;
    private JButton button2;

    public InAdmin() {
        try {
            setIconImage(ImageIO.read(new File("data/money.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        actions();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void actions() {
        button = new JButton("List Accounts");
        button.setBounds(600,450,400,75);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);

        button1 = new JButton("Clear JSON");
        button1.setBounds(600,550,400,75);
        button1.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button1.setFocusable(false);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("Back to Menu");
        button2.setBounds(600,650,400,75);
        button2.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button2.setFocusable(false);
        button2.addActionListener(this);
        add(button2);

        try {
            BufferedImage picture = ImageIO.read(new File("data/bigbodycle.jpg"));
            JLabel label = new JLabel(new ImageIcon(picture));
            label.setBounds(400, 50, 800, 400);
            add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("List Accounts")) {
            print(null);
        }
        if (e.getActionCommand().equals("Clear JSON")) {
            print(null);
        }
        if (e.getActionCommand().equals("Back to Menu")) {
            new Main();
        }
    }
}
