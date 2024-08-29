
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-xxl-9 col-lg-8 col-md-7">
                        <div class="auth-bg bg-light py-md-5 p-4 d-flex">
                            <div class="bg-overlay-gradient"></div>
                            <!-- end bubble effect -->
                            <div class="row justify-content-center g-0 align-items-center w-100">
                                <div class="col-xl-4 col-lg-8">
                                    <div class="card">
                                        <div class="card-body">
                                            <div class="px-3 py-3">
                                                <div class="text-center">
                                                    <h5 class="mb-0">Register Account</h5>
                                                    <p class="text-muted mt-2">Get your free Vuesy account now.</p>
                                                </div>
                                                <form class="mt-4 pt-2" action="" method="post">
                                                    <div class="form-floating form-floating-custom mb-3">
                                                        <input type="text" class="form-control" id="name" name="name" placeholder="Enter Email" required="">
                                                        <label for="name">Your Name</label>
                                                    </div>
                                                    <div class="form-floating form-floating-custom mb-3">
                                                        <input type="text" class="form-control" id="email" name="email" placeholder="Enter Email" required="">
                                                        <label for="email">Your Email</label>
                                                    </div>
                                                    <div class="form-floating form-floating-custom mb-3">
                                                        <input type="text" class="form-control" id="phone" name="phone" placeholder="Enter Email" required="">
                                                        <label for="phone">Your Phone</label>
                                                    </div>
                                                    <div class="form-floating form-floating-custom mb-3">
                                                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
                                                        <label for="password">Password</label>
                                                        <div class="form-floating-icon">
                                                            <i class="uil uil-padlock"></i>
                                                        </div>
                                                    </div>
                                                    <div class="form-floating form-floating-custom mb-3">
                                                        <input type="password" class="form-control" id="repassword" name="repassword" placeholder="Enter Password">
                                                        <label for="repassword">repassword</label>
                                                        <div class="form-floating-icon">
                                                            <i class="uil uil-padlock"></i>
                                                        </div>
                                                    </div>
                
                                                    <div class="py-1">
                                                        <p class="mb-0">By registering you agree to the Vuesy <a href="#" class="text-primary">Terms of Use</a></p>
                                                    </div>
                
                                                    <div class="mt-3">
                                                        <button class="btn btn-primary w-100" type="submit">Register</button>
                                                    </div>
            
                                                    <div class="mt-4 text-center">
                                                        <div class="signin-other-title">
                                                            <h5 class="font-size-15 mb-4 text-muted fw-medium">- Or you can join with -</h5>
                                                        </div>
            
                                                        <div class="d-flex gap-2">
                                                            <button type="button" class="btn btn-soft-primary waves-effect waves-light w-100">
                                                                <i class="bx bxl-facebook font-size-16 align-middle"></i> 
                                                            </button>
                                                            <button type="button" class="btn btn-soft-info waves-effect waves-light w-100">
                                                                <i class="bx bxl-linkedin font-size-16 align-middle"></i> 
                                                            </button>
                                                            <button type="button" class="btn btn-soft-danger waves-effect waves-light w-100">
                                                                <i class="bx bxl-google font-size-16 align-middle"></i> 
                                                            </button>
                                                        </div>
                                                    </div>
            
                                                    <div class="mt-4 pt-3 text-center">
                                                        <p class="text-muted mb-0">Already have an account ? <a href="auth-signin-cover.html" class="fw-semibold text-decoration-underline"> Login </a> </p>
                                                    </div>
                
                                                </form><!-- end form -->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- end col -->
 
        <!-- end authentication section -->

        <!-- JAVASCRIPT -->
        <script src="assets/libs/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/libs/metismenujs/metismenujs.min.js"></script>
        <script src="assets/libs/simplebar/simplebar.min.js"></script>
        <script src="assets/libs/feather-icons/feather.min.js"></script>

    </body>
</html>
