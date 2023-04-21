<%@ page import="ict.data_objects.entities.Venue" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="venues" scope="request" class="java.util.ArrayList"/>
    <body>
        <%
            out.println("<h1>Venues</h1>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Venue Name</th>");
            out.println("</tr>");
            for (Object customer : venues) {
                Venue c = (Venue) customer;
                out.println("<tr>");
                out.println("<td>" + c.getName() + "</td>");
                out.println("<a href=\""+ request.getContextPath()+"/venue/get?id="+ c.getId() +"\">Go detail page</a>");
                out.println("</tr>");
            }
            out.println("</table>");
        %>
    </body>
</html>
