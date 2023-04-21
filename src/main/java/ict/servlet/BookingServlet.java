package ict.servlet;

import ict.data_objects.entities.Booking;
import ict.db.BookingDatabase;
import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/booking"})
public class BookingServlet extends HttpServlet {
    private BookingDatabase db;

    public void init() {
        db = new BookingDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action.equals("getByMemberId")) {
            String memberId = request.getParameter("memberId");
            List<Booking> bookings = db.queryByBookingMemberId(Integer.parseInt(memberId));
            
        }

        /*List<User> members = db.query();
        List<User> q = members.stream().filter(member -> member.getInfo().getUsername().equals(username) && member.getInfo().getPassword().equals(password))    .collect(Collectors.toList());

        boolean loginSuccess = !q.isEmpty();
        String destination;
        if (!loginSuccess) destination = "/loginError.jsp";
        
        request.getRequestDispatcher(destination).forward(request, response);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
         {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        {
        processRequest(request, response);
    }
}
