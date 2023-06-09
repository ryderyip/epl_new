<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%
    if (request.getAttribute("booking") == null) {
        String id = request.getParameter("id");
        if (id == null) 
            response.sendRedirect(request.getContextPath() + "/booking/get");
        else
            response.sendRedirect(request.getContextPath() + "/booking/get?id=" + id);
    }
%>
<jsp:useBean id="booking" scope="request" class="ict.data_objects.entities.Booking" />
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
            <a class="navbar-brand" href="${pageContext.request.contextPath}/user/staff/staff_frontpage.jsp">EPL Booking</a>
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
                            <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/user/staff/staff_frontpage.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/user/staff/venue_detail.jsp">Venue Management</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="${pageContext.request.contextPath}/user/staff/booking_list.jsp">Booking Management</a>
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

    <jsp:include page="/user/common/booking_detail.jsp">
        <jsp:param name="id" value="${booking.id}"/>
    </jsp:include>
    
    <hr>
    <div class="container">
    <center><h4 class="offcanvas-title">Guests</h4></center>
    <table class="table table-striped">
        <tr>
            <th width="45%">Name</th>
            <th width="10%">&nbsp</th>
            <th width="45%">Email</th>
        </tr>
    <c:forEach var="guest" items="${booking.guests}">
        <tr>
            <td width="45%">${guest.name}</td>
            <td width="10%">&nbsp</td>
            <td width="45%">${guest.email}</td>
        </tr>
	</c:forEach>
    </table>

    <c:choose>
        <c:when test="${booking.bookingRequestResponse == null}">
            <center>
            <form action="${pageContext.request.contextPath}/booking/response?response=approve" method="post">
                <input type="hidden" name="id" value="${booking.id}">
                <input type="submit" value="Approve" class="btn btn-primary">
            </form>
            <form action="${pageContext.request.contextPath}/booking/response?response=decline" method="post">
                <input type="hidden" name="id" value="${booking.id}">
                <input type="submit" value="Decline" class="btn btn-danger">
            </form>
            </center>
        </c:when>
        <c:when test="${booking.bookingRequestResponse != null 
                        and booking.bookingRequestResponse.approved
                        and booking.bookingRequestResponse.approvedDetails.paymentReceipt != null
                        and not booking.bookingRequestResponse.approvedDetails.paymentConfirmed}">
            <form action="${pageContext.request.contextPath}/booking/update/staff" method="post">
                <input type="hidden" name="bookingId" value="${booking.id}">
                <input type="hidden" name="action" value="confirmpay">
                <input type="submit" value="Confirm Payment">
            </form>
        </c:when>
        <c:when test="${booking.bookingRequestResponse != null 
                        and booking.bookingRequestResponse.approved
                        and booking.bookingRequestResponse.approvedDetails.paymentConfirmed}">
            <c:choose>
                <c:when test="${booking.venueUsage == null}">
                    <form action="${pageContext.request.contextPath}/booking/update/staff" method="post">
                        <input type="hidden" name="bookingId" value="${booking.id}">
                        <input type="hidden" name="action" value="checkin">
                        <input type="submit" value="Check In">
                    </form>
                </c:when>
                <c:when test="${booking.venueUsage != null && booking.venueUsage.checkOut == null}">
                    <form action="${pageContext.request.contextPath}/booking/update/staff" method="post">
                        <input type="hidden" name="bookingId" value="${booking.id}">
                        <input type="hidden" name="action" value="checkout">
                        <input type="submit" value="Check Out">
                    </form>
                </c:when>
                <c:when test="${booking.venueUsage.checkOut != null}">
                    <form action="${pageContext.request.contextPath}/booking/update/staff" method="post">
                        <input type="hidden" name="action" value="remark">
                        <input type="hidden" name="bookingId" value="${booking.id}">
                        <label for="remarks">Staff Remarks:</label>
                        <textarea name="remarks" id="remarks">${booking.venueUsage.staffRemarks}</textarea>
                        <br>
                        <input type="submit" value="Update">
                    </form>
                </c:when>
            </c:choose>
        </c:when>
    </c:choose>
    </div>
</body>
</html>