package ict.data_objects.entities;

public class BookingFee {
    private int id;
    private double hourlyRate;
    private int year;

    public BookingFee(int id, double hourlyRate, int year) {
        this.id = id;
        this.hourlyRate = hourlyRate;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
