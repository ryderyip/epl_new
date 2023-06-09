package ict.db;

import ict.data_objects.entities.Venue;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VenueDatabase {
    final Database<Venue> db;

    public VenueDatabase() {
        db = new Database<>(rs -> new Venue(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("location"),
                rs.getBoolean("available"),
                rs.getString("description"),
                rs.getString("type"),
                rs.getInt("capacity"),
                new BookingFeeDatabase().queryByVenueId(rs.getInt("id"))
            ));
    }
    
    public List<Venue> query() {
        List<Venue> list;
        try {
            PreparedStatement statement = db.getConnection().prepareStatement("SELECT * FROM venue;");
            list = db.query(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Venue> queryByInChargeStaffId(int staffId) {
        List<Venue> list;
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(
                    "SELECT * FROM venue " +
                            "join staff_venues_in_charge svic on venue.id = svic.venue_id " +
                            "where svic.id = ?;");
            statement.setInt(1, staffId);
            list = db.query(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Venue queryById(int id) {
        return db.queryById(id, "venue");
    }
    
    public List<Venue> queryAvailableVenues() {
        List<Venue> list;
        try {
            PreparedStatement statement = db.getConnection().prepareStatement("SELECT * FROM venue where available = true;");
            list = db.query(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void update(Venue venue) {
        new BookingFeeDatabase().addMany(venue.getId(), venue.getBookingFees());
        try {
            String sql = "update venue set name = ?, type = ?, description = ?, location = ?, capacity = ?, available = ? where id = ?";
            var s =  db.getConnection().prepareStatement(sql);
            s.setString(1, venue.getName());
            s.setString(2, venue.getType());
            s.setString(3, venue.getDescription());
            s.setString(4, venue.getLocation());
            s.setInt(5, venue.getCapacity());
            s.setBoolean(6, venue.isAvailable());
            s.setInt(7, venue.getId());
            s.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
