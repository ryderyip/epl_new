<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<%@ page import="ict.data_objects.entities.Staff" %>
<!doctype html>
<html lang="en">
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
      <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
      <title>Staff Details</title>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>

    <jsp:useBean id="staff" scope="request" class="ict.data_objects.entities.Staff"/>
    <%
        Object idk = request.getAttribute("staff");
        if (idk == null || ((Staff) idk).getId() == 0) {
            String id = request.getParameter("id");
            if (id == null)
                response.sendRedirect(request.getContextPath() + "/staff/get");
            else
                response.sendRedirect(request.getContextPath() + "/staff/get?id="+id);
        }
    %>

    <nav class="navbar bg-body-tertiary fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/user/manager/manager_frontpage.jsp">EPL Booking</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                <div class="offcanvas-header">
                    <h3 class="offcanvas-title" id="offcanvasNavbarLabel">Manager</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                
                <div class="offcanvas-body">
                    
                    <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/user/manager/manager_frontpage.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="${pageContext.request.contextPath}/user/manager/staff_management.jsp">Staff Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav><br><br><br>
    <!----End Navbar---->
    <center><h3 class="offcanvas-title">Staff Details</h3></center>
    <hr>
    <div class="container">
        <form method="post" action="#">
            <input type="hidden" name="id" value="${staff.id}" />
        <p>
            <label>Username:</label>
            <input type="text" name="username" value="${staff.info.username}" class="form-control"/>
        </p>
        <p>
            <label>Name:</label>
            <input type="text" name="name" value="${staff.info.name}" class="form-control"/>
        </p>
        <p>
            <label>Phone:</label>
            <input type="text" name="phone" value="${staff.info.phone}" class="form-control"/>
        </p>
        <p>
            <label>Gender:</label>
            <input type="text" name="gender" value="${staff.info.gender}" class="form-control"/>
        </p>
        <p>
            <label>Email:</label>
            <input type="text" name="email" value="${staff.info.email}" class="form-control"/>
        </p>
        <p>
            <label>Staff Role:</label>
            <select name="staffRole" class="form-select">
                <option value="junior" ${staff.role.abbreviation == 'J' ? 'selected' : ''}>Junior Staff</option>
                <option value="management" ${staff.role.abbreviation == 'S' ? 'selected' : ''}>Management Staff</option> 
            </select>
        </p>
        
        <p>
            <label>Venues in Charge:</label>
            <input type="text" name="venues" value="${staff.venuesInCharge}" class="form-control"/>
        </p>
        <input type="submit" value="Update" class="btn btn-primary"/>
        </form>
    </div>
    
    </body>
</html>
