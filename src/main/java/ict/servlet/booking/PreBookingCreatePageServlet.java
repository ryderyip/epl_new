package ict.servlet.booking;

import ict.data_objects.entities.Venue;
import ict.data_objects.non_entties.UserType;
import ict.db.VenueDatabase;
import ict.service.login_session.LoginSessionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/prebooking_create"})
public class PreBookingCreatePageServlet extends HttpServlet {
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VenueDatabase db = new VenueDatabase();
        
        List<Venue> availableVenues = db.queryAvailableVenues();
        request.setAttribute("venues", availableVenues);
        System.out.println(availableVenues.size());

        var session = new LoginSessionManager(request).getSession();
        if (session == null) {
            request.getRequestDispatcher("loginSessionError.jsp").forward(request, response);
            return;
        }
        if (session.userType != UserType.MEMBER){
            request.setAttribute("errorMessage", "Only members can book a venue. Currently logged in as " +
                    (session.userType == UserType.STAFF ? "Staff" : "Administrator"));
            response.sendRedirect(request.getHeader("referer"));
            return;
        }
        request.setAttribute("memberId", session.userId);
        
        String destination = "/user/member/booking_create.jsp";
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
