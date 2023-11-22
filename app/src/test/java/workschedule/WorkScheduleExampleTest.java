package workschedule;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        int nemployee = 5, starttime = 3, endtime = 6;

        try {
            wSchedule.setRequiredNumber(nemployee, starttime, endtime);

        } catch (IndexOutOfBoundsException e) {
            expected = "error";
        }

        assertEquals("", expected);
    }

    @Test
    public void testSetRequiredNumber_ReturnIndexOutOfBoundException_Valid() {
        String expected = "";
        int nemployee = 1, starttime = -2, endtime = 4;

        try {
            wSchedule.setRequiredNumber(nemployee, starttime, endtime);

        } catch (IndexOutOfBoundsException e) {
            expected = "error";
        }

        assertEquals("error", expected);
    }
}
