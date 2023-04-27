package ict.data_objects.entities;

import org.jetbrains.annotations.Nullable;

import java.time.Instant;

public class VenueUsage {
    private int id;
    private Instant checkIn;
    @Nullable
    private CheckOut checkOut;
    private String memberComments;

    public VenueUsage(int id, Instant checkIn, @Nullable CheckOut checkOut, String memberComments) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.memberComments = memberComments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Instant checkIn) {
        this.checkIn = checkIn;
    }

    public @Nullable CheckOut getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(@Nullable CheckOut checkOut) {
        this.checkOut = checkOut;
    }

    public String getMemberComments() {
        return memberComments;
    }

    public void setMemberComments(String memberComments) {
        this.memberComments = memberComments;
    }
}
