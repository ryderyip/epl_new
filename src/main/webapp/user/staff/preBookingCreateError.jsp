<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Problem</h1>
    <p>
        <%=(String) request.getAttribute("errorMessage")%>
    </p>
    <a href="javascript:history.back()">Go Back</a>
</body>
</html>