import org.junit.jupiter.api.Test;

import ua.edu.ucu.apps.task2.Authorization;
import ua.edu.ucu.apps.task2.Database;
import ua.edu.ucu.apps.task2.ReportBuilder;
import ua.edu.ucu.apps.task2.Авторизація;
import ua.edu.ucu.apps.task2.БазаДаних;

import static org.junit.jupiter.api.Assertions.*;

public class TestTask2 {

    @Test
    public void testБазаДаних() {
        БазаДаних db = new БазаДаних();
        assertEquals("hello", db.отриматиДаніКористувача());
        assertEquals("hello2", db.отриматиСтатистичніДані());
    }

    @Test
    public void testАвторизація() {
        БазаДаних db = new БазаДаних();
        Авторизація auth = new Авторизація();
        assertTrue(auth.авторизуватися(db));
    }

    @Test
    public void testDatabase() {
        Database db = new Database();
        assertEquals("hello", db.getUserData());
        assertEquals("hello2", db.getStatisticsData());
    }

    @Test
    public void testAuthorization() {
        Database db = new Database();
        Authorization auth = new Authorization();
        assertTrue(auth.authorize(db));
    }

    @Test
    public void testReportBuilder() {
        Database db = new Database();
        ReportBuilder rb = new ReportBuilder(db);
        assertNotNull(rb);
    }

    @Test
    public void testOverrideMethods() {
        Database db = new Database();
        assertEquals("hello", db.отриматиДаніКористувача());
        assertEquals("hello2", db.отриматиСтатистичніДані());

        Authorization auth = new Authorization();
        assertTrue(auth.авторизуватися(db));
    }
}
