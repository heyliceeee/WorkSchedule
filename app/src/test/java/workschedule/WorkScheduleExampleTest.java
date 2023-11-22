package workschedule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.EOFException;

import WorkSchedule.WorkSchedule;

public class WorkScheduleExampleTest {
    private WorkSchedule wSchedule;

    @BeforeEach
    public void setUp() {
        wSchedule = new WorkSchedule(24);
    }

    @Test
    public void testSetRequiredNumber_Valid() {
        String expected = "";

        try {
            wSchedule.setRequiredNumber(5, 3, 6);

        } catch (IndexOutOfBoundsException e) {
            expected = "error";
        }

        assertEquals("", expected);
    }

    @Test
    public void testSetRequiredNumber_ReturnIndexOutOfBoundException_Valid() {
        String expected = "";

        try {
            wSchedule.setRequiredNumber(1, -2, 4);

        } catch (IndexOutOfBoundsException e) {
            expected = "error";
        }

        assertEquals("error", expected);
    }

    @Test
    public void testAddWorkingPeriod_ReturnTrue_Valid() {
        boolean expected;

        wSchedule.setRequiredNumber(5, 3, 6); // nº necessário de employees para trabalhar naquela hora

        expected = wSchedule.addWorkingPeriod("John", 3, 6);

        assertEquals(true, expected);
    }

    @Test
    public void testAddWorkingPeriod_ReturnFalse_Valid() {
        boolean expected;

        wSchedule.setRequiredNumber(5, 3, 6); // nº necessário de employees para trabalhar naquela hora

        expected = wSchedule.addWorkingPeriod("David", 2, 8);

        assertEquals(false, expected);
    }
}
