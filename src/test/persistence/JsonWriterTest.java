package persistence;

import model.AccountList;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            AccountList al = new AccountList("My account list");
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
            AccountList al = new AccountList("My account list");
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
    void testJsonWriter() throws FileNotFoundException {
        try {
            AccountList al = new AccountList("test list");
            JsonWriter writer = new JsonWriter("./data/JsonTests/testJsonWriter.json");
            writer.open();
            writer.write(al);
            writer.close();
        } catch (FileNotFoundException e) {
            fail("No exception should be thrown");
        }
    }
}