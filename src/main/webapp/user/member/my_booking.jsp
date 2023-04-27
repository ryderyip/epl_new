<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<jsp:useBean id="booking" scope="request" class="ict.data_objects.entities.Booking"/>
<jsp:useBean id="bookingResponse" scope="request" class="ict.data_objects.entities.BookingRequestResponse"/>
<!doctype html>
<html lang="en">
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
      <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
      <title>Booking</title>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
    <nav class="navbar bg-body-tertiary fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="member_frontpage.jsp">EPL Booking</a>
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
                            <a class="nav-link" aria-current="page" href="member_frontpage.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="member_booking.jsp">Venue Booking</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="my_booking.jsp">Booking Management</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav><br><br><br>
    <!----End Navbar---->
    
     <center><h3 class="offcanvas-title">Booking Details</h3></center>
    <hr>
    <div class="container">
    <table class="table table-bordered">
        <tr>
            <td><label class="form-label">Email:</label><br>
            ${booking.email}</td>
            <td><label class="form-label">Phone:</label><br>
            ${booking.phone}</td>
        </tr>
        <tr>
            <td><label class="form-label">Booking Request Response:</label><br>
            ${booking.request_response}</td>
            <td><label class="form-label">Timeslot: </label><br>
            ${booking.timeslot}</td>
        </tr>
        <tr>
            <td><label class="form-label">Booking Date:</label><br>
            ${booking.date}</td>
            <td><label class="form-label">Venue: </label><br>
            ${booking.venue}</td>
        </tr>
        <tr>
            <td width="50%"><label class="form-label">Venue Location:</label><br>
            ${booking.location}</td>
            <td><label class="form-label">Booking Approval Status:</label><br>
            ${booking.status} <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Pay</button>
            </td>
        </tr>
    </table>
    <ul>
        <li>Check-in Time: ${booking.check_in_time}</li>
        <li>Check-out Time: ${booking.check_out_time}</li>
        <li>Check-out Remarks: ${booking.check_out_remarks}</li>
        <li>Member Comments: ${booking.member_comments}</li
    </ul>
    </div>
    <hr>
	
    <c:if test="${booking.checked_in}">
	<form action="#" method="post">
            <label for="member_comments">Member Comments:</label><br>
            <textarea id="member_comments" name="member_comments"></textarea><br>
            <input type="submit" value="Comments">
	</form>
    </c:if>
    <div class="container">
    <center>
        <form action="#" method="post">
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
                <c:forEach var="guest" items="${guest}">
                <tr>
                    <td><input type="text" name="name[]" class="form-control" placeholder="Name" value="${guest.name}" required></td>
                    <td><input type="email" name="email[]" class="form-control"  placeholder="Email" value="${guest.email}" required></td>
                    <td><button type="button" class="btn btn-danger" onclick="removeRow(this)">Remove</button></td>
                </tr>
		</c:forEach>
                <tr>
                    <td><input type="text" name="name[]" class="form-control" placeholder="Name" required></td>
                    <td><input type="email" name="email[]" class="form-control"  placeholder="Email" required></td>
                    <td><button type="button" class="btn btn-danger" onclick="removeRow(this)">Remove</button></td>
                </tr>
            </tbody>
        </table>
        <br><br>
        <button type="button" class="btn btn-primary" onclick="addGuest()">Add Guest</button>
        <hr>
        <input type="submit" class="btn btn-primary" value="Save">
        </form>
    </center>
    </div>

    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Payment</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form method="post" action="${pageContext.request.contextPath}/booking/payment/pay">
                    <div class="modal-body">
                        <input type="hidden" name="bookingId" value="<%=request.getAttribute("bookingId")%>">
                        Booking Fee:<%=request.getAttribute("bookingFee")%><br>
                        Upload:<input type="file" name="upload">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Upload</button>
                    </div>
                </form>
            </div>
        </div>
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