package ict.service.login;

import ict.data_objects.entities.User;
import ict.data_objects.non_entties.UserType;
import ict.data_objects.non_entties.UserTypeIdentifier;
import ict.db.UserDatabase;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Predicate;

public class LoginService {
    public LoginResult attemptLogin(String username, String password) {
        List<User> members = new UserDatabase().query();
        List<User> q = members.stream().filter(matchUsernameAndPassword(username, password)).toList();

        boolean loginSuccess = !q.isEmpty();
        UserType userType = UserTypeIdentifier.identify(q.get(0));
        return new LoginResult(loginSuccess, userType);
    }

    @NotNull
    private static Predicate<User> matchUsernameAndPassword(String username, String password) {
        return member -> member.getInfo().getUsername().equals(username) && member.getInfo().getPassword().equals(password);
    }
}
