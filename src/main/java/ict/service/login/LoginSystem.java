package ict.service.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * get parameters from request, try login, failed go error page, success go user page.
 */
public class LoginSystem {
    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginResult result = new LoginService().attemptLogin(username, password);
        if (!result.success) {
            request.getRequestDispatcher("/loginError.jsp").forward(request, response);
            return;
        }
        new MemberPageRedirector().redirect(result.userType, request, response);
    }
}
