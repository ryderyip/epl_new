package ict.data_objects.non_entties;

import ict.data_objects.entities.Member;
import ict.data_objects.entities.Staff;
import ict.data_objects.entities.StaffRole;
import ict.data_objects.entities.User;

public class UserTypeIdentifier {
    public static UserType identify(User user) {
        if (user instanceof Member) return UserType.MEMBER;
        if (user instanceof Staff)
            return ((Staff) user).getRole() == StaffRole.NORMAL
                ? UserType.STAFF : UserType.MANAGER;
        throw new UnsupportedOperationException("Unsupported user type");
    }
}
