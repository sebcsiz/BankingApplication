package ui;

import model.BankAccount;

import java.util.*;


public class Bank {
    Scanner scanner = new Scanner(System.in);
    String name;
    String password;
    final String adminPassword = "scsiz";
    double balance;
    BankAccount account;
    long ms = System.currentTimeMillis();
    Date date = new Date(ms);
    private List<BankAccount> bankAccountList = new ArrayList<>();

    public Bank() {
        bankConsole(); // When bank is called in main, it will run bankConsole();
    }

    // MODIFIES: name, password, initialBalance, account
    /*
     *   EFFECTS:  Welcomes the user asking for their name and if they already have an account,
     *             if they already have an account, asks them to log in, if they do not have an account,
     *             they are prompted to make one.
    */
    public void bankConsole() {
        String userChoice;
        System.out.print("Welcome to the Bank of CPSC: (A) Access Account (B) Create Account (LEAVE) Exit "
                + "application, (ADMIN) Admin: ");
        userChoice = scanner.next();
        checkLeaveApplication(userChoice);
        if (userChoice.equalsIgnoreCase("A")) {
            logIn();
        } else if (userChoice.equalsIgnoreCase("B")) {
            createAccount();
        } else if (userChoice.equalsIgnoreCase("ADMIN")) {
            listAllAccountsFromStart();
        } else {
            System.out.println("Bruh");
            System.exit(69);
        }
    }

    /*
    *  EFFECTS: calls menu() for user to pick action from
    */
    public void firstMenuChoice() {
        String userChoice;
        while (true) { // Will keep looping until the user selects 'z'
            menu(); // Calls menu function;
            userChoice = scanner.next();
            userMenuChoice(userChoice);
        }
    }

    // MODIFIES: account
    /*
     *  EFFECTS: returns users account
     */
    public BankAccount account() {
        account = new BankAccount(name, password, balance);
        return account;
    }

    /*
     *  EFFECTS: Prints out all options the user can choose from
     */
    public void menu() {
        // Lists all the options for the user to choose from
        System.out.println("Hello " + account.getName() + ", Currently: " + date + "\nYour current balance is $"
                + account.getBalance());
        System.out.println("(a). Deposit");
        System.out.println("(b). Withdraw");
        System.out.println("(c). Change password");
        System.out.println("(d). Delete account");
        System.out.println("(e). Gamble");
        System.out.println("(f). Admin");
        System.out.println("(g). Logout");
        System.out.println("(z). Quit");
    }

    // REQUIRES: choice
    // MODIFIES: choice
    /*
     *  EFFECTS: Takes users input and chooses action
     */
    public void userMenuChoice(String choice) {
        // Depending on the users choice,
        if (choice.equalsIgnoreCase("a")) {
            deposit(); // calls the deposit function
        } else if (choice.equalsIgnoreCase("b")) {
            withdraw(); // calls the withdrawal function
        } else if (choice.equalsIgnoreCase("c")) {
            changePassword(); // calls the changePassword method
        } else if (choice.equalsIgnoreCase("d")) {
            deleteAccount(); // calls the deleteAccount function
        } else if (choice.equalsIgnoreCase("e")) {
            gamble(); // calls the gamble function
        } else if (choice.equalsIgnoreCase("f")) {
            listAllAccounts();
        } else if (choice.equalsIgnoreCase("g")) {
            logOut();
        } else if (choice.equalsIgnoreCase("z")) {
            System.exit(0);
        }
    }

    // REQUIRES: amount < 0
    // MODIFIES: account
    /*
     *  EFFECTS: Checks if amount is valid and deposits amount to users account
     */
    public void deposit() {
        BankAccount account = account();
        System.out.println("How much would you like to deposit?");
        double amount = scanner.nextDouble();
        if (amount < 0) {
            System.out.println("Invalid amount");
        } else {
            account.deposit(amount);
            System.out.println("Deposited $" + amount);
        }
    }

    // MODIFIES: account
    /*
     *  EFFECTS: Checks if amount is valid and withdraws amount from users account
     */
    public void withdraw() {
        BankAccount account = account();
        System.out.println("How much would you like to withdraw?");
        double amount = scanner.nextDouble();
        if (amount < 0) { // checks for valid amount
            System.out.println("Invalid amount!");
        } else if (amount > account.getBalance()) { // checks if the amount is more than the user currently has
            System.out.println("Insufficient funds!");
        } else {
            account.withdraw(amount);
            System.out.println("Withdrew $" + amount);
        }
    }

