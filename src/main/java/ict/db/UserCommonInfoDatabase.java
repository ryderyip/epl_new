package ict.db;

import ict.data_objects.entities.UserCommonInfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserCommonInfoDatabase implements DbInsert<UserCommonInfo> {
    public static final String TABLE_NAME = "user_common_info";
    private final Database<UserCommonInfo> db;

    public UserCommonInfoDatabase() {
        this.db = new Database<>(UserCommonInfo::fromResultSet);
    }
    
    public UserCommonInfo queryById(int id) {
        return db.queryById(id, "user_common_info");
    }

    public int add(UserCommonInfo info) {
        PreparedStatement statement;
        int id;
        try {
            String sql = "insert into user_common_info (name, gender, phone, email, username, password) value (?,?,?,?,?,?)";
            statement = db.getConnection().prepareStatement(sql);
            statement.setString(1, info.getName());
            statement.setString(2, info.getGender().getShortName());
            statement.setString(3, info.getPhone());
            statement.setString(4, info.getEmail());
            statement.setString(5, info.getUsername());
            statement.setString(6, info.getPassword());
            id = db.insertRow(statement, TABLE_NAME);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        info.setId(id);
        return id;
    }

    public List<UserCommonInfo> queryByEmail(String email) {
        return db.queryByStringColumn(TABLE_NAME, "email", email);
    }

    public List<UserCommonInfo> queryByPhone(String phone) {
        return db.queryByStringColumn(TABLE_NAME, "phone", phone);
    }

    public List<UserCommonInfo> queryByUsername(String username) {
        return db.queryByStringColumn(TABLE_NAME, "username", username);
    }

    public void update(int infoId, UserCommonInfo info) {
        // not gonna set password here
        try {
            String sql = "update user_common_info set name=?,gender=?,phone=?,email=?,username=? where id = ?;";
            var s = db.getConnection().prepareStatement(sql);
            s.setString(1, info.getName());
            s.setString(2, info.getGender().getShortName());
            s.setString(3, info.getPhone());
            s.setString(4, info.getEmail());
            s.setString(5, info.getUsername());
            s.setInt(6, infoId);
            s.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
