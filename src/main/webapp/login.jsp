<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
        <title>Login Page</title>
    </head>
    <body>
        <nav class="navbar bg-body-tertiary fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp">EPL Booking</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            
            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
                <div class="offcanvas-header">
                    <h3 class="offcanvas-title" id="offcanvasNavbarLabel">Guest</h3>
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                
                <div class="offcanvas-body">
                    
                    <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="login.jsp">Sign in</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register.jsp">Sign up</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        </nav>
    
        <main>
            <div class="container">
                <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
                            <div class="card mb-3">
                                <div class="card-body">
                                <div class="pt-4 pb-2">
                                    <h1 class="card-title text-center pb-0 fs-4">EPL Booking</h1>
                                    <p class="text-center small">Enter your username & password to login</p>
                                </div>
                                
                                <form class="row g-3 needs-validation" method="POST" action="login">
                
                                    <div class="col-12">
                                    <label for="username" class="form-label">Username</label>
                                    <div class="input-group has-validation">
                                        <input type="text" name="username" class="form-control" id="username" required>
                                        <div class="invalid-feedback">Please enter your username.</div>
                                    </div>
                                    </div>
                
                                    <div class="col-12">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" name="password" class="form-control" id="password" required>
                                    <div class="invalid-feedback">Please enter your password!</div>
                                    </div>
        
                                    <div class="col-12">
                                    <button class="btn btn-primary w-100" type="submit">Login</button>
                                    </div>
                                    <div class="col-12">
                                        <p class="small mb-0">Don't have account? <a href="register.jsp">Create an account</a></p>
                                    </div>
                                </form>
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
