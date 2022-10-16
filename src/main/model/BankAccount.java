package model;

public class BankAccount {
    private int accNum;          // Account number (4-digits)
    private String accNumString; // Used for parseInt(accNum) to help get first digit of acc number
    private String name;         // Account holder's name
    private double balance;      // Account balance


    /*
    * REQUIRES: Alphanumeric name, balance != >0, 4 digit account number
    * EFFECTS:
    * */
    public BankAccount(String name, double balance, int accountNum) {
        this.name = name;
        accNum = accountNum;
        accNumString = String.valueOf(accNum);
        if (Integer.parseInt(String.valueOf(accNumString.charAt(0))) == 8) { // Check if acc num starts with an 8, if so
            this.balance = balance + 500.0;                                  // account gets $500 added. "Promotion acc"
        } else if (balance >= 0.0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }
}
