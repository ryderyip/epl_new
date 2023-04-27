package ict.test;

import ict.data_objects.entities.Timeslot;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TimeslotTest {

    @Test
    void hasOverlapWith_noOverlap() {
        var aBegin = new Date(2023, Calendar.APRIL, 26, 5, 0).toInstant();
        var aEnd = new Date(2023, Calendar.APRIL, 26, 8, 0).toInstant();
        Timeslot timeslotA = new Timeslot(1, aBegin, aEnd);
        var bBegin = new Date(2023, Calendar.APRIL, 26, 17, 0).toInstant();
        var bEnd = new Date(2023, Calendar.APRIL, 26, 19, 0).toInstant();
        Timeslot timeslotB = new Timeslot(1, bBegin, bEnd);
        assertFalse(timeslotA.hasOverlapWith(timeslotB));
        assertFalse(timeslotB.hasOverlapWith(timeslotA));
    }
    
    @Test
    void hasOverlapWith_yesOverlap() {
        var aBegin = new Date(2023, Calendar.APRIL, 26, 5, 0).toInstant();
        var aEnd = new Date(2023, Calendar.APRIL, 26, 8, 0).toInstant();
        Timeslot timeslotA = new Timeslot(1, aBegin, aEnd);
        var bBegin = new Date(2023, Calendar.APRIL, 26, 5, 0).toInstant();
        var bEnd = new Date(2023, Calendar.APRIL, 26, 8, 0).toInstant();
        Timeslot timeslotB = new Timeslot(1, bBegin, bEnd);
        assertTrue(timeslotA.hasOverlapWith(timeslotB));
        assertTrue(timeslotB.hasOverlapWith(timeslotA));
    }
}