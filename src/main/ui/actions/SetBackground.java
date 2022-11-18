package ui.actions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// Changes GUI background
public class SetBackground extends JFrame {

    // REQUIRES: fileName
    // MODIFIES: JFrame
    // EFFECTS: changes background of JFrame to given file from user
    public SetBackground(String filename) {
        try {
            setIconImage(ImageIO.read(new File("data/money.png")));
            final Image backgroundImage = ImageIO.read(new File(filename));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, null);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }
}
