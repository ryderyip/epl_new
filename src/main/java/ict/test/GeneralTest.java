package ict.test;

import ict.db.VenueDatabase;

public class GeneralTest {
    public static void main(String[] args) {
        var vs = new VenueDatabase().queryAvailableVenues();
        vs.forEach(System.out::println);
    }
}
