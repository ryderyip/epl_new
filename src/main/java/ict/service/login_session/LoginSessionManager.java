package ict.service.login_session;


import ict.data_objects.non_entties.UserType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.Nullable;

public class LoginSessionManager {
    public static final String USER_TYPE_ID_KEY = "session/userTypeId";
    public static final String USER_ID_KEY = "session/userId";
    public HttpServletRequest request;

    public LoginSessionManager(HttpServletRequest request) {
        this.request = request;
    }

    public void setSession(int userId, UserType userType) {
        HttpSession session = request.getSession();
        session.setAttribute(USER_ID_KEY, String.valueOf(userId));
        session.setAttribute(USER_TYPE_ID_KEY, userType.id);
    }
    
    @Nullable
    public LoginSession getSession() {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute(USER_ID_KEY);
        String userTypeId = (String) session.getAttribute(USER_TYPE_ID_KEY);
        if (userId == null || userTypeId == null) {
            if (userId == null) System.out.println("userId is null");
            else System.out.println("userTypeId is null");
            return null;
        }
        
        UserType userType = UserType.fromInt(userTypeId);
        return new LoginSession(userId, userType);
    }
}
