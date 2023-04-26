<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Registration Failed</h1>
    <p>
        Error Message: <%=(String) request.getAttribute("errorMessage")%>
    </p>
    <a href="javascript:history.back()">Go Back</a>
</body>
</html>
