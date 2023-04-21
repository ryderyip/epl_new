package ict.db;

import ict.data_objects.entities.BookingRequestResponse;

public class BookingRequestResponseDatabase {
    private final Database<BookingRequestResponse> db;

    public BookingRequestResponseDatabase() {
        this.db = new Database<>(rs -> new BookingRequestResponse(
            rs.getInt("id"),
            new BookingApprovedDetailsDatabase().queryById(rs.getInt("details_id")),
            rs.getBoolean("approved")
        ));
    }

    public BookingRequestResponse queryById(int id) {
        return db.queryById(id, "booking_request_response");
    }
}
