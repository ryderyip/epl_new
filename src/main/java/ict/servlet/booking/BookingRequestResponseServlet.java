package ict.servlet.booking;

import ict.data_objects.entities.BookingFee;
import ict.data_objects.non_entties.UserType;
import ict.db.BookingDatabase;
import ict.db.BookingFeeDatabase;
import ict.service.BookingRequestResponseService;
import ict.service.ErrorMessageWritingService;
import ict.service.login_session.LoggedInUserChecker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Year;

@WebServlet(urlPatterns = {"/booking/response"})
public class BookingRequestResponseServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("id"));
        String bookingResponse = request.getParameter("response");
        if (!bookingResponse.equals("approve") && !bookingResponse.equals("decline")){
            ErrorMessageWritingService.write(response, "Post parameter error", "booking request response must be 'approve' or 'decline'");
            return;
        }

        LoggedInUserChecker checker = new LoggedInUserChecker(request);
        if (!checker.checkIsLoggedInAndOfType(UserType.MANAGER) && !checker.checkIsLoggedInAndOfType(UserType.STAFF)) {
            ErrorMessageWritingService.write(response, "Wrong user type", "You must be a staff to execute this action");
            return;
        }
        
        boolean responseSuccess;
        if (bookingResponse.equals("approve"))
            responseSuccess = approveBooking(bookingId, response);
        else
            responseSuccess = declineBooking(bookingId);
        if (!responseSuccess) return;

        String destination = "/user/member/my_booking.jsp";
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private boolean declineBooking(int bookingId) {
        new BookingRequestResponseService(bookingId).decline();
        return true;
    }

    private boolean approveBooking(int bookingId, HttpServletResponse response) {
        var booking = new BookingDatabase().queryById(bookingId);
        BookingFee fee = new BookingFeeDatabase().queryByVenueIdYear(booking.getVenue().getId(), Year.now().getValue());
        if (fee == null) {
            ErrorMessageWritingService.write(response, "Cannot approve booking", "Booking fee of year "+Year.now().getValue()+" for " + booking.getVenue().getName() + " has not been set.");
            return false;
        }

        new BookingRequestResponseService(bookingId).approve(fee);
        return true;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
