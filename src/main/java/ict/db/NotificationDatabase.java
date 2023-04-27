package ict.db;

import ict.data_objects.entities.Notification;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class NotificationDatabase {
    final Database<Notification> db;

    public NotificationDatabase() {
        db = new Database<>(resultSet -> new Notification(
                resultSet.getInt("id"),
                new UserCommonInfoDatabase().queryById(resultSet.getInt("user_info_id")),
                resultSet.getString("message"),
                resultSet.getBoolean("seen")
        ));
    }

    public Notification queryById(int id) {
        return db.queryById(id, "notification");
    }

    public void add(Notification notification) {
        String sql = "insert into notification (user_info_id, message) values (?,?);";
        try {
            PreparedStatement s = db.getConnection().prepareStatement(sql);
            s.setInt(1, notification.getInfo().getId());
            s.setString(2, notification.getMessage());
            int id = db.insertRow(s, "notification");
            notification.setId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Notification> queryByUserInfoId(int userInfoId) {
        String sql = "select * from notification where user_info_id = ?;";
        List<Notification> list;
        try {
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            statement.setInt(1, userInfoId);
            list = db.query(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
