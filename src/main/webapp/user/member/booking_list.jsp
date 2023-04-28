<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<!doctype html>
<html lang="en">
<%
    if (request.getAttribute("bookings") == null)
        response.sendRedirect(request.getContextPath() + "/booking/get");
%>
<jsp:useBean id="bookings" scope="request" class="java.util.ArrayList"
             type="java.util.List<ict.data_objects.entities.Booking>"/>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <title>Record</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar bg-body-tertiary fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/user/member/member_frontpage.jsp">EPL
            Booking</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
                aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
            <div class="offcanvas-header">
                <h3 class="offcanvas-title" id="offcanvasNavbarLabel">Member</h3>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>

            <div class="offcanvas-body">

                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/user/member/member_frontpage.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/user/member/booking_create.jsp">Venue
                            Booking</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="${pageContext.request.contextPath}/user/member/booking_details.jsp">Booking
                            Management</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<br><br><br>
<!----End Navbar---->

<center><h3 class="offcanvas-title">Record</h3></center>
<hr>

<c:if test="${empty bookings}">
    <p>You don't have any bookings yet.</p>
</c:if>
<c:if test="${not empty bookings}">
    <table class="table">
        <thead>
        <tr>
            <th>Venue</th>
            <th>Booked Timeslot</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="booking" items="${bookings}">
            <tr>
                <td>${booking.venue.name}</td>
                <td>${booking.timeslot}</td>
                <td>${booking.statusMessage}</td>
                <td><a href="${pageContext.request.contextPath}/user/member/booking_details.jsp?id=${booking.id}">View Details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

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