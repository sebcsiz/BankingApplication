package model;

import org.json.JSONObject;
import persistence.Writable;

public class BankAccount implements Writable {
    private String name;         // account holder's name
    private String password = "";     // account holder's password
    private double balance;      // account balance


    // REQUIRES: balance >= 0.0
    // MODIFIES: this.name, this.balance
    /*
     * EFFECTS: sets account name to given name and original balance (if entered balance is more
     * than $0.0), if balance < 0, users balance is set to $0
     */
    public BankAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        if (balance >= 0.0) { // checks if the balance is valid
            this.balance = balance;
        } else {
            this.balance = 0; // if the balance is not valid, it will default to 0
        }
    }

    public static void logEvent(String description) {
        EventLog.getInstance().logEvent(new Event(description));
    }

    public String getName() {
        return name; // returns name
    }

    public void setPassword(String password) {
        this.password = password;
        logEvent("Changed password to: " + this.password);
    }

    public String getPassword() {
        return password; //returns password
    }

    public double getBalance() {
        return balance; // returns balance
    }

    // REQUIRES: amount > 0

    // MODIFIES: balance
    /*
     * EFFECTS: Checks if amount is greater than 0 and deposits to the account. if not, returns
     *          current account balance.
     */
    public double deposit(double amount) {
        if (amount < 0) { // checks if given amount is less than 0
            System.out.println("Invalid amount");
        } else {
            balance += amount; // adds given amount from account
            logEvent("Deposited $" + amount);
        }

        return balance; // returns new balance
    }

    // REQUIRES: balance >= amount
    // MODIFIES: balance
    /*
    * EFFECTS:  Checks if requested amount can be withdrawn from users account, if so the amount
    *           will be removed from the users account, if not the users original balance will
    *           be returned.
    */
    public double withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Invalid Amount");
        } else if (balance >= amount) { // checks if the balance has enough to be withdrawn from
            balance -= amount; // removes given amount from account
            logEvent("Withdrew: $" + amount);
        }

        return balance; // returns new balance
    }

    // Do you need to write REQUIRES/MODIFIES/EFFECTS for toString?
    @Override
    public String toString() {
        return "Name: " + getName() + ", Current Balance: $" + getBalance() + ", Current Password: " + getPassword();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("password", password);
        json.put("balance", balance);
        return json;
    }
}
