package ict.test;

import ict.db.BookingDatabase;
import ict.service.InstantFormatter;

import java.time.format.FormatStyle;

public class GeneralTest {
    public static void main(String[] args) {
        var booking = new BookingDatabase().queryById(2);
        assert booking.getVenueUsage() != null;
        System.out.println(InstantFormatter.format(booking.getVenueUsage().getCheckIn(), FormatStyle.MEDIUM));
    }
}
