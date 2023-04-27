<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<jsp:useBean id="booking" scope="request" class="ict.data_objects.entities.Booking" />
<jsp:useBean id="guests" scope="request" class="java.util.ArrayList"/>
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

    <center><h3 class="offcanvas-title">Booking Detail</h3></center>
    <hr>
    <div class="container">
    <table class="table talbe-bordered">
        <tr>
            <td>Booking Date:</td>
            <td>${booking.requestedOn}</td>
        </tr>
        <tr>
            <td>Member Email:</td>
            <td>${booking.booker.info.email}</td>
        </tr>
        <tr>
            <td>Member Phone:</td>
            <td>${booking.booker.info.phone}</td>
        </tr>
        <tr>
            <td>Timeslot:</td>
            <td>${booking.timeSlot}</td>
        </tr>
        <tr>
            <td>Venue Name:</td>
            <td>${booking.venue.name}</td>
        </tr>
        <tr>
            <td>Venue Location:</td>
            <td>${booking.venue.location}</td>
        </tr>
        <tr>
            <td>Booking Approval Status:</td>
            <td>${booking.statusMessage}</td>
        </tr>
        <tr>
            <td>Booking Request Response:</td>
            <td>${booking.bookingRequestResponse == null ? "-" : "TODO"}</td>
        </tr>
    </table>
    <br>
    <table class="table table-bordered">
    <c:forEach var="guest" items="${guests}">
        <tr>
            <td width="50%">${guest.name}</td>
            <td width="50%">${guest.email}</td>
        </tr>
	</c:forEach>
    </table>

    <c:choose>
        <c:when test="${not booking.bookingRequestResponse.approved}">
            <form action="${pageContext.request.contextPath}/booking/response?response=approve" method="post">
                <input type="hidden" name="id" value="${booking.id}">
                <input type="submit" value="Approve">
            </form>
            <form action="${pageContext.request.contextPath}/booking/response?response=decline" method="post">
                <input type="hidden" name="id" value="${booking.id}">
                <input type="submit" value="Decline">
            </form>
        </c:when>
        <c:when test="${BookingRequestResponse.isApproved() and not bookingApproved.isPaymentConfirmed()}">
            <p>Payment not settled yet</p>
        </c:when>
        <c:when test="${booking.approvalStatus.isApproved() and bookingApproved.isPaymentConfirmed()}">
            <form action="" method="post">
                <input type="hidden" name="id" value="${booking.id}">
                <input type="submit" value="Check In" ${VenueUsage.getCheckIn() ? 'disabled' : ''}>
            </form>
            <form action="" method="post">
                <input type="hidden" name="id" value="${booking.id}">
                <input type="submit" value="Check Out" ${VenueUsage.getCheckIn().getCheckOut(0) ? 'disabled' : ''}>
            </form>
            <form action="" method="post">
                <input type="hidden" name="id" value="${booking.id}">
                <label for="remarks">Staff Remarks:</label>
                <input type="text" name="remarks" id="remarks">
                <input type="submit" value="Submit">
            </form>
        </c:when>
    </c:choose>
    </div>
</body>
</html>