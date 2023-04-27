package ict.service;

import ict.data_objects.entities.BookingFee;
import ict.db.BookingApprovedDetailsDatabase;
import ict.db.BookingRequestResponseDatabase;
import org.jetbrains.annotations.NotNull;

import java.time.Year;

public class BookingRequestResponseService {
    private final int bookingId;

    public BookingRequestResponseService(int bookingId) {
        this.bookingId = bookingId;
    }

    public void approve(@NotNull BookingFee bookingFee) {
        assert bookingFee.getYear() == Year.now().getValue();
        var detailsId = new BookingApprovedDetailsDatabase().add(bookingFee);
        new BookingRequestResponseDatabase().addApprove(bookingId, detailsId);
    }

    public void decline() {
        new BookingRequestResponseDatabase().addDecline(bookingId);
    }
}
