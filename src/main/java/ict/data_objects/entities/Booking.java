package ict.data_objects.entities;


import java.time.Instant;

public class Booking {
    private int id;
    private Member booker;
    private BookingRequestResponse bookingResponse;
    private Timeslot timeSlot;
    private Venue venue;
    private VenueUsage venueUsage;
    private Instant requestedOn;

    public Booking(int id, Member booker, BookingRequestResponse bookingResponse, Timeslot timeSlot, Venue venue, VenueUsage venueUsage, Instant requestedOn) {
        this.id = id;
        this.booker = booker;
        this.bookingResponse = bookingResponse;
        this.timeSlot = timeSlot;
        this.venue = venue;
        this.venueUsage = venueUsage;
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

    public BookingRequestResponse getBookingResponse() {
        return bookingResponse;
    }

    public void setBookingResponse(BookingRequestResponse bookingResponse) {
        this.bookingResponse = bookingResponse;
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

    public VenueUsage getVenueUsage() {
        return venueUsage;
    }

    public void setVenueUsage(VenueUsage venueUsage) {
        this.venueUsage = venueUsage;
    }

    public Instant getRequestedOn() {
        return requestedOn;
    }

    public void setRequestedOn(Instant requestedOn) {
        this.requestedOn = requestedOn;
    }
}
