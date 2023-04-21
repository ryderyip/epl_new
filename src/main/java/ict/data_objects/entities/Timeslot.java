package ict.data_objects.entities;

import java.time.Instant;

public class Timeslot {
    private int id;
    private Instant beginTime;
    private Instant endTime;

    public Timeslot(int id, Instant beginTime, Instant endTime) {
        this.id = id;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Instant beginTime) {
        this.beginTime = beginTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }
}
