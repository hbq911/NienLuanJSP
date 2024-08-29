<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enhanced Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css">
    <style>
        /* General Styles */
        body {
            background: #e9ecef;
            font-family: Arial, sans-serif;
        }

        .dash-content {
            background: #f8f9fa;
            color: #333;
            padding: 20px;
            border-radius: 8px;
        }

        .page-title-box {
            background: #007bff;
            padding: 15px;
            border-radius: 8px;
        }

        .page-title-box h4 {
            color: #fff;
            font-size: 24px;
        }

        .breadcrumb-item a {
            color: #007bff;
        }

        .breadcrumb-item.active {
            color: #fff;
        }

        .card {
            background: #ffffff;
            border: 1px solid #ddd;
            border-radius: 8px;
        }

        .card-body {
            padding: 20px;
        }

        .text-white {
            color: #333 !important;
        }

        .text-white-50 {
            color: rgba(51, 51, 51, 0.7) !important;
        }

        .btn-outline-light {
            border: 1px solid #007bff;
            color: #007bff;
        }

        .btn-light {
            background: #f8f9fa;
            border: 1px solid #ddd;
            color: #333;
        }

        .btn-light:hover {
            background: #e9ecef;
            border-color: #ccc;
        }

        .btn-outline-light:hover {
            background: #007bff;
            color: #fff;
        }

        .dash-troggle-icon {
            position: fixed;
            bottom: 20px;
            right: 20px;
            background: #007bff;
            color: #fff;
            border-radius: 50%;
            padding: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            text-align: center;
            cursor: pointer;
        }

        .dash-troggle-icon i {
            font-size: 24px;
        }

        .hori-overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.3);
            z-index: 1000;
            display: none; /* Change to 'block' to show the overlay */
        }
    </style>
</head>
<body>

<div class="collapse show dash-content" id="dashtoggle">
    <div class="container-fluid">
        <!-- start page title -->
        <div class="row">
            <div class="col-12">
                <div class="page-title-box d-flex align-items-center justify-content-between">
                    <h4 class="mb-0">Welcome !</h4>

                    <div class="page-title-right">
                        <ol class="breadcrumb m-0">
                            <li class="breadcrumb-item"><a href="javascript: void(0);">Dashboard</a></li>
                            <li class="breadcrumb-item active">Welcome !</li>
                        </ol>
                    </div>

                </div>
            </div>
        </div>
        <!-- end page title -->

        <!-- start dash info -->
        <div class="row">
            <div class="col-xl-12">
                <div class="card dash-header-box shadow-none border-0">
                    <div class="card-body p-0">
                        
                        <div class="mt-3 mt-md-0 py-3 px-4 mx-2">
                            <img src="assets/images/QFood1.png" alt="QFood Logo" style="width: 100%; height: auto;" />

                            <p class="text-white-50 mb-2 text-truncate">
                        
                            </p>
                          

                            <button type="button" class="btn btn-outline-light">
                                Xem thêm
                            </button>
                            <button type="button" class="btn btn-outline-light">
                                Mua ngay
                            </button>
                        </div>
                        
                    </div><!-- end card body -->
                </div><!-- end card -->
            </div><!-- end col -->
        </div>
        <!-- end dash info -->
    </div>
</div>

<!-- start dash troggle-icon -->
<div>
    <a class="dash-troggle-icon" id="dash-troggle-icon" data-bs-toggle="collapse" href="#dashtoggle" aria-expanded="true" aria-controls="dashtoggle">
        <i class="bx bx-up-arrow-alt"></i>
    </a>
</div>
<!-- end dash troggle-icon -->

<div class="hori-overlay"></div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
