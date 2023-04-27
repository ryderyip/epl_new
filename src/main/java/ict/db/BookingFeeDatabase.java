package ict.db;

import ict.data_objects.entities.BookingFee;
import org.jetbrains.annotations.Nullable;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
}
