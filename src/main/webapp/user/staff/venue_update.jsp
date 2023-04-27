<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<jsp:useBean id="venue" scope="request" class="ict.data_objects.entities.Venue"/>
<!doctype html>
<html lang="en">
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
      <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
      <title>Venue Update</title>
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
        <form method="post" action="#">
            <input type="hidden" name="id" value="${param.id}" class="from-control"/>
            <label for="name">Name:</label>
            <input type="text" name="name" value="${venue.name}" class="from-control"/><br>

            <label for="type">Type:</label>
            <input type="text" name="type" value="${venue.type}" class="from-control"/><br>

            <label for="description">Description:</label>
            <input type="text" name="descripion" class="from-control" value="${venue.description}"/><br>
            
            <label for="location">Location:</label>
            <input type="text" name="location" value="${venue.location}" class="from-control"/><br>

            <label for="capacity">Capacity:</label>
            <input type="number" name="capacity" value="${venue.capacity}" class="from-control"/><br>
            
            <label for="hourlyRate">Booking Fee:</label>
            <input type="number" name="hourlyRate" value="${venue.bookingFee}" class="from-control"/><br>
            
            <div class="form-check">
                <input class="form-check-input" type="radio" name="available" id="ava1" ${venue.available ? 'checked' : ''}>
                <label class="form-check-label" for="ava1">
                    Avaliable
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="available" id="ava2" ${venue.available ? 'checked' : ''}>
                <label class="form-check-label" for="ava2">
                    Not Avaliable
                </label>
            </div>
                
            <br>
            <center><input type="submit" class="btn btn-primary" /></center>
        </form>
    </div>
    
    </body>
</html>
