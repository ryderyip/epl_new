package ict.servlet.booking;

import ict.data_objects.non_entties.UserType;
import ict.db.BookingDatabase;
import ict.service.ErrorMessageWritingService;
import ict.service.login_session.LoginSessionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/booking/get"})
public class GetBookingsServlet extends HttpServlet {
    private BookingDatabase db;
    private UserType userType;

    public void init() {
        db = new BookingDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var s = new LoginSessionManager(request).getSession();
        if (s == null) {
            ErrorMessageWritingService.write(response, "No login session", "Please login first");
            return;
        }
        userType = s.userType;
        
        String id = request.getParameter("id");
        if (id == null)
            getAll(request, response);
        else
            getById(request, response, id);
    }

    private void getById(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
        var booking = db.queryById(Integer.parseInt(id));
        request.setAttribute("booking", booking);
        String destination = userType != UserType.MEMBER 
                ? "/user/staff/booking_detail.jsp"
                : "/user/member/booking_details.jsp";
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var bookings = db.query();
        request.setAttribute("bookings", bookings);
        String destination = userType != UserType.MEMBER 
                ? "/user/staff/booking_list.jsp"
                : "/user/member/booking_list.jsp";
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
