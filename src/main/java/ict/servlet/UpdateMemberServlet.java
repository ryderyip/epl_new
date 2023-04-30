package ict.servlet;

import ict.data_objects.non_entties.UserType;
import ict.db.MemberDatabase;
import ict.db.UserCommonInfoDatabase;
import ict.service.login_session.LoggedInUserChecker;
import ict.service.parameter_extractors.EmailUsernamePhoneUniqueChecker;
import ict.service.parameter_extractors.UserCommonInfoExtractor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/member/update"})
public class UpdateMemberServlet extends HttpServlet {
    private MemberDatabase db;

    public void init() {
        db = new MemberDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!new LoggedInUserChecker(request).checkIsLoggedInAndOfType(UserType.MANAGER)) {
            request.getRequestDispatcher("/loginSessionError.jsp").forward(request, response);
            return;
        }
        var member = db.queryById(Integer.parseInt(request.getParameter("memberId")));
        var info = UserCommonInfoExtractor.extract(request);
        
        if (!new EmailUsernamePhoneUniqueChecker(info, request, response, member.getInfo().getId()).checkIsUniqueOrGoErrorPage())
            return;

        new UserCommonInfoDatabase().update(member.getInfo().getId(), info);

        String destination = "/user/manager/member_details.jsp?id=" + member.getId();
        request.getRequestDispatcher(destination).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
