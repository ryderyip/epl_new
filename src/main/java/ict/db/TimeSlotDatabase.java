package ict.db;

import ict.data_objects.entities.Timeslot;

import java.time.Instant;

public class TimeSlotDatabase {
    private final Database<Timeslot> db;

    public TimeSlotDatabase() {
        db = new Database<>(rs -> new Timeslot(
            rs.getInt("id"),
            rs.getObject("begin_time", Instant.class),
            rs.getObject("end_time", Instant.class)
        ));
    }

    public Timeslot queryById(int id) {
        return db.queryById(id, "timeslot");
    }
}
