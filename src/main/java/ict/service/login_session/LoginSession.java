package ict.service.login_session;

import ict.data_objects.non_entties.UserType;
import org.jetbrains.annotations.NotNull;

public class LoginSession {
    @NotNull
    public String userId;
    @NotNull
    public UserType userType;

    public LoginSession(@NotNull String userId, @NotNull UserType userType) {
        this.userId = userId;
        this.userType = userType;
    }
}
