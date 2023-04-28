package ict.db;

import ict.data_objects.entities.BookingRequestResponse;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;

public class BookingRequestResponseDatabase {
    private final Database<BookingRequestResponse> db;

    public BookingRequestResponseDatabase() {
        this.db = new Database<>(rs -> {
            int detailsId = rs.getInt("details_id");
            return new BookingRequestResponse(
                rs.getInt("id"),
                detailsId != 0 ? new BookingApprovedDetailsDatabase().queryById(detailsId) : null,
                rs.getBoolean("approved")
            );
        });
    }

    public BookingRequestResponse queryById(int id) {
        return db.queryById(id, "booking_request_response");
    }

    @Nullable
    public BookingRequestResponse queryByBookingId(int bookingId) {
        var q = db.queryByIntColumn("booking_request_response", "booking_id", bookingId);
        if (q.isEmpty())
            return null;
        return q.get(0);
    }

    public void addApprove(int bookingId, int approvedDetailsId) {
        String sql = "insert into booking_request_response (approved, details_id, booking_id) values (?,?,?);";
        try {
            var s = db.getConnection().prepareStatement(sql);
            s.setBoolean(1, true);
            s.setInt(2, approvedDetailsId);
            s.setInt(3, bookingId);
            db.insertRow(s, "booking_request_response");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addDecline(int bookingId) {
        // todo set approved details default null
        String sql = "insert into booking_request_response (approved, booking_id) values (?,?);";
        try {
            var s = db.getConnection().prepareStatement(sql);
            s.setBoolean(1, false);
            s.setInt(2, bookingId);
            db.insertRow(s, "booking_request_response");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
