package ict.test;

import ict.db.StaffDatabase;

public class GeneralTest {
    public static void main(String[] args) {
        var staff = new StaffDatabase().queryById(1);
        System.out.println(staff.getInfo());
    }
}
