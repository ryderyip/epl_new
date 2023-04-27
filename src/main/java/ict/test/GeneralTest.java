package ict.test;

import ict.data_objects.entities.Venue;
import ict.db.VenueDatabase;

public class GeneralTest {
    public static void main(String[] args) {
        var db = new VenueDatabase();
        var q = db.queryAvailableVenues();
        q.stream().map(Venue::getName).forEach(System.out::println);
    }
}
