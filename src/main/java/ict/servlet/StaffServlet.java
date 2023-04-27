package ict.servlet;

import ict.data_objects.entities.Venue;
import ict.db.StaffDatabase;
import ict.db.VenueDatabase;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = {"/staff/get"})
public class StaffServlet extends HttpServlet {
    private StaffDatabase db;

    public void init() {
        db = new StaffDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null)
            getAllVenues(request, response);
        else
            getById(request, response, id);
    }

    private void getById(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        var staff = db.queryById(Integer.parseInt(id));
        request.setAttribute("staff", staff);
        String destination = "/user/manager/staff_details.jsp";
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private void getAllVenues(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
