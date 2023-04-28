package ict.db;

import ict.data_objects.entities.BookingFee;
import org.jetbrains.annotations.Nullable;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookingFeeDatabase {
    public static final String TABLE_NAME = "booking_fee";
    private final Database<BookingFee> db;

    public BookingFeeDatabase() {
        this.db = new Database<>(rs -> new BookingFee(
                rs.getInt("id"),
                rs.getDouble("hourly_rate"),
                rs.getInt("year")
        ));
    }

    public BookingFee queryById(int bookingFeeId) {
        return db.queryById(bookingFeeId, TABLE_NAME);
    }

    @Nullable
    public BookingFee queryByVenueIdYear(int venueId, int year) {
        String sql = "select * from booking_fee where venue_id = ? and year = ?;";
        List<BookingFee> list;
        try {
            PreparedStatement s = db.getConnection().prepareStatement(sql);
            s.setInt(1, venueId);
            s.setInt(2, year);
            list = db.query(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list.isEmpty() ? null : list.get(0);
    }

    public List<BookingFee> queryByVenueId(int venueId) {
        return db.queryByIntColumn(TABLE_NAME, "venue_id", venueId);
    }

    private void add(int venueId, BookingFee bookingFee) {
        try {
            String sql = "insert into booking_fee (hourly_rate, year, venue_id) value (?,?,?);";
            var s = db.getConnection().prepareStatement(sql);
            s.setDouble(1, bookingFee.getHourlyRate());
            s.setInt(2, bookingFee.getYear());
            s.setInt(3, venueId);
            int id = db.insertRow(s, TABLE_NAME);
            bookingFee.setId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void addMany(int venueId, List<BookingFee> bookingFees) {
        try {
            String sql = "delete from booking_fee where venue_id = ?;";
            var s = db.getConnection().prepareStatement(sql);
            s.setInt(1, venueId);
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bookingFees.forEach(bookingFee -> add(venueId, bookingFee));
    }
}
