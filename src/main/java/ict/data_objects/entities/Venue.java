package ict.data_objects.entities;


import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Venue implements Serializable {
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String location;
    private boolean available;
    private int capacity;
    @NotNull
    private String description;
    @NotNull
    private String type;
    private List<BookingFee> bookingFees = Collections.emptyList();

    public Venue() {}

    public Venue(int id, @NotNull String name, @NotNull String location, boolean available, @NotNull String description, @NotNull String type, int capacity, List<BookingFee> bookingFees) {
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

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(@NotNull String location) {
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

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(@NotNull String type) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        final Venue other = (Venue) obj;
        return id == other.id && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.name.hashCode();
        hash = 53 * hash + this.id;
        return hash;
    }
}
