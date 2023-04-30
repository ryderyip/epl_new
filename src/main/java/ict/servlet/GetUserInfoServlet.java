package ict.servlet;

import ict.db.UserCommonInfoDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/userInfo/get"})
public class GetUserInfoServlet extends HttpServlet {
    private UserCommonInfoDatabase db;

    public void init() {
        db = new UserCommonInfoDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        assert id != null;


        /*UserCommonInfo info = db.queryById(Integer.parseInt(id));
        request.setAttribute("info", info);
        String destination = "/user/manager/staff_details.jsp";
        request.getRequestDispatcher(destination).forward(request, response);*/
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
