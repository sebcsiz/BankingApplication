package persistence;

import model.AccountList;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    
    @Test
    void testWriterInvalidFile() {
        try {
            AccountList al = new AccountList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            AccountList al = new AccountList();
            JsonWriter writer = new JsonWriter("./data/JsonTests/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(al);
            writer.close();

            JsonReader reader = new JsonReader("./data/JsonTests/testWriterEmptyWorkroom.json");
            al = reader.read();
            assertEquals("My account list", al.getName());
            assertEquals(0, al.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testJsonWriter() {
        try {
            AccountList al = new AccountList();
            JsonWriter writer = new JsonWriter("./data/JsonTests/testJsonWriter.json");
            writer.open();
            writer.write(al);
            writer.close();
        } catch (FileNotFoundException e) {
            fail("No exception should be thrown");
        }
    }
}
