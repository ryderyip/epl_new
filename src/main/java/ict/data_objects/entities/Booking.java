package ict.data_objects.entities;


import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.Instant;

public class Booking implements Serializable {
    private int id;
    
    private Member booker;
    private Timeslot timeSlot;
    private Venue venue;
    private Instant requestedOn;

    public Booking() {}

    public Booking(int id, Member booker, @NotNull Timeslot timeSlot, Venue venue, Instant requestedOn) {
        this.id = id;
        this.booker = booker;
        this.timeSlot = timeSlot;
        this.venue = venue;
        this.requestedOn = requestedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getBooker() {
        return booker;
    }

    public void setBooker(Member booker) {
        this.booker = booker;
    }

    public Timeslot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Timeslot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Instant getRequestedOn() {
        return requestedOn;
    }

    public void setRequestedOn(Instant requestedOn) {
        this.requestedOn = requestedOn;
    }
}
