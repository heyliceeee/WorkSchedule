package workschedule;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // setRequiredNumber method
    @Test
    public void testSetRequiredNumber_Valid() {
        String actual = "";

        try {
            wSchedule.setRequiredNumber(5, 3, 6);

        } catch (IndexOutOfBoundsException e) {
            actual = "error";
        }

        assertEquals("", actual);
    }

    @Test
    public void testSetRequiredNumber_ReturnIndexOutOfBoundException_Valid() {
        String actual = "";

        try {
            wSchedule.setRequiredNumber(1, -2, 4);

        } catch (IndexOutOfBoundsException e) {
            actual = "error";
        }

        assertEquals("error", actual);
    }

    // addWorkingPeriod method
    @Test
    public void testAddWorkingPeriod_ReturnTrue_Valid() {
        wSchedule.setRequiredNumber(5, 3, 6); // nº necessário de employees para trabalhar naquela hora

        assertEquals(true, wSchedule.addWorkingPeriod("John", 3, 6));
    }

    @Test
    public void testAddWorkingPeriod_ReturnFalse_Valid() {
        wSchedule.setRequiredNumber(5, 3, 6); // nº necessário de employees para trabalhar naquela hora

        assertEquals(false, wSchedule.addWorkingPeriod("David", 2, 8));
    }

    // workingEmployees method
    @Test
    public void testWorkingEmployees_ReturnList_Valid() {
        String[] actual;
        String[] expected = { "John Doe", "Alice Dias" };

        wSchedule.setRequiredNumber(5, 3, 6); // nº necessário de employees para trabalhar naquela hora

        wSchedule.addWorkingPeriod("John Doe", 3, 6); // add employee naquela hora
        wSchedule.addWorkingPeriod("Alice Dias", 3, 6); // add employee naquela hora

        actual = wSchedule.workingEmployees(3, 6);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testWorkingEmployees_ReturnEmptyList_Valid() {
        String[] actual;
        String[] expected = new String[0];

        wSchedule.setRequiredNumber(5, 3, 6); // nº necessário de employees para trabalhar naquela hora

        wSchedule.addWorkingPeriod("John Doe", 3, 6); // add employee naquela hora
        wSchedule.addWorkingPeriod("Alice Dias", 3, 6); // add employee naquela hora

        actual = wSchedule.workingEmployees(2, 8);

        assertArrayEquals(expected, actual);
    }
}
