<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${contextPath}/css/style.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Login</title>
  </head>
  <body>
      <main>
            <div class="container">
                <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
                            <div class="card mb-3">
                                <div class="card-body">
                                <div class="pt-4 pb-2">
                                    <h1 class="card-title text-center pb-0 fs-4">Login Failed</h1>
                                    <span class="text-center small">Invalid username or password!</span>
                                    <span class="text-center small">Please <%out.println("<u><a href=\"" + request.getContextPath() + "/login.jsp\">Login again</a></u>");%></span><br>
                                </div>
                                </div>
                            </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </main>
  </body>
</html>
