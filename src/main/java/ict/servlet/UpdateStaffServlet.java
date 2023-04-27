package ict.servlet;

import ict.db.StaffDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet(urlPatterns = {"/staff/get"})
public class UpdateStaffServlet extends HttpServlet {
    private StaffDatabase db;

    public void init() {
        db = new StaffDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String id = request.getParameter("id");
        if (id == null) {
            ErrorMessageWritingService.write(response, "No id", "Need to post id of staff to update");
            return;
        }
        var staff = db.queryById(Integer.parseInt(id));
        var info = UserCommonInfoExtractor.extract(request);
        
        if (!new EmailUsernamePhoneUniqueChecker(info, request, response).checkIsUniqueOrGoErrorPage())
            return;

        new UserCommonInfoDatabase().add(info);
        staff.setInfo(info);
        
        
        staff.setRole()
        
        db.update(staff);*/
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
