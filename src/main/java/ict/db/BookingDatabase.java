package ict.db;

import ict.data_objects.entities.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookingDatabase {
    final Database<Booking> db;

    public BookingDatabase() {
        db = new Database<>(resultSet -> new Booking(
                resultSet.getInt("id"),
                new MemberDatabase().queryById(resultSet.getInt("booker_id")),
                new BookingRequestResponseDatabase().queryById(resultSet.getInt("booking_request_response_id")),
                new TimeSlotDatabase().queryById(resultSet.getInt("timeslot_id")),
                new VenueDatabase().queryById(resultSet.getInt("venue_id")),
                new VenueUsageDatabase().queryById(resultSet.getInt("venue_usage_id")),
                DateTimeToInstantConverter.convert(resultSet, "requested_on")
            )
        );
    }

    public List<Booking> queryByBookingMemberId(int bookingMemberId) {
        List<Booking> list;
        try {
            PreparedStatement statement = db.getConnection().prepareStatement("select * from booking where booker_id = ?;");
            statement.setInt(1, bookingMemberId);
            list = db.query(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int add(Member booker, Timeslot timeslot, Venue venue) {
        int id;
        try {
            String sql = "insert into booking (booker_id, timeslot_id, venue_id) value (?,?,?);";
            PreparedStatement s = db.getConnection().prepareStatement(sql);
            s.setInt(1, booker.getId());
            s.setInt(2, timeslot.getId());
            s.setInt(3, venue.getId());
            id = db.insertRow(s, "booking");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}

