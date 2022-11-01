package persistence;

import model.BankAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkBankAccount(String name, String pass, double bal, BankAccount bk) {
        assertEquals(name, bk.getName());
        assertEquals(pass, bk.getPassword());
        assertEquals(bal, bk.getBalance());
    }
}
