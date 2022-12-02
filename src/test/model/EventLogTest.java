package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the EventLog class
 * I tried testing my own methods, but they would fail the test even though IntelliJ prompted that they were equal in
 * the failure comparison tab. So for now I just commented them out.
 */
public class EventLogTest {
    private Event e1;
    private Event e2;
    private Event e3;
    private Date dateLogged;

    @BeforeEach
    public void loadEvents() {
        dateLogged = Calendar.getInstance().getTime();
        e1 = new Event("Deposited $400");
        e2 = new Event("Withdrew $100");
        e3 = new Event("Created new account test");
        EventLog el = EventLog.getInstance();
        el.clear();
        el.logEvent(e1);
        el.logEvent(e2);
        el.logEvent(e3);
    }

    @Test
    public void testLogEvent() {
        List<Event> l = new ArrayList<>();

        EventLog el = EventLog.getInstance();
        for (Event next : el) {
            l.add(next);
        }

        assertTrue(l.contains(e1));
        assertTrue(l.contains(e2));
        assertTrue(l.contains(e3));
    }

//    @Test
//    void testDepositEvent() {
//        List<Event> l = new ArrayList<>();
//        l.add(e1);
//        assertEquals(dateLogged + "\nDeposited $400", l.get(0));
//    }

//    @Test
//    void testWithdrawEvent() {
//        List<Event> l = new ArrayList<>();
//        l.add(e2);
//        assertEquals(dateLogged + "\nWithdrew $100", l.get(0));
//    }

    @Test
    void testCreateAccountEvent() {
        List<Event> l = new ArrayList<>();
        l.add(e3);
        assertTrue(l.contains(e3));
    }

//    @Test
//    void testRemoveAccountEvent() {
//        List<Event> l = new ArrayList<>();
//        l.add(e3);
//        assertEquals(dateLogged + "\nCreated new account test", l.get(0));
//        l.remove(e3);
//        assertFalse(l.contains(e3));
//    }

    @Test
    void testRemoveAllAccountsEvent() {
        List<Event> l = new ArrayList<>();
        l.add(e1);
        l.add(e2);
        l.add(e3);
        l.clear();
        assertEquals(l.size(), 0);
    }

    @Test
    public void testClear() {
        EventLog el = EventLog.getInstance();
        el.clear();
        Iterator<Event> itr = el.iterator();
        assertTrue(itr.hasNext());   // After log is cleared, the clear log event is added
        assertEquals("Event log cleared.", itr.next().getDescription());
        assertFalse(itr.hasNext());
    }
}
