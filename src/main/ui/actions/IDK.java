package ui.actions;

import ui.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class IDK extends JFrame implements ActionListener {

    private JButton button;

    // EFFECTS: creates a new frame with a special background
    public IDK() {
        try {
            setIconImage(ImageIO.read(new File("data/money.png")));
            final Image backgroundImage = ImageIO.read(new File("data/idk.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        addButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    // EFFECTS: creates button
    public void addButton() {
        button = new JButton("Back");
        button.setBounds(250,200,150,50);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD,20));
        button.setFocusable(false);
        button.addActionListener(this);
        add(button);
    }

    // REQUIRES: e
    // EFFECTS: if user clicks button, the sound playing will stop and the user will be brought back to the main menu
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            Main.stopSound();
            dispose();
            new Main();
        }
    }
}
