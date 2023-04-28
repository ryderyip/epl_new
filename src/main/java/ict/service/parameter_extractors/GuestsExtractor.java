package ict.service.parameter_extractors;

import ict.data_objects.entities.Guest;
import ict.data_objects.entities.Venue;
import ict.service.ErrorMessageWritingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

public class GuestsExtractor {
    private final List<Guest> guestList  = new ArrayList<>();
    public boolean isDataValid = false;
    
    public GuestsExtractor(HttpServletRequest request, HttpServletResponse response, Venue venue) {
        String[] names = request.getParameterValues("names[]");
        String[] emails = request.getParameterValues("emails[]");
        if (names.length != emails.length) {
            String title = "post parameter error";
            String errorMessage = "names[] and emails[] have different length";
            ErrorMessageWritingService.write(response, title, errorMessage);
            return;
        }
        for (int i = 0; i < names.length; i++)
            guestList.add(new Guest(-1, names[i], emails[i]));

        if (guestList.size() > venue.getCapacity()) {
            ErrorMessageWritingService.write(response, "No. of guests over capacity", "The capacity of the venue is " + venue.getCapacity() + ". You entered " + guestList.size() + " guests");
            return;
        }
        isDataValid = true;
    }

    public List<Guest> getGuestList() {
        assert isDataValid;
        return guestList;
    }
}
