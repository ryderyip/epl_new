package ict.servlet.booking;

import ict.data_objects.entities.Booking;
import ict.data_objects.entities.BookingApprovedDetails;
import ict.data_objects.entities.VenueUsage;
import ict.data_objects.non_entties.UserType;
import ict.db.BookingApprovedDetailsDatabase;
import ict.db.BookingDatabase;
import ict.db.VenueUsageDatabase;
import ict.service.ErrorMessageWritingService;
import ict.service.login_session.LoggedInUserChecker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/booking/update/staff"})
public class StaffUpdateBookingServlet extends HttpServlet {
    private Booking booking;
    private BookingApprovedDetails details;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!new LoggedInUserChecker(request).checkIsLoggedInAndOfType(UserType.STAFF)) {
            request.getRequestDispatcher("/loginSessionError.jsp").forward(request, response);
            return;
        }

        int id = Integer.parseInt(request.getParameter("bookingId"));
        BookingDatabase bookingDatabase = new BookingDatabase();
        booking = bookingDatabase.queryById(id);
        
        assert booking.getBookingRequestResponse() != null;
        details = booking.getBookingRequestResponse().getApprovedDetails();
        
        String action = request.getParameter("action");
        if (action == null) {
            ErrorMessageWritingService.write(response, "No action specified", "no action specified");
            return;
        }

        if (action.equalsIgnoreCase("confirmpay"))
            confirmPay(request, response);
        else if (action.equalsIgnoreCase("checkin"))
            checkIn(request, response);
        else if (action.equalsIgnoreCase("checkout"))
            checkout(request, response);
        else if (action.equalsIgnoreCase("remark"))
            remark(request, response);
        
        
        String destination = "/user/member/booking_details.jsp?id=" + booking.getId();
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private void remark(HttpServletRequest request, HttpServletResponse response) {
        String remarks = request.getParameter("remarks");
        assert booking.getVenueUsage() != null;
        assert remarks != null ;
        new VenueUsageDatabase().updateStaffRemarks(booking.getVenueUsage().getId(), remarks);
    }

    private void checkout(HttpServletRequest request, HttpServletResponse response) {
        assert booking.getVenueUsage() != null;
        new VenueUsageDatabase().checkout(booking.getVenueUsage().getId());
    }

    private void checkIn(HttpServletRequest request, HttpServletResponse response) {
        VenueUsage usage = new VenueUsageDatabase().add(booking.getId());
        booking.setVenueUsage(usage);
        new BookingDatabase().update(booking);
    }

    private void confirmPay(HttpServletRequest request, HttpServletResponse response) {
        details.setPaymentConfirmed(true);
        new BookingApprovedDetailsDatabase().update(details);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
