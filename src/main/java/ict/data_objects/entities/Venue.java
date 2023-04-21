package ict.data_objects.entities;


import java.io.Serializable;

public class Venue implements Serializable {
    private int id;
    private String name;
    private String location;
    private boolean available;
    private int capacity;
    private BookingFee bookingFee;
    private String image;
    private String description;
    private String type;

    public Venue() {}

    public Venue(int id, String name, String location, boolean available, String image, String description, String type, int capacity, BookingFee bookingFee) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.available = available;
        this.image = image;
        this.description = description;
        this.type = type;
        this.capacity = capacity;
        this.bookingFee = bookingFee;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public BookingFee getBookingFee() {
        return bookingFee;
    }

    public void setBookingFee(BookingFee bookingFee) {
        this.bookingFee = bookingFee;
    }
}
