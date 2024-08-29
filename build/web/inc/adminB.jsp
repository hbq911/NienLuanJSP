<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="main-content">

                <div class="page-content">
                    <div class="container-fluid">

                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-body" >
                                        <div class="row mb-2">
                                            <div class="col-sm-4">
                                                <div class="search-box me-2 mb-2 d-inline-block">
                                                    <div class="position-relative">
                                                        <input type="text" class="form-control" placeholder="Search...">
                                                        <i class="bx bx-search search-icon"></i>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-8">
                                                <div class="text-sm-end">
                                                    <a href="add" class="btn btn-success btn-rounded waves-effect waves-light mb-2 me-2">
                                                        <i class="mdi mdi-plus me-1"></i> Add New
                                                    </a>

                                                </div>
                                            </div><!-- end col-->
                                        </div>

                                        <div class="table-responsive">
                                            <table class="table align-middle table-nowrap table-check">
                                                <thead class="table-light">
                                                    <tr>
                                                        <th style="width: 20px;" class="align-middle">
                                                            <div class="form-check font-size-16">
                                                                <input class="form-check-input" type="checkbox" id="checkAll">
                                                                <label class="form-check-label" for="checkAll"></label>
                                                            </div>
                                                        </th>
                                                        <th class="align-middle"> ID</th>
                                                        <th class="align-middle">Name</th>
                                                        <th class="align-middle">image</th>
                                                        <th class="align-middle">price</th>
                                                        <th class="align-middle"> Status</th>
                                                        <th class="align-middle">Payment Method</th>
                                                        <th class="align-middle">Quantity</th>
                                                        <th class="align-middle">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${list}" var="c">
                                                        <c:forEach items="${listP}" var="p">
                                                            <c:if test="${c.id == p.id_category}">
                                                                <tr>
                                                                    <td>
                                                                        <div class="form-check font-size-16">
                                                                            <input class="form-check-input" type="checkbox" id="orderidcheck01">
                                                                            <label class="form-check-label" for="orderidcheck01"></label>
                                                                        </div>
                                                                    </td>
                                                                    <td><a href="javascript:void(0);" class="text-body fw-bold">#${p.id}</a></td>
                                                                    <td style="max-width: 100px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">${p.name}</td>
                                                                    <td>
                                                                        <img src="getImage?id=${p.id}" style="width: 50px; height: 50px;" class="img-fluid" alt="">
                                                                    </td>
                                                                    <td>${p.price}</td>
                                                                    <td>
                                                                        <span class="badge badge-soft-primary">${p.status}</span>
                                                                    </td>
                                                                    <td>
                                                                        <i class="fab fa-cc-mastercard me-1"></i> Mastercard
                                                                    </td>
                                                                    <td>
                                                                        <!-- Button trigger modal -->
                                                                        ${p.quantity}
                                                                    </td>
                                                                    <td>
                                                                        <div class="d-flex gap-3">
                                                                            <!-- Link trigger modal -->
                                                                            <a href="javascript:void(0);" class="text-success" data-bs-toggle="modal" data-bs-target="#editProductModal${p.id}">
                                                                                <i class="mdi mdi-pencil font-size-18"></i>
                                                                            </a>

                                                                            <!-- Modal for editing product -->
                                                                            <div class="modal fade" id="editProductModal${p.id}" tabindex="-1" aria-labelledby="editProductModalLabel${p.id}" aria-hidden="true">
                                                                                <div class="modal-dialog">
                                                                                    <div class="modal-content">
                                                                                        <div class="modal-header">
                                                                                            <h5 class="modal-title" id="editProductModalLabel${p.id}">Edit Product</h5>
                                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                                        </div>
                                                                                        <div class="modal-body">
                                                                                            <form action="admin?action=update" method="post" enctype="multipart/form-data">
                                                                                                <input type="hidden" name="id" value="${p.id}" />

                                                                                                <div class="mb-3">
                                                                                                    <label for="name" class="form-label">Product Name:</label>
                                                                                                    <input type="text" id="name" name="name" class="form-control" value="${p.name}" required />
                                                                                                </div>
                                                                                                <div class="mb-3">
                                                                                                    <label for="image" class="form-label">Image:</label>
                                                                                                    <input type="file" id="image" name="image" class="form-control" />
                                                                                                </div>
                                                                                                <div class="mb-3">
                                                                                                    <label for="price" class="form-label">Price:</label>
                                                                                                    <input type="number" id="price" name="price" class="form-control" value="${p.price}" required />
                                                                                                </div>
                                                                                                <div class="mb-3">
                                                                                                    <label for="quantity" class="form-label">Quantity:</label>
                                                                                                    <input type="number" id="quantity" name="quantity" class="form-control" value="${p.quantity}" required />
                                                                                                </div>
                                                                                                <div class="mb-3">
                                                                                                    <label for="id_category" class="form-label">Category ID:</label>
                                                                                                    <input type="number" id="id_category" name="id_category" class="form-control" value="${p.id_category}" required />
                                                                                                </div>
                                                                                                <button type="submit" class="btn btn-primary">Update Product</button>
                                                                                            </form>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                            <a href="admin?action=delete&id=${p.id}" class="text-danger">
                                                                                <i class="mdi mdi-delete font-size-18"></i>
                                                                            </a>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </c:if>
                                                        </c:forEach>
                                                    </c:forEach>



                                                </tbody>

                                            </table>
                                        </div>
                                        <ul class="pagination pagination-rounded justify-content-end mb-2">
                                            <li class="page-item disabled">
                                                <a class="page-link" href="javascript: void(0);" aria-label="Previous">
                                                    <i class="mdi mdi-chevron-left"></i>
                                                </a>
                                            </li>
                                            <li class="page-item active"><a class="page-link" href="javascript: void(0);">1</a></li>
                                            <li class="page-item"><a class="page-link" href="javascript: void(0);">2</a></li>
                                            <li class="page-item"><a class="page-link" href="javascript: void(0);">3</a></li>
                                            <li class="page-item"><a class="page-link" href="javascript: void(0);">4</a></li>
                                            <li class="page-item"><a class="page-link" href="javascript: void(0);">5</a></li>
                                            <li class="page-item">
                                                <a class="page-link" href="javascript: void(0);" aria-label="Next">
                                                    <i class="mdi mdi-chevron-right"></i>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- end row -->

                    </div> <!-- container-fluid -->
                </div>
                <!-- End Page-content -->

                <!-- Modal -->
                <c:forEach items="${listP}" var="p">
                    <div class="modal fade" id="orderdetailsModal${p.id}" tabindex="-1" role="dialog" aria-labelledby="orderdetailsModalLabel${p.id}" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="orderdetailsModalLabel${p.id}">Order Details</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>

                                <div class="modal-body">
                                    <p class="mb-2">Product id: <span class="text-primary">#${p.id}</span></p>
                                    <p class="mb-4">Billing Name: <span class="text-primary">${p.name}</span></p>

                                    <div class="table-responsive">
                                        <table class="table align-middle table-nowrap">
                                            <thead>
                                                <tr>
                                                    <th scope="col">Product</th>
                                                    <th scope="col">Product Name</th>
                                                    <th scope="col">Price</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <th scope="row">
                                                        <div>

                                                            <img src="getImage?id=${p.id}" alt="" class="avatar-lg">
                                                        </div>
                                                    </th>
                                                    <td>
                                                        <div>
                                                            <h5 class="text-truncate font-size-16">${p.name}</h5>
                                                            <p class="text-muted mb-0">$ ${p.price} x 1</p>
                                                        </div>
                                                    </td>
                                                    <td>$ ${p.price}</td>
                                                </tr>
                                                <!-- Các sản phẩm khác có thể được thêm vào đây -->
                                                <tr>
                                                    <td colspan="2">
                                                        <h6 class="m-0 text-right">Sub Total:</h6>
                                                    </td>
                                                    <td>
                                                        $ ${p.price}
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="2">
                                                        <h6 class="m-0 text-right">Shipping:</h6>
                                                    </td>
                                                    <td>
                                                        Free
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="2">
                                                        <h6 class="m-0 text-right">Total:</h6>
                                                    </td>
                                                    <td>
                                                        $ ${p.price}
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>

                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>