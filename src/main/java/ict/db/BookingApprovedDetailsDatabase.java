package ict.db;

import ict.data_objects.entities.BookingApprovedDetails;

import java.sql.SQLException;

public class BookingApprovedDetailsDatabase {
    private final Database<BookingApprovedDetails> db;

    public BookingApprovedDetailsDatabase() {
        db = new Database<>(rs -> new BookingApprovedDetails(
            rs.getInt("id"),
                rs.getDouble("booking_fee"),
                rs.getBoolean("payment_confirmed"),
                rs.getString("payment_receipt")
        ));
    }

    public BookingApprovedDetails queryById(int id) {
        return db.queryById(id, "booking_approval_details");
    }

    public int add(double fee) {
        String sql = "insert into booking_approval_details (booking_fee) values (?);";
        int id;
        try {
            var s = db.getConnection().prepareStatement(sql);
            s.setDouble(1, fee);
            id = db.insertRow(s, "booking_approval_details");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    public void update(BookingApprovedDetails approvedDetails) {
        String sql = "update booking_approval_details set payment_receipt = ?, payment_confirmed = ? where id = ?;";
        try {
            var s = db.getConnection().prepareStatement(sql);
            s.setString(1, approvedDetails.getPaymentReceipt());
            s.setBoolean(2, approvedDetails.isPaymentConfirmed());
            s.setInt(3, approvedDetails.getId());
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
