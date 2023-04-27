package ict.db;

import ict.data_objects.entities.Staff;
import ict.data_objects.entities.StaffRole;
import ict.data_objects.entities.Venue;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StaffDatabase {
    final Database<Staff> db;

    public StaffDatabase() {
        this.db = new Database<>(resultSet -> new Staff(
                resultSet.getInt("id"),
                new UserCommonInfoDatabase().queryById(resultSet.getInt("info_id")),
                new VenueDatabase().queryByInChargeStaffId(resultSet.getInt("id")),
                resultSet.getString("role").equals("J") ? StaffRole.NORMAL : StaffRole.SENIOR
        ));
    }

    public List<Staff> query() {
        List<Staff> list;
        try {
            PreparedStatement s = db.getConnection().prepareStatement("SELECT * FROM staff;");
            list = db.query(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Staff queryById(int id) {
        return db.queryById(id, "staff");
    }
}
