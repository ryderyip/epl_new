package ict.db;

import ict.data_objects.entities.CheckOut;

import java.time.Instant;

public class CheckOutDatabase {
    private final Database<CheckOut> db;
    
    public CheckOutDatabase() {
        this.db = new Database<>(input -> new CheckOut(
            input.getInt("id"),
            input.getObject("time", Instant.class),
            input.getString("remarks")
        ));
    }

    public CheckOut queryById(int id) {
        return db.queryById(id, "check_out");
    }
}
