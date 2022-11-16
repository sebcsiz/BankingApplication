package ui.actions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SetBackground extends JFrame {

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
