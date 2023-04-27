package ict.db;

import ict.data_objects.entities.Timeslot;
import ict.service.InstantParser;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

public class TimeSlotDatabase {
    private final Database<Timeslot> db;

    public TimeSlotDatabase() {
        db = new Database<>(rs -> new Timeslot(
            rs.getInt("id"),
            InstantParser.parseInstantFromDatabase(rs.getString("begin_time")),
            InstantParser.parseInstantFromDatabase(rs.getString("end_time"))
        ));
    }

    public Timeslot queryById(int id) {
        return db.queryById(id, "timeslot");
    }
    
    public Timeslot add(Instant beginTime, Instant endTime) {
        var sql = "insert into timeslot (begin_time, end_time) value (?,?);";
        int id;
        try {
            var s = db.getConnection().prepareStatement(sql);
//            s.setString(1, DATETIME_FORMAT.format(beginTime));
//            s.setString(2, DATETIME_FORMAT.format(endTime));
            s.setObject(1, beginTime);
            s.setObject(2, endTime);
            id = db.insertRow(s, "timeslot");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return queryById(id);
    }
    
    public List<Timeslot> queryByVenueDate(int venueId, Instant date) {
        String sql = "select * from timeslot inner join booking b on timeslot.id = b.timeslot_id " +
                "where begin_time between ? and ? " +
                "and venue_id = ?;";
        Instant dayAfterDate = date.plusSeconds(86400);
        List<Timeslot> list;
        try {
            var s = db.getConnection().prepareStatement(sql);
            s.setObject(1, date);
            s.setObject(2, dayAfterDate);
            s.setInt(3, venueId);
            list = db.query(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
