package ict.db;

import ict.data_objects.entities.VenueUsage;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.sql.Timestamp;

public class VenueUsageDatabase {
    public static final String TABLE_NAME = "venue_usage";
    private final Database<VenueUsage> db;

    public VenueUsageDatabase() {
        db = new Database<>(input -> {
            Timestamp checkOut = input.getTimestamp("check_out");
            return new VenueUsage(
                input.getInt("id"), 
                input.getTimestamp("check_in").toInstant(),
                checkOut != null ? checkOut.toInstant() : null,
                input.getString("member_comments"), 
                input.getString("staff_remarks")
            );
        });
    }

    public VenueUsage queryById(int id) {
        return db.queryById(id, "venue_usage");
    }

    @Nullable
    public VenueUsage queryByBookingId(int bookingId) {
        var q = db.queryByIntColumn(TABLE_NAME, "booking_id", bookingId);
        if (q.isEmpty())
            return null;
        return q.get(0);
    }

    public VenueUsage add(int bookingId) {
        VenueUsage venueUsage;
        try {
            var s = db.getConnection().prepareStatement("insert into venue_usage (booking_id) value (?);");
            s.setInt(1, bookingId);
            int id = db.insertRow(s, TABLE_NAME);
            venueUsage = queryById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return venueUsage;
    }

    public void checkout(int id) {
        try {
            var s = db.getConnection().prepareStatement("update venue_usage set check_out = now() where id = ?;");
            s.setInt(1, id);
            s.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateMemberComment(int id, String comment) {
        try {
            var s = db.getConnection().prepareStatement("update venue_usage set member_comments = ? where id = ?;");
            s.setString(1, comment);
            s.setInt(2, id);
            s.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateStaffRemarks(int id, String remarks) {
        try {
            var s = db.getConnection().prepareStatement("update venue_usage set staff_remarks = ? where id = ?;");
            s.setString(1, remarks);
            s.setInt(2, id);
            s.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
