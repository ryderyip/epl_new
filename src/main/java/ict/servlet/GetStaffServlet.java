package ict.servlet;

import ict.db.StaffDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/staff/get"})
public class GetStaffServlet extends HttpServlet {
    private StaffDatabase db;

    public void init() {
        db = new StaffDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null)
            getAll(request, response);
        else
            getById(request, response, id);
    }

    private void getById(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        var staff = db.queryById(Integer.parseInt(id));
        request.setAttribute("staff", staff);
        String destination = "/user/manager/staff_details.jsp";
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var staffs = db.query();
        request.setAttribute("staffs", staffs);
        String destination = "/user/manager/staff_management.jsp";
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
