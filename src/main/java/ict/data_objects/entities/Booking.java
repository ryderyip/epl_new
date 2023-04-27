package ict.data_objects.entities;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.time.Instant;

public class Booking implements Serializable {
    private int id;
    private Member booker;
    private Timeslot timeSlot;
    private Venue venue;
    private Instant requestedOn;
    @Nullable
    private BookingRequestResponse bookingRequestResponse;
    @Nullable
    private VenueUsage venueUsage;

    public Booking(int id, Member booker, @NotNull Timeslot timeSlot, Venue venue, Instant requestedOn, @Nullable BookingRequestResponse bookingRequestResponse, @Nullable VenueUsage venueUsage) {
        this.id = id;
        this.booker = booker;
        this.timeSlot = timeSlot;
        this.venue = venue;
        this.requestedOn = requestedOn;
        this.bookingRequestResponse = bookingRequestResponse;
        this.venueUsage = venueUsage;
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

    public @Nullable BookingRequestResponse getBookingRequestResponse() {
        return bookingRequestResponse;
    }

    public void setBookingRequestResponse(@Nullable BookingRequestResponse bookingRequestResponse) {
        this.bookingRequestResponse = bookingRequestResponse;
    }

    public String getStatusMessage() {
        return bookingRequestResponse == null
                ? "Pending" : bookingRequestResponse.isApproved()
                ? "Approved" : "Declined";
    }

    public @Nullable VenueUsage getVenueUsage() {
        return venueUsage;
    }

    public void setVenueUsage(@Nullable VenueUsage venueUsage) {
        this.venueUsage = venueUsage;
    }
}
