package ict.db;

import ict.data_objects.entities.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserDatabase {
    final MemberDatabase memberDb;
    final StaffDatabase staffDb;

    public UserDatabase() {
        memberDb = new MemberDatabase();
        staffDb = new StaffDatabase();
    }

    public List<User> query() {
        return Stream.concat(memberDb.queryMembers().stream().map(User.class::cast), staffDb.query().stream().map(User.class::cast))    .collect(Collectors.toList());
    }
}
