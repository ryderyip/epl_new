package ict.servlet.booking;

import ict.data_objects.entities.Booking;
import ict.data_objects.entities.Timeslot;
import ict.data_objects.entities.Venue;
import ict.db.BookingDatabase;
import ict.db.TimeSlotDatabase;
import ict.db.VenueDatabase;
import ict.service.CheckTimeslotAvailableService;
import ict.service.ErrorMessageWritingService;
import ict.service.InstantParser;
import ict.service.parameter_extractors.GuestsExtractor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

@WebServlet(urlPatterns = {"/booking/create"})
public class BookingCreateServlet extends HttpServlet {
    private BookingDatabase db;

    public void init() {
        db = new BookingDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int memberId = Integer.parseInt(request.getParameter("memberId"));
        Venue venue = new VenueDatabase().queryById(Integer.parseInt(request.getParameter("venueId")));
        
        Timeslot timeslot = getTimeslot(request);
        if (timeslot.getBeginTime().isAfter(timeslot.getEndTime())) {
            writeTimeslotWrongMsg(response, timeslot);
            return;
        }
        
        if (!CheckTimeslotAvailableService.isAvailable(timeslot, venue.getId())) {
            writeTimeslotOccupiedMsg(response, timeslot, venue);
            return;
        }

        GuestsExtractor guestsExtractor = new GuestsExtractor(request, response, venue);
        if (!guestsExtractor.isDataValid)
            return;
        var guests = guestsExtractor.getGuestList();
        
        Booking booking = db.add(memberId, timeslot, venue.getId(), guests);
        request.setAttribute("booking", booking);
        String destination = "/user/member/booking_details.jsp?id=" + booking.getId();
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private static void writeTimeslotWrongMsg(HttpServletResponse response, Timeslot timeslot) {
        String title = "post parameter error";
        String errorMessage = "timeslot begin time must be after end time\n" +
            "now the timeslot is " + timeslot;
        ErrorMessageWritingService.write(response, title, errorMessage);
    }

    private void writeTimeslotOccupiedMsg(HttpServletResponse response, Timeslot timeslot, Venue venue) {
        String title = "Timeslot occupied";
        List<Timeslot> occupyingTimeslots = new TimeSlotDatabase().queryByVenueDate(venue.getId(), timeslot.getBeginTime());
        assert !occupyingTimeslots.isEmpty();
        
        String timeslots = occupyingTimeslots.stream().map(t -> t.toString() + "<br>").reduce(String::concat).get();
        String errorMessage = "Timeslot " + timeslot + " not available.<br>" +
                "The following timeslots are occupied in the venue " + venue.getName() + ":<br>" +
                timeslots;
        ErrorMessageWritingService.write(response, title, errorMessage);
    }

    private Timeslot getTimeslot(HttpServletRequest request) {
        Timeslot timeslot;
        String date = request.getParameter("date");
        
        Instant beingTime = InstantParser.parseInstantFromHtmlDatetime(date + " " + request.getParameter("beginTime"));
        Instant endTime = InstantParser.parseInstantFromHtmlDatetime(date + " " + request.getParameter("endTime"));
        timeslot = new TimeSlotDatabase().add(beingTime, endTime);
        return timeslot;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
