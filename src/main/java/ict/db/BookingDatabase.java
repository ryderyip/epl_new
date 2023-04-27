package ict.db;

import ict.data_objects.entities.Booking;
import ict.data_objects.entities.Guest;
import ict.data_objects.entities.Timeslot;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookingDatabase {
    public static final String TABLE_NAME = "booking";
    final Database<Booking> db;

    public BookingDatabase() {
        db = new Database<>(resultSet -> new Booking(
                resultSet.getInt("id"),
                new MemberDatabase().queryById(resultSet.getInt("booker_id")),
                new TimeSlotDatabase().queryById(resultSet.getInt("timeslot_id")),
                new VenueDatabase().queryById(resultSet.getInt("venue_id")),
                resultSet.getTimestamp("requested_on").toInstant(),
                new BookingRequestResponseDatabase().queryByBookingId(resultSet.getInt("id")),
                new VenueUsageDatabase().queryByBookingId(resultSet.getInt("id")),
                new GuestDatabase().queryByBookingId(resultSet.getInt("id"))
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

    public Booking add(int bookerId, Timeslot timeslot, int venueId, List<Guest> guests) {
        int id;
        try {
            String sql = "insert into booking (booker_id, timeslot_id, venue_id) value (?,?,?);";
            PreparedStatement s = db.getConnection().prepareStatement(sql);
            s.setInt(1, bookerId);
            s.setInt(2, timeslot.getId());
            s.setInt(3, venueId);
            id = db.insertRow(s, TABLE_NAME);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        new GuestDatabase().addMany(guests, id);
        return queryById(id);
    }

    public Booking queryById(int id) {
        return db.queryById(id, TABLE_NAME);
    }

    public List<Booking> queryByVenueId(int venueId) {
        return db.queryByIntColumn(TABLE_NAME, "venue_id", venueId);
    }

    public List<Booking> query() {
        List<Booking> list;
        try {
            PreparedStatement s = db.getConnection().prepareStatement("SELECT * FROM booking;");
            list = db.query(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}

