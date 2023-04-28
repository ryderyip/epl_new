<%@ page import="ict.data_objects.entities.Venue" %>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
        <title>Venue Management</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <jsp:useBean id="venues" scope="request" class="java.util.ArrayList"/>
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
                                <a class="nav-link active" href="venue_management.jsp">Venue Management</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Booking Management</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="member_management.jsp">Member Management</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav><br><br><br>
        <center><h3 class="offcanvas-title">Venue Management</h3></center>
    <hr>
    <div class="container">
        
        <%
            out.println("<h1>Venues</h1>");
            out.println("<table border='1' class='table table-striped'>");
            out.println("<tr>");
            out.println("<th>Venue Name</th>");
            out.println("</tr>");
            for (Object customer : venues) {
                Venue c = (Venue) customer;
                out.println("<tr><td>");
                out.println(c.getName());
                out.println("<a href=\""+ request.getContextPath()+"/venue/get?id="+ c.getId() +"\" class='btn btn-primary'>Go detail page</a>");
                out.println("</td></tr>");
            }
            out.println("</table>");
        %>
        
    </div>
    </body>
</html>
