<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<%@ page import="ict.data_objects.entities.Venue" %>
<%@ page import="java.util.List" %>
<!doctype html>
<%
    String memberId = (String)request.getAttribute("memberId");
    if (memberId == null || request.getAttribute("venues") == null)
        response.sendRedirect(request.getContextPath() + "/prebooking_create");
%>
<jsp:useBean id="venues" scope="request" class="java.util.ArrayList"/>
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
            <a class="navbar-brand" href="${pageContext.request.contextPath}/user/member/member_frontpage.jsp">EPL Booking</a>
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
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/member/member_frontpage.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="${pageContext.request.contextPath}/user/member/booking_create.jsp">Venue Booking</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/member/my_booking.jsp">Book Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav><br><br><br>
    <!----End Navbar---->
    
    <center><h3 class="offcanvas-title">Venue Booking</h3></center>
    <hr>
    <div class="container">
    <form method="post" action="${pageContext.request.contextPath}/booking/create">
        <input type="hidden" name="memberId" value="<%=request.getAttribute("memberId")%>">

        <div class="container">
            <label for="date">Date:</label>
            <input type="date" name="date" id="date" required>
            <div class="row g-3 align-items-center">
                <label for="timeslot">Timeslot:</label>
            </div>
            <div class="row align-items-end">
              <div class="col"><input type="time" name="beginTime" class="form-control" placeholder="Begin Time" required></div>
              <div class="col"><input type="time" name="endTime" class="form-control" placeholder="End Time" required></div>
            </div>
        
        
        <br><br>
        <label for="venue">Venue:</label>
        <select class="form-select" name="venueId" required>
            <c:forEach var="venue" items="${venues}">
                <option value="${venue.id}">${venue.name}</option>
            </c:forEach>
        </select>
        <br><br><hr>
        <center>
            <label for="guests" class="form-label"><h3>Guest List</h3></label>
        <table id="guest" width="100%">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="names[]" class="form-control" placeholder="Name" required></td>
                    <td><input type="email" name="emails[]" class="form-control"  placeholder="Email" required></td>
                    <td><button type="button" class="btn btn-danger" onclick="removeRow(this)">Remove</button></td>
                </tr>
            </tbody>
        </table>
        <br><br>
        <button type="button" class="btn btn-primary" onclick="addGuest()">Add Guest</button>
        <hr>
        <button type="submit" class="btn btn-primary">Submit</button>
        </center>
    </form>
    </div>
    <script>
        function addGuest() {
            var table = document.getElementById("guest");
            var row = table.insertRow(-1);
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);
            cell1.innerHTML = '<input type="text" name="name[]" class="form-control new-row" placeholder="Name" required>';
            cell2.innerHTML = '<input type="email" name="email[]" class="form-control new-row" placeholder="Email" required>';
            cell3.innerHTML = '<button type="button" class="btn btn-danger" onclick="removeRow(this)">Remove</button>';
        }
        
        function removeRow(button) {
            var table = document.getElementById("guest");
            if (table.rows.length <= 2) return;
            
            var row = button.parentNode.parentNode;
            row.parentNode.removeChild(row);
        }
    </script>    
        
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




