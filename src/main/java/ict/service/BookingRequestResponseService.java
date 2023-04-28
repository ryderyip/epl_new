package ict.service;

import ict.data_objects.entities.Booking;
import ict.data_objects.entities.BookingFee;
import ict.db.BookingApprovedDetailsDatabase;
import ict.db.BookingRequestResponseDatabase;
import org.jetbrains.annotations.NotNull;

import java.time.Year;

public class BookingRequestResponseService {
    private final Booking booking;

    public BookingRequestResponseService(Booking booking) {
        this.booking = booking;
    }

    public void approve(@NotNull BookingFee bookingFee) {
        assert bookingFee.getYear() == Year.now().getValue();
        var fee = bookingFee.getHourlyRate() * booking.getTimeslot().getDurationInHours();
        var detailsId = new BookingApprovedDetailsDatabase().add(fee);
        new BookingRequestResponseDatabase().addApprove(booking.getId(), detailsId);
    }

    public void decline() {
        new BookingRequestResponseDatabase().addDecline(booking.getId());
    }
}
