package ict.service.login;

import ict.data_objects.non_entties.UserType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberPageRedirector {
    public void redirect(UserType userType, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination;
        if (userType == UserType.MEMBER) destination = "/user/member/member_frontpage.jsp";
        else if (userType == UserType.STAFF) destination = "/user/staff/staff_frontpage.jsp";
        else if (userType == UserType.MANAGER) destination = "/user/manager/manager_frontpage.jsp";
        else throw new RuntimeException("Invalid user type");
        request.getRequestDispatcher(destination).forward(request, response);
    }
}
