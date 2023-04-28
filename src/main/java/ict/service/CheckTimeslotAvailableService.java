package ict.service;

import ict.data_objects.entities.Booking;
import ict.data_objects.entities.Timeslot;
import ict.db.BookingDatabase;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.function.Predicate;

public class CheckTimeslotAvailableService {
    public static boolean isAvailable(Timeslot timeslot, int venueId) {
        List<Booking> bookings = new BookingDatabase().queryByVenueId(venueId);
        List<Booking> sameDayBookings = bookings.stream().filter(sameDateAs(timeslot)).toList();
        return sameDayBookings.stream().noneMatch(booking -> booking.getTimeslot().hasOverlapWith(timeslot));
    }

    @NotNull
    private static Predicate<Booking> sameDateAs(Timeslot timeslot) {
        return booking -> LocalDateTime.ofInstant(booking.getTimeslot().getBeginTime(), ZoneId.systemDefault()).toLocalDate().isEqual(
                LocalDateTime.ofInstant(timeslot.getBeginTime(), ZoneId.systemDefault()).toLocalDate()
        );
    }
}

