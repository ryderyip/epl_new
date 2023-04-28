<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<jsp:useBean id="member" scope="request" class="ict.data_objects.entities.Member"/>
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
                            <a class="nav-link" href="#">Booking Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="member_management.jsp">Member Management</a>
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
    <center><h3 class="offcanvas-title">Member Update</h3></center>
    <hr>
    <div class="container">
        <form method="post" action="#">
            <input type="hidden" name="id" value="${param.id}" class="from-control"/>
            <label for="name">Username</label>
            <input type="text" name="name" value="${member.username}" class="from-control"/><br>

            <label for="type">Name:</label>
            <input type="text" name="type" value="${member.name}" class="from-control"/><br>

            <label for="description">Email:</label>
            <input type="text" name="descripion" class="from-control" value="${member.email}"/><br>
            
            <label for="location">Gender:</label>
            <input type="text" name="location" value="${member.gender}" class="from-control"/><br>

            <label for="capacity">Phone:</label>
            <input type="number" name="capacity" value="${member.phone}" class="from-control"/><br>
                
            <br>
            <center><input type="submit" class="btn btn-primary" value="Update"/></center>
        </form>
    </div>
    
    </body>
</html>
