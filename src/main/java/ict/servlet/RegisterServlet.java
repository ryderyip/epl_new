package ict.servlet;

import ict.data_objects.entities.Gender;
import ict.data_objects.entities.Member;
import ict.data_objects.entities.User;
import ict.data_objects.entities.UserCommonInfo;
import ict.data_objects.non_entties.UserType;
import ict.data_objects.non_entties.UserTypeIdentifier;
import ict.db.MemberDatabase;
import ict.db.UserDatabase;
import ict.service.login.LoginSystem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    private MemberDatabase db;

    public void init() {
        db = new MemberDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        if (!request.getParameter("gender").equals("male") && !request.getParameter("gender").equals("female")) {
            goErrorPage("Gender form post parameter can only be male or female", request,  response);
            return;
        }
        Gender gender = Objects.equals(request.getParameter("gender"), "male") ? Gender.M : Gender.F;
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        var info = new UserCommonInfo(-1, name, email, gender, password, phone, username);
        Member memberData = new Member(-1, info);
        
        if (db.queryByEmail(email) != null) {
            goErrorPage("Member with email " + email + " already exists", request, response);
            return;
        }
        if (db.queryByUsername(username) != null) {
            goErrorPage("Member with username " + username + " already exists", request, response);
            return;
        }
        if (db.queryByPhone(phone) != null) {
            goErrorPage("Member with phone " + phone + " already exists", request, response);
            return;
        }
        
        db.add(memberData);
        new LoginSystem().login(username, password, request, response);
    }
    
    private void goErrorPage(String errorMessage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("/registerError.jsp").forward(request, response);
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
