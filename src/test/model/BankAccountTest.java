package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    BankAccount account;

    @BeforeEach
    void runBefore() {
        account = new BankAccount("testName", 100);
    }

    @Test
    void depositTest() {
        account.deposit(400);
        assertEquals(account.getBalance(), 500);
    }

    @Test
    void withdrawTest() {
        account.withdraw(50);
        assertEquals(account.getBalance(), 50);

        account.withdraw(1000);
        assertEquals(account.getBalance(), 50);
    }

}