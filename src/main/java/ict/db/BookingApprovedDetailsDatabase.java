package ict.db;

import ict.data_objects.entities.BookingApprovedDetails;
import ict.data_objects.entities.BookingFee;

import java.sql.SQLException;

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

    public int add(BookingFee bookingFee) {
        // todo set default paymentConfirmed false
        // todo set payment_receipt default null
        // todo set booking_fee field type to match type in table booking_fee
        String sql = "insert into booking_approval_details (booking_fee) values (?);";
        int id;
        try {
            var s = db.getConnection().prepareStatement(sql);
            s.setDouble(1, bookingFee.getHourlyRate());
            id = db.insertRow(s, "booking_approval_details");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
