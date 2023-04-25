package ict.db;

import com.sun.jdi.Value;
import ict.data_objects.entities.Member;
import ict.data_objects.entities.UserCommonInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class MemberDatabase {
    public static final String COLUMN_INFO_ID = "info_id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_USERNAME = "username";
    public static final String TABLE_NAME = "member";
    final Database<Member> memberDb;

    public MemberDatabase() {
        memberDb = new Database<>(resultSet -> new Member(
                resultSet.getInt("id"),
                new UserCommonInfoDatabase().queryById(resultSet.getInt(COLUMN_INFO_ID))
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
            id = memberDb.insertRow(s, TABLE_NAME);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    public Member queryById(int id) {
        return memberDb.queryById(id, TABLE_NAME);
    }

    /**
     * @return member with email or null
     */
    @Nullable
    public Member queryByInfoId(int infoId) {
        var q = memberDb.queryByIntColumn(TABLE_NAME, COLUMN_INFO_ID, infoId);
        if (q.isEmpty()) return null;
        return q.get(0);
    }
    
    /**
     * @return member with email or null
     */
    @Nullable
    public Member queryByEmail(String email) {
        var q = new UserCommonInfoDatabase().queryByEmail(email);
        if (q.isEmpty()) return null;
        return queryByInfoId(q.get(0).getId());       
    }

    /**
     * @return member with phone or null
     */
    @Nullable
    public Member queryByPhone(String phone) {
        var q = new UserCommonInfoDatabase().queryByPhone(phone);
        if (q.isEmpty()) return null;
        return queryByInfoId(q.get(0).getId());
    }

    /**
     * @return member with username or null
     */
    @Nullable
    public Member queryByUsername(String username) {
        var q = new UserCommonInfoDatabase().queryByUsername(username);
        if (q.isEmpty()) return null;
        return queryByInfoId(q.get(0).getId());
    }
}

