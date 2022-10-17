package model;

public class BankAccount {
    private String name;         // account holder's name
    private double balance;      // account balance

    public BankAccount(String name, double balance) {
        this.name = name;
        if (balance >= 0.0) { // checks if the balance is valid
            this.balance = balance;
        } else {
            this.balance = 0; // if the balance is not valid, it will default to 0
        }
    }

    public String getName() {
        return name; // returns name
    }

    public double getBalance() {
        return balance; // returns balance
    }

    public double deposit(double amount) {
        if (amount > 0) { // checks if given amount is valid and greater than 0
            balance += amount; // adds given amount from account
        }

        return balance; // returns new balance
    }

    public double withdraw(double amount) {
        if (getBalance() >= amount) { // checks if the balance has enough to be withdrawn from
            balance -= amount; // removes given amount from account
        }

        return balance; // returns new balance
    }
}
