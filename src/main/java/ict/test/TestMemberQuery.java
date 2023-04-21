package ict.test;

import ict.data_objects.entities.Member;
import ict.data_objects.entities.Staff;
import ict.db.MemberDatabase;
import ict.db.StaffDatabase;

public class TestMemberQuery {
    public static void main(String[] args) {
        StaffDatabase db = new StaffDatabase();
        for (Staff m: db.query()) {
            System.out.println(m.getInfo().getName());
        }
    }
}
