package ict.db;

import ict.data_objects.entities.Member;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MemberDatabase {
    final Database<Member> memberDb;

    public MemberDatabase() {
        memberDb = new Database<>(resultSet -> new Member(
                resultSet.getInt("id"),
                new UserCommonInfoDatabase().queryById(resultSet.getInt("info_id"))
        ));
    }

    public List<Member> queryMembers() {
        List<Member> list;
        try {
            list = memberDb.query(memberDb.getConnection().prepareStatement("select * from member"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int add(Member member) {
        UserCommonInfoDatabase infoDb = new UserCommonInfoDatabase();
        int infoId = infoDb.add(member.getInfo());
        int id;
        try {
            String sql = "insert into member (info_id) value (?); ";
            PreparedStatement s = memberDb.getConnection().prepareStatement(sql);
            s.setInt(1, infoId);
            id = memberDb.insertRow(s, "member");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    public Member queryById(int id) {
        return memberDb.queryById(id, "member");
    }
}

