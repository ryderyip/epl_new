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
      <title>Home Page</title>
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
                            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/user/member/member_frontpage.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/member/booking_create.jsp">Venue Booking</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/member/booking_details.jsp">Booking Management</a>
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
    
    <center><h3 class="offcanvas-title">Welcome to EPL Booking</h3></center>
    <hr>
    <table border="0" width="100%">
        <tr>
            <td width="20%">
                        
            </td>
            <td width="30%">
                <table border="1" width="90%">
                    <tr>
                        <td align="center"><a href="${pageContext.request.contextPath}/user/member/booking_create.jsp"><img src="${pageContext.request.contextPath}/img/booking.png" width="250px" height=250px"/></a></td>
                    </tr>
                    <tr>
                        <td align="center"><a class="btn btn-primary" href="${pageContext.request.contextPath}/user/member/booking_create.jsp">Venue Booking</a></td>
                    </tr>
                </table>
            </td>
            
            <td width="20%">
                <table border="1" width="90%">
                    <tr>
                        <td align="center"><a href="${pageContext.request.contextPath}/user/member/booking_list.jsp"><img src="${pageContext.request.contextPath}/img/record.png" width="250px" height=250px"/></a></td>
                    </tr>
                    <tr>
                        <td align="center"><a class="btn btn-primary" href="${pageContext.request.contextPath}/user/member/booking_list.jsp">Record</a></td>
                    </tr>
                </table>
            </td>
            <td width="20%">
                        
            </td>
        </tr>
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