package ict.data_objects.entities;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Venue implements Serializable {
    private int id;
    private String name;
    private String location;
    private boolean available;
    private int capacity;
    private String description;
    private String type;
    private List<BookingFee> bookingFees = Collections.emptyList();

    public Venue() {}

    public Venue(int id, String name, String location, boolean available, String description, String type, int capacity, List<BookingFee> bookingFees) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.available = available;
        this.description = description;
        this.type = type;
        this.capacity = capacity;
        this.bookingFees = bookingFees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<BookingFee> getBookingFees() {
        return bookingFees;
    }

    public void setBookingFees(List<BookingFee> bookingFees) {
        this.bookingFees = bookingFees;
    }
}
