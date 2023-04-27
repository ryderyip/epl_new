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
        <input type="hidden" name="id" value="${param.id}" class="form-control"/>

        <div class="row">
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <label for="name">Name:</label>
                    <input type="text" name="name" value="${venue.name}" class="form-control"/>
                </div>
            </div>
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <label for="type">Type:</label>
                    <input type="text" name="type" value="${venue.type}" class="form-control"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <label for="description">Description:</label>
                    <input type="text" name="descripion" class="form-control" value="${venue.description}"/>
                </div>
            </div>
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <label for="location">Location:</label>
                    <input type="text" name="location" value="${venue.location}" class="form-control"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <label for="capacity">Capacity:</label>
                    <input type="number" name="capacity" value="${venue.capacity}" class="form-control"/>
                </div>
            </div>
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <label for="hourlyRate">Booking Fee:</label>
                    <input type="number" name="hourlyRate" value="${venue.bookingFee}" class="form-control"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-4">
                <div class="form-outline">
                    <label for="capacity">Available:</label>
                    <input class="form-check-input" type="radio" name="available" id="ava1" ${venue.available ? 'checked' : ''}>
                    <label class="form-check-label" for="ava1">
                        Avaliable
                    </label>
                    &nbsp&nbsp&nbsp&nbsp&nbsp
                    <input class="form-check-input" type="radio" name="available" id="ava2" ${venue.available ? 'checked' : ''}>
                    <label class="form-check-label" for="ava2">
                        Not Avaliable
                    </label>
                </div>
            </div>
        </div>
        <br>
        <center><input type="submit" class="btn btn-primary" value="Update"/></center>
    </form><br><hr>
    <center><h3 class="offcanvas-title">Hourly Rate Update</h3></center><br><hr>
    <table class="table table-striped">
        <tr>
            <th>Year</th>
            <th>Hourly Rate</th>
            <th>Action</th>
            <th></th>
        </tr>


        <c:forEach var="BookingFee" items="${BookingFees}">
            <tr>
                <td>${BookingFee.year}</td>
                <td>${BookingFee.hourlyRate}</td>
                <c:choose>
                    <c:when test="${empty BookingFee.hourlyRate}">
                        <td><a class="btn btn-primary" href="#">Add</a></td>
                    </c:when>
                </c:choose>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
