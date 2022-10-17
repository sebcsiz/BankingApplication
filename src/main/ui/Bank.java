package ui;

import model.BankAccount;

import java.util.Random;
import java.util.Scanner;
import java.util.Date;


public class Bank {
    Scanner scanner = new Scanner(System.in);
    String name;
    double initialBalanceD;
    double initialBalanceC;
    BankAccount savings;
    BankAccount chequing;
    long ms = System.currentTimeMillis();
    Date date = new Date(ms);

    public Bank() {
        bankConsole(); // When bank is called in main, it will run bankConsole();
    }

    public void bankConsole() {
        String userChoice;
        System.out.println("Welcome to the Bank of CPSC, What is your name?");
        name = scanner.next();
        System.out.println("What is your initial savings balance? (if not applicable enter -1)");
        initialBalanceD = scanner.nextDouble();
        System.out.println("What is your initial credit balance? (if not applicable enter -1)");
        initialBalanceC = scanner.nextDouble();
        while (true) { // Will keep looping until the user selects 'z'
            menu(); // Calls menu function;
            userChoice = scanner.next();
            if (userChoice.equalsIgnoreCase("z")) { // checks if the user wants to quit the application
                break;
            } else {
                userMenuChoice(userChoice); // calls userMenuChoice with the users choice from menu()
            }
        }
    }

    public BankAccount account() {
        System.out.println("(s) Savings or (c) Chequing"); // asks user which type of account they want to access
        String userAccChoice = scanner.next();
        if (userAccChoice.equalsIgnoreCase("s")) {
            savings = new BankAccount(name, initialBalanceD);
            return savings; // if the user chooses 's' they will access their savings account
        } else if (userAccChoice.equalsIgnoreCase("c")) {
            chequing = new BankAccount(name, initialBalanceC);
            return chequing; // if the user doesn't choose 's', they will access their chequing account
        }
        System.out.println("Invalid account");
        return null;
    }

    public void menu() {
        // Lists all the options for the user to choose from
        System.out.println("Hello " + name + ", Currently: " + date);
        System.out.println("(a). Deposit");
        System.out.println("(b). Withdraw");
        System.out.println("(c). Add account");
        System.out.println("(d). View account balance (Savings)");
        System.out.println("(e). View account balance (Chequing)");
        System.out.println("(f). Change password");
        System.out.println("(g). Delete account");
        System.out.println("(h). Gamble");
        System.out.println("(z). Quit");
    }

    public void userMenuChoice(String choice) {
        // Depending on the users choice,
        if (choice.equalsIgnoreCase("a")) {
            deposit(); // calls the deposit function
        } else if (choice.equalsIgnoreCase("b")) {
            withdraw(); // calls the withdrawal function
        } else if (choice.equalsIgnoreCase("c")) {
            account(); // calls the account function
        } else if (choice.equalsIgnoreCase("d")) {
            getAccountBalance(savings); // calls the getAccountBalance function for the savings account
        } else if (choice.equalsIgnoreCase("e")) {
            getAccountBalance(chequing); // calls the getAccountBalance function for the chequing account
        } else if (choice.equalsIgnoreCase("f")) {
            changePassword(); // calls the changePassword method
        } else if (choice.equalsIgnoreCase("g")) {
            deleteAccount(); // calls the deleteAccount function
        } else if (choice.equalsIgnoreCase("h")) {
            gamble(); // calls the gamble function
        }
    }

    public void deposit() {
        BankAccount account = account(); // prompts user to pick either their savings or chequing account
        System.out.println("How much would you like to deposit?");
        double amount = scanner.nextDouble();
        if (amount < 0) {
            System.out.println("Invalid amount");
        } else {
            account.deposit(amount);
            System.out.println("Deposited $" + amount);
        }
    }

    public void withdraw() {
        BankAccount account = account(); // prompts user to pick either their savings or chequing account
        System.out.println("How much would you like to withdraw?");
        double amount = scanner.nextDouble();
        if (amount < 0) { // checks for valid amount
            System.out.println("Invalid amount!");
        } else if (amount > account.getBalance()) { // checks if the amount is more than the user currently has
            System.out.println("Insufficient funds!");
        } else {
            account.withdraw(amount);
        }
    }

    public void changePassword() {
        System.out.println("Feature coming soon");
    }

    public void deleteAccount() {
        System.out.println("What account would you like to delete?\n(s) Savings or (c) Chequing account");
        String userChoice = scanner.next();
        // whichever account the user chooses, that BankAccount object will bet set to null, basically 'deleting it'
        if (userChoice.equalsIgnoreCase("s")) {
            savings = null;
        } else {
            chequing = null;
        }
    }

    public void gamble() {
    // WORK IN PROGRESS //
        java.util.Random rndNum = new Random(); // creating a Random object
        int n = rndNum.nextInt(11); // creating a random number between 1 and 10
        System.out.println("Which account would you like to gamble with?");
        BankAccount account = account(); // prompts user to pick either their savings or chequing account
        System.out.println("How much would you like to gamble?");
        double userGamble = scanner.nextDouble();
        if (userGamble >= account.getBalance()) { // checking that user has enough money to gamble
            System.out.println("Insufficient Funds");
            return; // if the user doesn't have enough money, return to main menu
        }
        // getting the users guess
        System.out.println("Choose a number between 1-10 (Odds 3:1)");
        int userGuess = scanner.nextInt();

        // if the users guess is equal to the random number, they win their money back times 3.
        if (userGuess == n) {
            account.deposit(3 * userGamble); // call deposit function to add money to users account
            System.out.println("You won $" + (3 * userGamble));
        } else {
            account.withdraw(userGamble); // call withdraw method the remove users gamble amount from their account
            System.out.println("You lost $" + userGamble + "\nThe correct number was " + n);
        }
    }

    public void getAccountBalance(BankAccount account) {
        if (account == null) { // used if user calls this function on an account that doesn't exist
            System.out.println("Sorry, Account does not exist");
        } else { // returns the users account balance
            System.out.println(account.getName() + "'s current balance: $" + account.getBalance());
        }
    }
}
