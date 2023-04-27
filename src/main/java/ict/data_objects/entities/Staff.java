package ict.data_objects.entities;

import java.util.List;


public class Staff extends User {
    private StaffRole role;
    private List<Venue> venuesInCharge;

    public Staff() {}

    public Staff(int id, UserCommonInfo info, List<Venue> venuesInCharge, StaffRole role) {
        super(id, info);
        this.venuesInCharge = venuesInCharge;
        this.role = role;
    }

    public List<Venue> getVenuesInCharge() {
        return venuesInCharge;
    }


    public StaffRole getRole() {
        return role;
    }

    public void setRole(StaffRole role) {
        this.role = role;
    }

    public void setVenuesInCharge(List<Venue> venuesInCharge) {
        this.venuesInCharge = venuesInCharge;
    }
}

