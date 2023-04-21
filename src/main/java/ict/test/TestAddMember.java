package ict.test;

import ict.data_objects.entities.Gender;
import ict.data_objects.entities.Member;
import ict.data_objects.entities.UserCommonInfo;
import ict.db.MemberDatabase;

public class TestAddMember {
    public static void main(String[] args) {
        new MemberDatabase().add(new Member(-1, new UserCommonInfo(
                -1,
                "Steven",
                "steven@gmail.com",
                Gender.M,
                "pw",
                "98743273",
                "steven"
        )));
    }
}
