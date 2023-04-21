package ict.data_objects.entities;

import java.time.Instant;

public class CheckOut {
    private int id;
    private Instant time;
    private String staffRemarks;

    public CheckOut(int id, Instant time, String staffRemarks) {
        this.id = id;
        this.time = time;
        this.staffRemarks = staffRemarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getStaffRemarks() {
        return staffRemarks;
    }

    public void setStaffRemarks(String staffRemarks) {
        this.staffRemarks = staffRemarks;
    }
}
