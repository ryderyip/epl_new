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
        <title>Register Page</title>
    </head>
    <body>
        <section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
            
            <form>

              <div class="row">
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                    <label class="form-label" for="username">Username</label>
                    <input type="text" id="username" name="username" class="form-control form-control-lg" required/>
                    
                  </div>

                </div>
                <div class="col-md-6 mb-4">

                  <div class="form-outline">
                    <label class="form-label" for="password">Password</label>
                    <input type="text" id="password" name="password" class="form-control form-control-lg" required/>
                  </div>

                </div>
              </div>

              <div class="row">
                <div class="col-md-6 mb-4 d-flex align-items-center">

                  <div class="form-outline datepicker w-100">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control form-control-lg" id="name" name="name" required/>    
                  </div>

                </div>
                  
                <div class="col-md-6 mb-4">
                  <h6 class="mb-2 pb-1">Gender: </h6>
                  
                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="mgender"
                      value="male" checked />
                    <label class="form-check-label" for="mgender">Male</label>
                  </div>

                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="fgender"
                      value="female" />
                    <label class="form-check-label" for="fgender">Female</label>
                  </div>
                </div>
              </div>

              <div class="row">
                <div class="col-md-6 mb-4 pb-2">
                  <div class="form-outline">
                      <label class="form-label" for="emailAddress">Email</label>
                      <input type="email" id="emailAddress" name="email" class="form-control form-control-lg" required/>
                  </div>
                </div>
                  
                <div class="col-md-6 mb-4 pb-2">
                  <div class="form-outline">
                    <label class="form-label" for="phoneNumber">Phone Number (8 digit)</label>
                    <input type="text" pattern="[0-9]{8}" id="phoneNumber" name="phone" class="form-control form-control-lg" required/>
                  </div>
                </div>
              </div>

              <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
              </div>
            </form>
            <br>
            Already have account? <a href="login.jsp">Login</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
    </body>
</html>
