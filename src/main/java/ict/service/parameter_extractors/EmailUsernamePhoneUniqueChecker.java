package ict.service.parameter_extractors;

import ict.data_objects.entities.UserCommonInfo;
import ict.db.UserCommonInfoDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EmailUsernamePhoneUniqueChecker {
    UserCommonInfo info;
    HttpServletRequest request;
    HttpServletResponse response;

    public EmailUsernamePhoneUniqueChecker(UserCommonInfo info, HttpServletRequest request, HttpServletResponse response) {
        this.info = info;
        this.request = request;
        this.response = response;
    }

    /**
     * @return true if unique
     */
    public boolean checkIsUniqueOrGoErrorPage() throws ServletException, IOException {
        var db = new UserCommonInfoDatabase();
        
        if (db.queryByEmail(info.getEmail()) != null) {
            goErrorPage("Member with email " + info.getEmail() + " already exists");
            return false;
        }
        if (db.queryByUsername(info.getUsername()) != null) {
            goErrorPage("Member with username " + info.getUsername() + " already exists");
            return false;
        }
        if (db.queryByPhone(info.getPhone()) != null) {
            goErrorPage("Member with phone " + info.getPhone() + " already exists");
            return false;
        }
        
        return true;
    }

    private void goErrorPage(String errorMessage) throws ServletException, IOException {
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("/registerError.jsp").forward(request, response);
    }
}
