package ict.servlet;

import ict.db.MemberDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/member/get"})
public class GetMemberServlet extends HttpServlet {
    private MemberDatabase db;

    public void init() {
        db = new MemberDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null)
            getAll(request, response);
        else
            getById(request, response, id);
    }

    private void getById(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        var member = db.queryById(Integer.parseInt(id));
        request.setAttribute("member", member);
        String destination = "/user/manager/member_details.jsp";
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var members = db.queryMembers();
        request.setAttribute("members", members);
        String destination = "/user/manager/member_management.jsp";
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
