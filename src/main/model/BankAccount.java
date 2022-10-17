package model;

public class BankAccount {
    private String name;         // Account holder's name
    private double balance;      // Account balance
    private int id;              // Account id
    private static int nextAccountId = 1;
    /*
     *  I was unable to figure out how to keep track of different created accounts, so I used
     *  the example that was used in the TellerApp demo
     *
     *  All credit for the id and keeping track of account id is not mine and is property of
     *  github.students.cs.ubc.ca/CPSC210/TellerApp/blob/main/src/main/ca/ubc/cpsc210/bank/model/Account.java
     */

    /*
     * REQUIRES: Alphanumeric name, balance != >0, 4 digit account number
     * EFFECTS:
     * */
    public BankAccount(String name, double balance) {
        id = nextAccountId++;
        this.name = name;
        if (balance >= 0.0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (getBalance() >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
        return balance;
    }
}
