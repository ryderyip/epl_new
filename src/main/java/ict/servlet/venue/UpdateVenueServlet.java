package ict.servlet.venue;

import ict.data_objects.entities.BookingFee;
import ict.data_objects.non_entties.UserType;
import ict.db.VenueDatabase;
import ict.service.ErrorMessageWritingService;
import ict.service.login_session.LoggedInUserChecker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/venue/update"})
public class UpdateVenueServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var checker = new LoggedInUserChecker(request);
        if (!checker.checkIsLoggedInAndOfType(UserType.MANAGER) && !checker.checkIsLoggedInAndOfType(UserType.STAFF)) {
            ErrorMessageWritingService.write(response, "Wrong user type", "You must be a staff to execute this action");
            return;
        }
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        VenueDatabase database = new VenueDatabase();
        var venue = database.queryById(id);
        
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        String location = request.getParameter("location");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        boolean available = request.getParameter("available").equalsIgnoreCase("T");
        List<BookingFee> bookingFees = getBookingFees(request);
        
        venue.setName(name);
        venue.setType(type);
        venue.setDescription(description);
        venue.setLocation(location);
        venue.setCapacity(capacity);
        venue.setBookingFees(bookingFees);
        venue.setAvailable(available);
        database.update(venue);

        String destination = "/user/staff/venue_detail.jsp";
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private List<BookingFee> getBookingFees(HttpServletRequest request) {
        String[] hourlyRates = request.getParameterValues("hourlyRates[]");
        String[] years = request.getParameterValues("years[]");
        assert hourlyRates.length != years.length;
        List<BookingFee> list = new ArrayList<>();
        for (int i = 0; i < hourlyRates.length; i++)
            list.add(new BookingFee(-1, Double.parseDouble(hourlyRates[i]), Integer.parseInt(years[i])));
        return list;
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