    // REQUIRES: passAttemptCount != 0 and userChoice.equals(password)
    /*
     *  EFFECTS: Checks if users password guess is equal to their actual password, they're given only three attempts.
     */
    public void checkPassword() {
        String userChoice;
        int passAttemptCount = 3;
        while (passAttemptCount != 0) {
            System.out.println("Enter your current password (" + passAttemptCount + " more attempts)");
            userChoice = scanner.next();
            passAttemptCount--;
            if (userChoice.equals(password)) {
                return;
            }
        }
        System.out.println("Too Many Attempts!");
        System.exit(0);
    }

    // REQUIRES: checkPassword(password);
    // MODIFIES: password
    /*
     *  EFFECTS: Calls checkPassword, if successful call, user will be prompted to change their password to whatever
     *  they want
     */
    public void changePassword() {
        String userChoice;
        checkPassword();
        System.out.println("What do you want to change your password to?");
        userChoice = scanner.next();
        password = userChoice;
        System.out.println("Password successfully changed");
    }

    // MODIFIES: bankAccountList
    /*
     * EFFECTS:  Loops through bankAccountList. Once the loop idx equals the current users name, that account is
     *           removed from bankAccountList
     */
    public void deleteAccount() {
        for (int i = 0; i < bankAccountList.size(); i++) {
//            if (account.getName().equals(name)) {
            if (bankAccountList.contains(account.getName())) {
                bankAccountList.remove(account);
                System.out.println("Account Deleted");
            }
        }
        bankConsole();
    }

    // REQUIRES: userGamble >= account.getBalance()
    // MODIFIES: balance
    /*
     *  EFFECTS: Allows user to gamble away their savings. If they correctly guess the randomly generated number, three
     *           times their original gamble will be deposited to their account. If they lose, their original bet will
     *           be withdrawn from their account
     */
    public void gamble() {
    // WORK IN PROGRESS //
        java.util.Random rndNum = new Random(); // creating a Random object
        int n = rndNum.nextInt(11); // creating a random number between 1 and 10
        BankAccount account = account();
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

    // REQUIRES: userChoice.equals(adminPassword)
    // EFFECTS: Prints out all current accounts to console
    public void listAllAccounts() {
        String userChoice;
        System.out.println("Enter admin password");
        userChoice = scanner.next();
        if (userChoice.equals(adminPassword)) {
            for (BankAccount a : bankAccountList) {
                System.out.println("-" + a.toString());
            }
        }
    }

    // REQUIRES: userChoice.equals(adminPassword)
    /*
     * EFFECTS: Same as listAllAccounts(), except this is for the start screen. If this is called then once all the
     *          accounts are printed, it will return the user back to the start screen and not the user choice menu
     */
    public void listAllAccountsFromStart() {
        String userChoice;
        System.out.println("Enter admin password");
        userChoice = scanner.next();
        if (userChoice.equals(adminPassword)) {
            for (BankAccount a : bankAccountList) {
                System.out.println("-" + a.toString());
            }
        }
        bankConsole();
    }

    // REQUIRES: userIn.equals("LEAVE")
    // EFFECTS: Terminates application
    public void checkLeaveApplication(String userIn) {
        if (userIn.equals("LEAVE")) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }

    // REQUIRES: a.getName().equals(name) and password.equals(account.getPassword())
    /*
     * EFFECTS: Loops through bankAccountList to see if the given AccountID exists in the List, if so, user will be
     *          prompted to enter their password to access their account
     */
    public void logIn() {
        String userChoice;
        System.out.print("Enter your name (Account ID): ");
        name = scanner.next();
        for (BankAccount bankAccount : bankAccountList) {
            if (bankAccount.getName().equals(name)) {
                System.out.print("Enter your password: ");
                userChoice = scanner.next();
                if (userChoice.equals(account.getPassword())) {
                    firstMenuChoice();
                } else {
                    break;
                }
            }
        }
        System.out.println("Cannot find account with Account ID \"" + name + "\"");
        bankConsole();
    }

    // REQUIRES:
    /*
     * EFFECTS:
     */
    public void logOut() {
//        account = null;
        bankConsole();
    }

    /*
     * EFFECTS: Creates a new BankAccount object with user-given name, password, and initial balance
     */
    public void createAccount() {
        System.out.println("If you want to exit the application, enter 'LEAVE'");
        System.out.print("What is your name? (This will be your Account ID): ");
        name = scanner.next();
        checkLeaveApplication(name);
        System.out.print("What do you want your password to be?: ");
        password = scanner.next();
        checkLeaveApplication(password);
        System.out.println("How much would you like to originally deposit?: ");
        balance = scanner.nextDouble();
        account = new BankAccount(name, password, balance);
        bankAccountList.add(account);
        firstMenuChoice();
    }
}
