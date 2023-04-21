package ict.servlet;

import ict.data_objects.entities.Venue;
import ict.db.VenueDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/venue/get_by_id"})
public class GetVenueByIdServlet extends HttpServlet {
    private VenueDatabase db;

    public void init() {
        db = new VenueDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Venue venue = db.queryById(Integer.parseInt(request.getParameter("venue_id")));
        request.setAttribute("venue", venue);
        String destination = "/user/staff/venue_detail.jsp";
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
