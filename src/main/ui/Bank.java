package ui;

import model.BankAccount;

import java.util.Scanner;


public class Bank {
    Scanner scanner = new Scanner(System.in);
    String name;
    int initialBalance;
    BankAccount savings;
    BankAccount chequing;


    public Bank() {
        bankConsole();
    }

    public void bankConsole() {
        String userChoice;
        System.out.println("Welcome to the Bank of CPSC");
        while (true) {
            menu();
            userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("z")) {
                break;
            } else {
                userMenuChoice(userChoice);
            }
        }
    }

    public BankAccount account() {
        System.out.println("(s) Savings or (c) Chequing");
        String userAccChoice = scanner.nextLine();
        if (userAccChoice.equalsIgnoreCase("s")) {
            savings = new BankAccount(name, initialBalance);
            return savings;
        }
        chequing = new BankAccount(name, initialBalance);
        return chequing;
    }

    public void menu() {
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
        if (choice.equalsIgnoreCase("a")) {
            deposit();
        } else if (choice.equalsIgnoreCase("b")) {
            withdraw();
        } else if (choice.equalsIgnoreCase("c")) {
            openAccount();
        } else if (choice.equalsIgnoreCase("d")) {
            getAccountBalance(savings);
        } else if (choice.equalsIgnoreCase("e")) {
            getAccountBalance(chequing);
        } else if (choice.equalsIgnoreCase("f")) {
            changePassword();
        } else if (choice.equalsIgnoreCase("g")) {
            deleteAccount();
        } else if (choice.equalsIgnoreCase("h")) {
            gamble();
        }
    }

    public void deposit() {
        BankAccount account = account();
        System.out.println("How much would you like to deposit?");
        double amount = scanner.nextDouble();
        if (amount < 0) {
            System.out.println("Invalid amount");
        } else {
            account.deposit(amount);
        }
    }

    public void withdraw() {
        BankAccount account = account();
        System.out.println("How much would you like to withdraw?");
        double amount = scanner.nextDouble();
        if (amount < 0) {
            System.out.println("Invalid amount!");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient funds!");
        } else {
            account.withdraw(amount);
        }
    }

    public void openAccount() {
        // WORK IN PROGRESS //
        // might be too hard to make multiple accounts of saving & chequing

        System.out.println("What is your name? How much is you initial deposit?");
        name = scanner.nextLine();
        initialBalance = scanner.nextInt();
        System.out.println("New (s) Savings or (c) Chequing account");
        String userChoice = scanner.nextLine();
        if (userChoice.equalsIgnoreCase("s")) {
            savings = new BankAccount(name, initialBalance);
        } else {
            chequing = new BankAccount(name, initialBalance);
        }
    }

    public void changePassword() {
        System.out.println("Feature coming soon");
    }

    public void deleteAccount() {
        System.out.println("What account would you like to delete?\n(s) Savings or (c) Chequing account");
        String userChoice = scanner.nextLine();
        if (userChoice.equalsIgnoreCase("s")) {
            savings = null;
        } else {
            chequing = null;
        }
    }

    public void gamble() {
        System.out.println("Feature coming soon");
    }

    public void getAccountBalance(BankAccount account) {
        if (account == null) {
            System.out.println("Sorry, Account does not exist");
        } else {
            System.out.println(account.getName() + "'s current balance: " + account.getBalance());
        }
    }
}
