package ict.service.login_session;

import ict.data_objects.non_entties.UserType;
import jakarta.servlet.http.HttpServletRequest;

public class LoggedInUserChecker {
    public HttpServletRequest request;

    public LoggedInUserChecker(HttpServletRequest request) {
        this.request = request;
    }

    public boolean checkIsLoggedInAndOfType(UserType targetType) {
        var session = new LoginSessionManager(request).getSession();
        if (session == null) return false;
        return session.userType == targetType;
    }
}
