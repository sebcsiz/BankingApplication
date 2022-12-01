package ui.actions;

import model.AccountList;
import org.json.JSONObject;
import persistence.JsonReader;
import ui.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class ClearJson extends JFrame {
    JsonReader jsonReader;
    private static final String JSON_STORE = "./data/AccountList.json";


    public ClearJson() throws IOException {
        Main.loadAccountList();
        jsonReader = new JsonReader(JSON_STORE);
        try {
            setIconImage(ImageIO.read(new File("data/money.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        clearJsonFile();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);
    }

    public void clearJsonFile() {

    }

}
