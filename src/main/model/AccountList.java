package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static ui.InAccount.saveAccount;

public class AccountList implements Writable {
    private String name = "List of Accounts";
    private static List<BankAccount> accounts;

    // EFFECTS: constructs .new AccountList with name and empty list of BankAccounts
    public AccountList() {
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    // MODIFIES: this
    // EFFECTS: adds BankAccount to this AccountList
    public void addBankAccount(BankAccount bk) {
        accounts.add(bk);
        EventLog.getInstance().logEvent(new Event("Added Bank Account: " + bk.getName()
                + " to the Account list"));
    }

    // MODIFIES: this
    // EFFECTS: removes BankAccount from this AccountList
    public void removeBankAccount(BankAccount bk) {
        accounts.remove(bk);
        EventLog.getInstance().logEvent(new Event("Removed Bank account: "
                + bk.getName() + " from the Account list"));
    }

    // EFFECTS: checks if BankAccount is in AccountList
    public boolean containsBankAccount(BankAccount bk) {
        if (accounts.contains(bk) == true) {
            return true;
        }
        return false;
    }

    // EFFECTS: returns size osf accounts
    public int size() {
        return accounts.size();
    }

    // EFFECTS: prints out all accounts
    public static Component printAccountList() {
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
        }
        return null;
    }

    public static void clearAccounts() {
        AccountList accList = new AccountList();
        saveAccount(accList);
        BankAccount.logEvent("Cleared all accounts");
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
