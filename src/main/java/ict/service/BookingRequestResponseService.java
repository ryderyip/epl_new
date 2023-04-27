package ict.service;

import ict.data_objects.entities.BookingFee;
import ict.db.BookingApprovedDetailsDatabase;
import ict.db.BookingRequestResponseDatabase;
import org.jetbrains.annotations.NotNull;

import java.time.Year;

public class BookingRequestResponseService {
    private final int bookingId;

    public BookingRequestResponseService(int bookingId) {
        this.bookingFee = bookingFee;
        this.bookingId = bookingId;
        assert bookingFee.getYear() == Year.now().getValue();
    }

    public void approve(@NotNull BookingFee bookingFee) {
        var detailsid = new BookingApprovedDetailsDatabase().add(bookingFee);
        new BookingRequestResponseDatabase().addApprove(bookingId, detailsid);
    }

    public void decline() {
        new BookingRequestResponseDatabase().addDecline(bookingId);
    }
}
