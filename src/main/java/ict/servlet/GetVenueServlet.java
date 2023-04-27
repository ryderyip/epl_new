package ict.servlet;

import ict.data_objects.entities.Venue;
import ict.db.VenueDatabase;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/venue/get"})
public class GetVenueServlet extends HttpServlet {
    private VenueDatabase db;

    public void init() {
        db = new VenueDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null)
            getAllVenues(request, response);
        else
            getById(request, response, id);
    }

    private void getById(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        Venue venue = db.queryById(Integer.parseInt(id));
        request.setAttribute("venue", venue);
        String redirect = request.getParameter("redirect");
        String destination = redirect != null ? redirect : "/user/staff/venue_detail.jsp";
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private void getAllVenues(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Venue> venues = db.query();
        request.setAttribute("venues", venues);
        String destination = "/user/staff/venue_management.jsp";
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
