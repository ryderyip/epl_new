package ict.servlet;

import ict.db.StaffDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/staff/update"})
public class UpdateStaffServlet extends HttpServlet {
    private StaffDatabase db;

    public void init() {
        db = new StaffDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*if (!new LoggedInUserChecker(request).checkIsLoggedInAndOfType(UserType.MANAGER)) {
            request.getRequestDispatcher("/loginSessionError.jsp").forward(request, response);
            return;
        }
        var staff = db.queryById(Integer.parseInt(Objects.requireNonNull(new LoginSessionManager(request).getSession()).userId));
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
