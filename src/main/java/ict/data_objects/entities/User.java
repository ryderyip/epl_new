package ict.data_objects.entities;

import java.io.Serializable;

abstract public class User implements Serializable {
    private int id;
    private UserCommonInfo info;

    public User() {}

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
}
