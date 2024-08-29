
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
                                                    <h5 class="mb-0"> Chào Mừng Bạn Trở Lại !</h5>
                                                    <p class="text-muted mt-2">Hãy Kết Nối Với QFood.</p>
                                                </div>
                                                <form action="" method="post">
                                                    <div class="form-floating form-floating-custom mb-3">
                                                        <input type="text" name="emailphone" class="form-control " />
                                                        <label for="emailphone">Email or number </label>
                                                        <div class="form-floating-icon">
                                                            <i class="uil uil-users-alt"></i>
                                                        </div>
                                                    </div>
                                                    <div class="form-floating form-floating-custom mb-3 auth-pass-inputgroup">
                                                        <input type="password" name="password" class="form-control "/>
                                                        
                                                        <label for="password">Password</label>
                                                        <div class="form-floating-icon">
                                                            <i class="uil uil-padlock"></i>
                                                        </div>
                                                    </div>
                                                    <div class="form-check form-check-primary font-size-16 py-1">
                                                        <input class="form-check-input" type="checkbox" id="remember-check">
                                                        <div class="float-end">
                                                            <a href="auth-resetpassword-basic.html" class="text-muted text-decoration-underline font-size-14">Forgot your password?</a>
                                                        </div>
                                                        <label class="form-check-label font-size-14" for="remember-check">
                                                            Remember me
                                                        </label>
                                                    </div>

                                                    <div class="mt-3">
                                                        <button class="btn btn-primary w-100" type="submit">Log In</button>
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
                                                        <p class="text-muted mb-0">Don't have an account ? <a href="auth-signup-cover.html" class="fw-semibold text-decoration-underline"> Signup Now </a> </p>
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

        <script src="assets/js/pages/pass-addon.init.js"></script>

    </body>
</html>
