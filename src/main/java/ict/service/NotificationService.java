package ict.service;

import ict.data_objects.entities.Notification;
import ict.data_objects.entities.UserCommonInfo;
import ict.db.NotificationDatabase;
import ict.db.UserCommonInfoDatabase;

import java.util.List;

public class NotificationService {
    private final NotificationDatabase db = new NotificationDatabase();

    public void register(int userInfoId, String message) {
        UserCommonInfo userInfo = new  UserCommonInfoDatabase().queryById(userInfoId);
        Notification noty = new Notification(userInfo, message, false);
        db.add(noty);
    }

    public List<Notification> getNotifications(int userInfoId) {
        return db.queryByUserInfoId(userInfoId);
    }
}
