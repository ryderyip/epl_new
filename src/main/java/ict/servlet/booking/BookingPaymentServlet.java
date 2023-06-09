package ict.servlet.booking;

import ict.data_objects.non_entties.UserType;
import ict.db.BookingDatabase;
import ict.service.login_session.LoggedInUserChecker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/booking/payment/pay"})
public class BookingPaymentServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!new LoggedInUserChecker(request).checkIsLoggedInAndOfType(UserType.MEMBER)) {
            request.getRequestDispatcher("/loginSessionError.jsp").forward(request, response);
            return;
        }

        int id = Integer.parseInt(request.getParameter("bookingId"));
        BookingDatabase bookingDatabase = new BookingDatabase();
        var booking = bookingDatabase.queryById(id);

        String receipt = request.getParameter("receipt");
        
        assert booking.getBookingRequestResponse() != null;
        booking.getBookingRequestResponse().getApprovedDetails().setPaymentReceipt(receipt);
        bookingDatabase.update(booking);
        
        String destination = "/user/member/booking_details.jsp?id=" + booking.getId();
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
