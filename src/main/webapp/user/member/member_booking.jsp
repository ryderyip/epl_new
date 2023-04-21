<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<!doctype html>
<html lang="en">
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
      <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
      <title>Venue Booking</title>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
    <nav class="navbar bg-body-tertiary fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="member_frontpage.jsp">EPL Booking</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
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
                            <a class="nav-link" href="member_frontpage.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="member_booking.jsp">Venue Booking</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="member_guest.jsp">Guest Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="member_record.jsp">Record</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav><br><br><br>
    <!----End Navbar---->
    
    <center><h3 class="offcanvas-title">Venue Booking</h3></center>
    <hr>
    <table class="table table-striped" width="90%">
        <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Name</th>
              <th scope="col">Location</th>
              <th scope="col">Type</th>
              <th scope="col">Capacity</th>
              <th scope="col">Available</th>
              <th scope="col">Image</th>
              <th scope="col">Booking Fee</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>XXX</td>
              <td>XXX</td>
              <td>XXX</td>
              <td>XXX</td>
              <td>XXX</td>
              <td>XXX</td>
              <td>XXX</td>
              <td><a href="#" class="btn btn-primary">Booking</a></td>
            </tr>
            <tr>
              <td>2</td>
              <td>YYY</td>
              <td>YYY</td>
              <td>YYY</td>
              <td>YYY</td>
              <td>YYY</td>
              <td>YYY</td>
              <td>YYY</td>
              <td><a href="#" class="btn btn-primary">Booking</a></td>
            </tr>
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