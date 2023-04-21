package ict.data_objects.entities;

public enum Gender {
    M("M"),
    F("F");

    private final String n;

    Gender(String shortName) {
        this.n = shortName;
    }

    public String getShortName() {return n;}
}
