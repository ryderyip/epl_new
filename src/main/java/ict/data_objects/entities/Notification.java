package ict.data_objects.entities;

public class Notification {
    private int id;
    private UserCommonInfo info;
    private String message;
    private boolean seen;

    public Notification(UserCommonInfo info, String message, boolean seen) {
        this.info = info;
        this.message = message;
        this.seen = seen;
    }

    public Notification(int id, UserCommonInfo info, String message, boolean seen) {
        this.id = id;
        this.info = info;
        this.message = message;
        this.seen = seen;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
}
