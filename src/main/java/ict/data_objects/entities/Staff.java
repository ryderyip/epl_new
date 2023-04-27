package ict.data_objects.entities;

import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.util.List;


public class Staff extends User {
    private StaffRole role;
    private List<Venue> venuesInCharge;

    public Staff(int id, UserCommonInfo info, List<Venue> venuesInCharge, StaffRole role) {
        super(id, info);
        this.venuesInCharge = venuesInCharge;
        this.role = role;
    }

    public List<Venue> getVenuesInCharge() {
        return venuesInCharge;
    }

    public void ListVenuesInCharge(List<Venue> venuesInCharge) {
        this.venuesInCharge = venuesInCharge;
    }

    public StaffRole getRole() {
        return role;
    }

    public void ListRole(StaffRole role) {
        this.role = role;
    }
}

