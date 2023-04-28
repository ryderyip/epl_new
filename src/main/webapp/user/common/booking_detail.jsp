<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@ page import="ict.service.InstantFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="ict.data_objects.entities.Booking" %>
<%
    Object bookingObj = request.getAttribute("booking");
    boolean isNoObject = bookingObj == null || ((Booking) bookingObj).getId() == 0;
    if (isNoObject) {
        String id = request.getParameter("id");
        if (id == null || Integer.parseInt(id) == 0)
            response.sendRedirect(request.getContextPath() + "/booking/get");
        else
            response.sendRedirect(request.getContextPath() + "/booking/get?id=" + id);
    }
%>

<jsp:useBean id="booking" scope="request" class="ict.data_objects.entities.Booking" />

<center><h3 class="offcanvas-title">Booking Detail</h3></center>
<hr>
<c:choose>
    <c:when test="${booking != null && booking.id != 0}">
        <div class="container">
            <table class="table talbe-bordered">
                <tr>
                    <td>Booked On:</td>
                    <td><%= InstantFormatter.format(booking.getRequestedOn(), FormatStyle.MEDIUM) %></td>
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
                    <td>${booking.timeslot}</td>
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
        </div>
    </c:when>
</c:choose>

