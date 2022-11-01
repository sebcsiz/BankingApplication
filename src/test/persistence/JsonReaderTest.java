package persistence;

import model.AccountList;
import model.BankAccount;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            AccountList al = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyAccountList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyAccountList.json");
        try {
            AccountList al = reader.read();
            assertEquals("My account list", al.getName());
            assertEquals(0, al.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderAddAccount() {
        JsonReader reader = new JsonReader("./data/testReaderAddAccount.json");
        try {
            AccountList al = reader.read();
            al.addBankAccount(new BankAccount("testName", "testPass", 100));
            assertEquals("My account list", al.getName());
            assertEquals(1, al.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}