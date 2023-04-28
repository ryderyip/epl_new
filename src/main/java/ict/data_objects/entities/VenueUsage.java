package ict.data_objects.entities;

import org.jetbrains.annotations.Nullable;

import java.time.Instant;

public class VenueUsage {
    private int id;
    private Instant checkIn;
    @Nullable
    private Instant checkOut;
    private String memberComments;
    private String staffRemarks;

    public VenueUsage(int id, Instant checkIn, @Nullable Instant checkOut, String memberComments, String staffRemarks) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.memberComments = memberComments;
        this.staffRemarks = staffRemarks;
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

    public @Nullable Instant getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(@Nullable Instant checkOut) {
        this.checkOut = checkOut;
    }

    public String getMemberComments() {
        return memberComments;
    }

    public void setMemberComments(String memberComments) {
        this.memberComments = memberComments;
    }

    public String getStaffRemarks() {
        return staffRemarks;
    }

    public void setStaffRemarks(String staffRemarks) {
        this.staffRemarks = staffRemarks;
    }
}
