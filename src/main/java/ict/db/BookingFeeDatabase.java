package ict.db;

import ict.data_objects.entities.BookingFee;

public class BookingFeeDatabase {
    private final Database<BookingFee> db;

    public BookingFeeDatabase() {
        this.db = new Database<>(rs -> new BookingFee(
                rs.getInt("id"),
                rs.getDouble("hourly_rate"),
                rs.getInt("year")
        ));
    }

    public BookingFee queryById(int bookingFeeId) {
        return db.queryById(bookingFeeId, "booking_fee");
    }
}
