package ict.service.parameter_extractors;

import ict.data_objects.entities.UserCommonInfo;
import ict.db.UserCommonInfoDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class EmailUsernamePhoneUniqueChecker {
    UserCommonInfo info;
    HttpServletRequest request;
    HttpServletResponse response;
    int infoId = -1; // need this if update

    public EmailUsernamePhoneUniqueChecker(UserCommonInfo info, HttpServletRequest request, HttpServletResponse response) {
        this.info = info;
        this.request = request;
        this.response = response;
    }

    public EmailUsernamePhoneUniqueChecker(UserCommonInfo info, HttpServletRequest request, HttpServletResponse response, int infoId) {
        this.info = info;
        this.request = request;
        this.response = response;
        this.infoId = infoId;
    }

    /**
     * @return true if unique
     */
    public boolean checkIsUniqueOrGoErrorPage() throws ServletException, IOException {
        var db = new UserCommonInfoDatabase();
        
        System.out.println(infoId);
        
        List<UserCommonInfo> existingEmails = db.queryByEmail(info.getEmail());
        if (!existingEmails.isEmpty() && existingEmails.get(0).getId() != infoId) {
            goErrorPage("Member with email " + info.getEmail() + " already exists");
            return false;
        }
        List<UserCommonInfo> existingUsernames = db.queryByUsername(info.getUsername());
        if (!existingUsernames.isEmpty() && existingUsernames.get(0).getId() != infoId) {
            goErrorPage("Member with username " + info.getUsername() + " already exists");
            return false;
        }
        List<UserCommonInfo> existingPhones = db.queryByPhone(info.getPhone());
        if (!existingPhones.isEmpty() && existingPhones.get(0).getId() != infoId) {
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
