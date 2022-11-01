package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    BankAccount testAccount;

    @BeforeEach
    void runBefore() {
        testAccount = new BankAccount("testName", "testPass", 100);
    }

    @Test
    void testNegativeConstructorBalance() {
        testAccount = new BankAccount("name", "pass", -9000);
        assertEquals(testAccount.getName(), "name");
        assertEquals(testAccount.getPassword(), "pass");
        assertEquals(testAccount.getBalance(), 0);
    }

    @Test
    void testDeposit() {
        testAccount.deposit(400);
        assertEquals(testAccount.getBalance(), 500);
    }

    @Test
    void testNegativeDeposit() {
        testAccount.deposit(-99);
        assertEquals(testAccount.getBalance(), 100);
    }

    @Test void testMultipleDeposits() {
        testAccount.deposit(700);
        testAccount.deposit(4);
        assertEquals(testAccount.getBalance(), 804);
    }

    @Test
    void testWithdraw() {
        testAccount.withdraw(50);
        assertEquals(testAccount.getBalance(), 50);
    }

    @Test
    void testWithdrawAtSameAmount() {
        testAccount.withdraw(100);
        assertEquals(testAccount.getBalance(), 0);
    }

    @Test
    void testWithdrawToMuch() {
        testAccount.withdraw(1000);
        assertEquals(testAccount.getBalance(), 100);
    }

    @Test
    void testNegativeWithdrawal() {
        testAccount.withdraw(-90);
        assertEquals(testAccount.getBalance(), 100);
    }

    @Test
    void testMultipleWithdrawals() {
        testAccount.withdraw(70);
        testAccount.withdraw(18);
        assertEquals(testAccount.getBalance(), 12);
    }

    @Test
    void testToString() {
        assertTrue(testAccount.toString().contains("Name: testName, Current Balance: $100.0, Current Password: testPass"));
    }
}