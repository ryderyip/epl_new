package ict.service.parameter_extractors;

import ict.data_objects.entities.Gender;
import ict.data_objects.entities.UserCommonInfo;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Objects;

public class UserCommonInfoExtractor {
    public static UserCommonInfo extract(HttpServletRequest request) {
        assert request.getParameter("gender").equals("male") || request.getParameter("gender").equals("female");
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Gender gender = Objects.equals(request.getParameter("gender"), "male") ? Gender.M : Gender.F;
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        return new UserCommonInfo(-1, name, email, gender, password, phone, username);
    }
}
