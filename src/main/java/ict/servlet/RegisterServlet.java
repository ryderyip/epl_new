package ict.servlet;

import ict.data_objects.entities.Member;
import ict.db.MemberDatabase;
import ict.service.parameter_extractors.EmailUsernamePhoneUniqueChecker;
import ict.service.parameter_extractors.UserCommonInfoExtractor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    private MemberDatabase db;

    public void init() {
        db = new MemberDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var info = UserCommonInfoExtractor.extract(request);
        Member memberData = new Member(-1, info);
        if (!new EmailUsernamePhoneUniqueChecker(info, request, response).checkIsUniqueOrGoErrorPage())
            return;
        
        db.add(memberData);
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
