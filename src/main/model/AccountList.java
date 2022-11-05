package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class AccountList implements Writable {
    private String name;
    private List<BankAccount> accounts;

    // EFFECTS: constructs new AccountList with name and empty list of BankAccounts
    public AccountList(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: adds BankAccount to this AccountList
    public void addBankAccount(BankAccount bk) {
        accounts.add(bk);
    }

    // MODIFIES: this
    // EFFECTS: removes BankAccount from this AccountList
    public void removeBankAccount(BankAccount bk) {
        accounts.remove(bk);
    }

    // EFFECTS: checks if BankAccount is in AccountList
    public boolean containsBankAccount(BankAccount bk) {
        if (accounts.contains(bk) == true) {
            return true;
        }
        return false;
    }

    // EFFECTS: returns size of accounts
    public int size() {
        return accounts.size();
    }

    // EFFECTS: prints out all accounts
    public void printAccountList() {
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
        }
    }

    // EFFECTS: checks if users enter details matches a current account
    public boolean accountLogIn(String name, String password) {
        for (BankAccount bk : accounts) {
            if (name.equals(bk.getName()) && password.equals(bk.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("accounts", bankAccountToJson());
        return json;
    }

    // EFFECTS: returns BankAccounts in this AccountList as a JSON array
    private JSONArray bankAccountToJson() {
        JSONArray jsonArray = new JSONArray();

        for (BankAccount bk : accounts) {
            jsonArray.put(bk.toJson());
        }

        return jsonArray;
    }
}