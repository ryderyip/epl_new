<%@ page import="ict.data_objects.entities.Venue" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="venue" scope="request" class="ict.data_objects.entities.Venue"/>
<%
    out.println(venue.getName());
%>
</body>
</html>
