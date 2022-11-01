package persistence;

import model.AccountList;
import model.BankAccount;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads AccountList from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads AccountList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public AccountList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseAccountList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses AccountList from JSON object and returns it
    private AccountList parseAccountList(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        AccountList al = new AccountList(name);
        addBankAccounts(al, jsonObject);
        return al;
    }

    // MODIFIES: wr
    // EFFECTS: parses BankAccounts from JSON object and adds them to AccountList
    private void addBankAccounts(AccountList al, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("accounts");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addBankAccount(al, nextThingy);
        }
    }

    // MODIFIES: bk
    // EFFECTS: parses BankAccount from JSON object and adds it to AccountList
    private void addBankAccount(AccountList al, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String password = jsonObject.getString("password");
        double balance = jsonObject.getDouble("balance");
        BankAccount bk = new BankAccount(name, password, balance);
        al.addBankAccount(bk);
    }
}