package ict.test;

import ict.data_objects.entities.Venue;
import ict.db.MemberDatabase;
import ict.db.VenueDatabase;

public class TestQueryVenue {
    public static void main(String[] args) {
        var db = new MemberDatabase();
        var m = db.queryByEmail("ryderyip@mgila.mcom");
        System.out.println(m.getInfo().getName());
    }
}
