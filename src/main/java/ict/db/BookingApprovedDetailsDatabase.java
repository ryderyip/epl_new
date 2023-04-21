package ict.db;

import ict.data_objects.entities.BookingApprovedDetails;

public class BookingApprovedDetailsDatabase {
    private final Database<BookingApprovedDetails> db;

    public BookingApprovedDetailsDatabase() {
        db = new Database<>(rs -> new BookingApprovedDetails(
            rs.getInt("id"),
                rs.getBigDecimal("booking_fee"),
                rs.getBoolean("payment_confirmed"),
                rs.getString("payment_receipt")
        ));
    }

    public BookingApprovedDetails queryById(int id) {
        return db.queryById(id, "booking_approval_details");
    }
}
