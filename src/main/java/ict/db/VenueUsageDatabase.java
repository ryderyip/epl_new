package ict.db;

import ict.data_objects.entities.VenueUsage;

import java.time.Instant;

public class VenueUsageDatabase {
    private final Database<VenueUsage> db;

    public VenueUsageDatabase() {
        db = new Database<>(input -> new VenueUsage(
            input.getInt("id"), 
            input.getObject("check_in", Instant.class),
            new CheckOutDatabase().queryById(input.getInt("check_out_id")),
            input.getString("member_comments")
        ));
    }

    public VenueUsage queryById(int id) {
        return db.queryById(id, "venue_usage");
    }
}
