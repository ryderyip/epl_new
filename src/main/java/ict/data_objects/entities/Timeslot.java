package ict.data_objects.entities;

import ict.service.InstantFormatter;

import java.time.Duration;
import java.time.Instant;
import java.time.format.FormatStyle;

public class Timeslot {
    private int id;
    private Instant beginTime;
    private Instant endTime;

    public Timeslot(int id, Instant beginTime, Instant endTime) {
        this.id = id;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }
    
    public boolean hasOverlapWith(Timeslot other) {
        return other.beginTime.isBefore(endTime) && other.endTime.isAfter(endTime)
                || other.beginTime.isBefore(beginTime) && other.endTime.isAfter(beginTime)
                || other.beginTime.equals(beginTime)
                || other.endTime.equals(endTime);
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Instant beginTime) {
        this.beginTime = beginTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return InstantFormatter.format(getBeginTime(), FormatStyle.SHORT) + " to "+ InstantFormatter.format(getEndTime(), FormatStyle.SHORT);
    }
    
    public double getDurationInHours() {
        return Duration.between(getBeginTime(), getEndTime()).toMinutes() / 60.0;
    }
}
