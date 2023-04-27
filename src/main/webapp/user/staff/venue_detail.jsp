<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>

<jsp:useBean id="venue" scope="request" class="ict.data_objects.entities.Venue"/>
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
    <jsp:useBean id="venue" scope="request" class="ict.data_objects.entities.Venue"/>
    
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
                            <a class="nav-link active" href="venue_detail.jsp">Venue Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Booking Management</a>
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
    
    <center><h3 class="offcanvas-title">Venue Detail</h3></center>
    <hr>
    <div class="container">
        <table id="guest" width="100%">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Location</th>
                    <th>Description</th>
                    <th>Availability capacity</th>
                    <th>Booking fee</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="venue" items="${venues}">
                    <tr>
                        <td>${venue.getName()}</td>
                        <td>${venue.getType()}</td>
                        <td>${venue.getLocation()}</td>
                        <td>${venue.getDescription()}</td>
                        <td>${venue.isAvailable()}</td>
                        <td>${venue.getBookingFee()}</td>
                        <td><a href="venue_update.jsp?id=${venue.getId()}" class="btn btn-primary">Update</a></td>
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