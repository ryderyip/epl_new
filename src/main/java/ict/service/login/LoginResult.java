package ict.service.login;

import ict.data_objects.non_entties.UserType;
import org.jetbrains.annotations.Nullable;

public class LoginResult {
    public boolean success;
    @Nullable
    public UserType userType;
    @Nullable
    public Integer userId;

    public LoginResult(boolean success, @Nullable UserType userType, @Nullable Integer userId) {
        this.success = success;
        this.userType = userType;
        this.userId = userId;
    }
}
