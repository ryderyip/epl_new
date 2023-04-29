<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>

<!doctype html>
<html lang="en">
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
      <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
      <title>Venue Detail</title>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
    
    <%
        if (request.getAttribute("venue") == null) {
            String id = request.getParameter("id");
            if (id == null)
                response.sendRedirect(request.getContextPath() + "/venue/get");
            else
                response.sendRedirect(request.getContextPath() + "/venue/get?id=" + id);
        }
            
    %>
    <jsp:useBean id="venue" scope="request" class="ict.data_objects.entities.Venue"/>

    <nav class="navbar bg-body-tertiary fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/user/staff/staff_frontpage.jsp">EPL Booking</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>


            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                <div class="offcanvas-header">
                    <h3 class="offcanvas-title" id="offcanvasNavbarLabel">Staff</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>

                <div class="offcanvas-body">

                    <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/user/staff/staff_frontpage.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/staff/venue_detail.jsp">Venue Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/staff/booking_list.jsp">Booking Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/staff/member_management.jsp">Member Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav><br><br><br>
    
    <center><h3 class="offcanvas-title">Venue Detail</h3></center>
    <hr>
    <div class="container">
        <table id="guest" width="100%" class="table table-bordered">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Location</th>
                    <th>Description</th>
                    <th>Availability</th>
                    <th>Capacity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <tr>
                <td>${venue.name}</td>
                <td>${venue.type}</td>
                <td>${venue.location}</td>
                <td>${venue.description}</td>
                <td>${venue.available ? "Available" : "Not Available"}</td>
                <td>${venue.capacity}</td>
                <td><a href="${pageContext.request.contextPath}/user/staff/venue_update.jsp?id=${venue.id}" class="btn btn-primary">Update</a></td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="container">
        <table class="table table-striped" width="100%">
            <thead>
            <tr>
                <th scope="col">Year</th>
                <th scope="col">Hourly Rate</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="venue" items="${venue.bookingFees}" varStatus="status">
                <tr>
                    <td>${venue.year}</td>
                    <td>${venue.hourlyRate}</td>   
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!---footer--->
    <hr>
    <center>
    <%
	Date dNow = new Date();
	SimpleDateFormat year = new SimpleDateFormat("yyyy");
	out.print(String.format("Copyright EPL %s. All rights reserved.", year.format(dNow)));
    %> 
    </center>
    </body>
</html>