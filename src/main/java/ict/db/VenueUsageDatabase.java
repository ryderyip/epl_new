package ict.db;

import ict.data_objects.entities.VenueUsage;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;

public class VenueUsageDatabase {
    public static final String TABLE_NAME = "venue_usage";
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

    @Nullable
    public VenueUsage queryByBookingId(int bookingId) {
        var q = db.queryByIntColumn(TABLE_NAME, "booking_id", bookingId);
        if (q.isEmpty())
            return null;
        return q.get(0);
    }
}
