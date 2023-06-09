<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

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

<jsp:useBean id="booking" scope="request" class="ict.data_objects.entities.Booking"/>

<center><h3 class="offcanvas-title">Booking Details</h3></center>
<hr>
<c:choose>
    <c:when test="${booking != null && booking.id != 0}">
        <div class="container">
            <table class="table talbe-bordered">
                <tr>
                    <td>Booked On:</td>
                    <td><%= InstantFormatter.format(booking.getRequestedOn(), FormatStyle.MEDIUM) %>
                    </td>
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
                <c:choose>
                    <c:when test="${booking.bookingRequestResponse != null
                                    and booking.bookingRequestResponse.approved}">
                        <tr>
                            <td>Total Booking Fee:</td>
                            <td>${booking.bookingRequestResponse.approvedDetails.bookingFee}</td>
                        </tr>
                        <tr>
                            <td>Payment Receipt:</td>
                            <td>
                                    ${booking.bookingRequestResponse.approvedDetails.paymentReceipt != null
                                ? booking.bookingRequestResponse.approvedDetails.paymentReceipt
                                : "-"}
                            </td>
                        </tr>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${booking.bookingRequestResponse.approvedDetails.paymentConfirmed}" >
                        <tr>
                            <td>Check In:</td>
                            <td>
                                <%=
                                    booking.getVenueUsage() != null
                                            ? InstantFormatter.format(booking.getVenueUsage().getCheckIn(), FormatStyle.MEDIUM)
                                            : "-"
                                %>
                            </td>
                        </tr>
                        <tr>
                            <td>Check Out:</td>
                            <td>
                                <%=
                                booking.getVenueUsage() != null && booking.getVenueUsage().getCheckOut() != null
                                        ? InstantFormatter.format(booking.getVenueUsage().getCheckOut(), FormatStyle.MEDIUM)
                                        : "-"
                                %>
                            </td>
                        </tr>
                        <tr>
                            <td>Member Comments:</td>
                            <td>${booking.venueUsage != null
                                    ? booking.venueUsage.memberComments
                                    : "-"}</td>
                        </tr>
                        <tr>
                            <td>Staff Remarks:</td>
                            <td>${booking.venueUsage != null
                                    ? booking.venueUsage.staffRemarks
                                    : "-"}</td>
                        </tr>
                    </c:when>
                </c:choose>
            </table>
            <br>
        </div>
    </c:when>
</c:choose>

