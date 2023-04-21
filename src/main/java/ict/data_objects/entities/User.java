package ict.data_objects.entities;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

abstract public class User implements SQLData {
    private int id;
    private UserCommonInfo info;
    private String sql_type;

    public User(int id, UserCommonInfo info) {
        this.id = id;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserCommonInfo getInfo() {
        return info;
    }

    public void setInfo(UserCommonInfo info) {
        this.info = info;
    }

    @Override
    public String getSQLTypeName() {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String type) throws SQLException {
        sql_type = type;
        setId(sqlInput.readInt());
        setInfo(sqlInput.readObject(UserCommonInfo.class));
    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {
        sqlOutput.writeInt(getId());
        sqlOutput.writeObject(getInfo());
    }
}
