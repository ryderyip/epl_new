package ict.test;

import ict.data_objects.entities.Venue;
import ict.db.VenueDatabase;

public class TestQueryVenue {
    public static void main(String[] args) {
        VenueDatabase database = new VenueDatabase();
        Venue venue = database.queryById(1);
        System.out.println(venue.getName());
    }
}
