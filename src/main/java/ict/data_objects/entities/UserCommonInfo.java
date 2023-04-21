package ict.data_objects.entities;

import java.sql.*;

public class UserCommonInfo implements SQLData {
    private int id;
    private String name;
    private String email;
    private Gender gender;
    private String password;
    private String phone;
    private String username;

    public UserCommonInfo(int id, String name, String email, Gender gender, String password, String phone, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.phone = phone;
        this.username = username;
    }

    public static UserCommonInfo fromResultSet(ResultSet resultSet) throws SQLException {
        return new UserCommonInfo(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("email"),
            Gender.valueOf(resultSet.getString("gender")),
            resultSet.getString("password"),
            resultSet.getString("phone"),
            resultSet.getString("username")
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return null;
    }

    @Override
    public void readSQL(SQLInput sqlInput, String s) throws SQLException {

    }

    @Override
    public void writeSQL(SQLOutput sqlOutput) throws SQLException {

    }
}

