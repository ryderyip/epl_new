package ict.servlet.booking;

import ict.db.BookingDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/booking/get"})
public class GetBookingsServlet extends HttpServlet {
    private BookingDatabase db;

    public void init() {
        db = new BookingDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null)
            getAll(request, response);
        else
            getById(request, response, id);
    }

    private void getById(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        var booking = db.queryById(Integer.parseInt(id));
        request.setAttribute("booking", booking);
        String destination = "/user/staff/booking_detail.jsp";
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var bookings = db.query();
        request.setAttribute("bookings", bookings);
        String destination = "/user/staff/booking_list.jsp";
        request.getRequestDispatcher(destination).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
