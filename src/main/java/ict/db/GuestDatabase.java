package ict.db;

import ict.data_objects.entities.Guest;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GuestDatabase {
    public static final String TABLE_NAME = "guest";
    final Database<Guest> db;

    public GuestDatabase() {
        db = new Database<>(input -> new Guest(
                input.getInt("id"),
                input.getString("name"),
                input.getString("email")
        ));
    }

    public List<Guest> queryByBookingId(int bookingId) {
        List<Guest> list;
        try {
            String sql = "select * from guest where booking_id = ?;";
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            statement.setInt(1, bookingId);
            list = db.query(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public void update(Guest guest) {
        String sql = "update guest set name = ?, email = ? where id = ?";
        try {
            var s = db.getConnection().prepareStatement(sql);
            s.setString(1, guest.getName());
            s.setString(2, guest.getEmail());
            s.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void remove(int guestId) {
        db.remove(TABLE_NAME, guestId);
    }
    
    public void add(Guest guest, int bookingId) {
        int id;
        try {
            String sql = "insert into guest (name, email, booking_id) value (?,?,?);";
            PreparedStatement s = db.getConnection().prepareStatement(sql);
            s.setString(1, guest.getName());
            s.setString(2, guest.getEmail());
            s.setInt(3, bookingId);
            id = db.insertRow(s, TABLE_NAME);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        guest.setId(id);
    }

    public void addMany(List<Guest> guests, int bookingId) {
        guests.forEach(guest -> add(guest, bookingId));
    }

    public void removeAllByBookingId(int id) {
        String sql = "DELETE FROM guest where booking_id = ?;";
        try {
            var s = db.getConnection().prepareStatement(sql);
            s.setInt(1, id);
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
