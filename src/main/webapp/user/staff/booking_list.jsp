<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<jsp:useBean id="booking" scope="request" class="ict.data_objects.entities.Booking" />
<jsp:useBean id="BookingRequestResponse" scope="request" class="ict.data_objects.entities.BookingRequestResponse" />
<!doctype html>
<html lang="en">
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
      <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
      <title>Staff</title>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
    <nav class="navbar bg-body-tertiary fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="staff_frontpage.jsp">EPL Booking</a>
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
                            <a class="nav-link" aria-current="page" href="member_frontpage.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="venue_detail.jsp">Venue Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="booking_list.jsp">Booking Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="member_management.jsp">Member Management</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav><br><br><br>
    <!----End Navbar---->
    
    <center><h3 class="offcanvas-title">Booking Management</h3></center>
    <hr>
    <table class="table">
        <thead>
            <tr>
                <th>Booking ID</th>
                <th>Member Email</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="booking" items="${bookings}">
                <tr>
                    <td>${booking.getId()}</td>
                    <td>${booking.getBooker().getEmail()}</td>
                    <td>${BookingRequestResponse.isApproved()}</td>
                    <td><a href="booking_detail.jsp?id=${booking.getId()}">View Details</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
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