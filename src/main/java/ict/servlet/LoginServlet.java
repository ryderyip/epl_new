package ict.servlet;

import ict.data_objects.entities.Member;
import ict.data_objects.entities.Staff;
import ict.data_objects.entities.User;
import ict.data_objects.non_entties.UserType;
import ict.data_objects.non_entties.UserTypeIdentifier;
import ict.db.UserDatabase;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private UserDatabase db;

    public void init() {
        db = new UserDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        List<User> members = db.query();
        List<User> q = members.stream().filter(matchUsernameAndPassword(username, password)).toList();

        boolean loginSuccess = !q.isEmpty();
        String destination;
        if (!loginSuccess) {
            request.getRequestDispatcher("/loginError.jsp").forward(request, response);
            return;
        }

        UserType userType = UserTypeIdentifier.identify(q.get(0));
        if (userType == UserType.MEMBER) destination = "/user/member/member_frontpage.jsp";
        else if (userType == UserType.STAFF) destination = "/user/staff/staff_frontpage.jsp";
        else if (userType == UserType.MANAGER) destination = "/user/manager/manager_frontpage.jsp";
        else throw new RuntimeException("Invalid user type");
        response.sendRedirect(request.getContextPath() + destination);
    }

    @NotNull
    private static Predicate<User> matchUsernameAndPassword(String username, String password) {
        return member -> member.getInfo().getUsername().equals(username) && member.getInfo().getPassword().equals(password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
