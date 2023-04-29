package ict.servlet;

import ict.data_objects.entities.StaffRole;
import ict.data_objects.entities.Venue;
import ict.data_objects.non_entties.UserType;
import ict.db.StaffDatabase;
import ict.db.UserCommonInfoDatabase;
import ict.db.VenueDatabase;
import ict.service.login_session.LoggedInUserChecker;
import ict.service.parameter_extractors.EmailUsernamePhoneUniqueChecker;
import ict.service.parameter_extractors.UserCommonInfoExtractor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = {"/staff/update"})
public class UpdateStaffServlet extends HttpServlet {
    private StaffDatabase db;

    public void init() {
        db = new StaffDatabase();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!new LoggedInUserChecker(request).checkIsLoggedInAndOfType(UserType.MANAGER)) {
            request.getRequestDispatcher("/loginSessionError.jsp").forward(request, response);
            return;
        }
        var staff = db.queryById(Integer.parseInt(request.getParameter("staffId")));
        var info = UserCommonInfoExtractor.extract(request);
        
        if (!new EmailUsernamePhoneUniqueChecker(info, request, response, staff.getInfo().getId()).checkIsUniqueOrGoErrorPage())
            return;

        new UserCommonInfoDatabase().update(staff.getInfo().getId(), info);

        var vDb = new VenueDatabase();
        String[] parameterValues = request.getParameterValues("venues[]");
        List<Venue> venues = parameterValues == null ? Collections.emptyList() : Arrays.stream(parameterValues).map(id -> vDb.queryById(Integer.parseInt(id))).toList();
        staff.setVenuesInCharge(venues);

        String roleName = request.getParameter("staffRole");
        assert roleName != null && (roleName.equalsIgnoreCase("J")
                || roleName.equalsIgnoreCase("S"));
        var role = roleName.equalsIgnoreCase("J")
                ? StaffRole.NORMAL : StaffRole.SENIOR;
        staff.setRole(role);
        db.update(staff);

        String destination = "/user/manager/staff_details.jsp?id=" + staff.getId();
        request.getRequestDispatcher(destination).forward(request, response);
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
