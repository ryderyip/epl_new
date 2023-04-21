package ict.db;

import ict.data_objects.entities.UserCommonInfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCommonInfoDatabase implements DbInsert<UserCommonInfo> {
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
            id = db.insertRow(statement, "user_common_info");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        info.setId(id);
        return id;
    }
}
