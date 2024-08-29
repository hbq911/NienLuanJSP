

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<div class="main-content">

    <div class="page-content">
        <div class="container-fluid">

            <div class="row">
                <div class="col-xl-8">
                    <div class="card border shadow-none">
                        <c:set var="total" value="0"></c:set>
                        <c:forEach items="${cart}" var="p">
                            <div class="card-body">
                                <div class="d-flex align-items-start border-bottom pb-3">
                                    <div class="me-4">
                                        <img src="getImage?id=${p.id}" alt="" class="avatar-lg">
                                    </div>
                                    <div class="flex-grow-1 align-self-center overflow-hidden">
                                        <div>
                                            <h5 class="text-truncate font-size-17">
                                                <a href="ecommerce-product-detail-1.html" class="text-dark">${p.name}</a>
                                            </h5>
                                        </div>
                                    </div>
                                    <div class="flex-shrink-0 ms-2">
                                        <ul class="list-inline mb-0 font-size-16">
                                            <!-- Thẻ <a> cho chức năng Update -->
                                            <li class="list-inline-item">
                                                <form action="cart" method="post" style="display:inline;">
                                                    <input type="hidden" name="action" value="update">
                                                    <input type="hidden" name="id_product" value="${p.id}">
                                                    <input type="hidden" name="quantity" id="quantity_${p.id}" value="${p.quantity}">
                                                    <button type="submit" class="btn btn-link p-0" style="text-decoration: none;">
                                                        <i class="mdi mdi-pencil font-size-18"></i>
                                                    </button>
                                                </form>
                                            </li>
                                            <!-- Thẻ <a> cho chức năng Delete -->
                                            <li class="list-inline-item">
                                                <form action="cart" method="post" style="display:inline;">
                                                    <input type="hidden" name="action" value="delete">
                                                    <input type="hidden" name="id_product" value="${p.id}">
                                                    <button type="submit" class="btn btn-link p-0" style="text-decoration: none;">
                                                        <i class="mdi mdi-delete font-size-18"></i>
                                                    </button>
                                                </form>
                                            </li>
                                        </ul>
                                    </div>
                                </div>

                                <div>
                                    <div class="row align-items-center">
                                        <!-- Phần Price -->
                                        <div class="col-md-4">
                                            <div class="mt-3">
                                                <p class="text-muted mb-2">Price</p>
                                                <h5 class="font-size-16 mb-0">$${p.price}</h5>
                                            </div>
                                        </div>
                                        <!-- Phần Quantity -->
                                        <div class="col-md-4">
                                            <div class="mt-3">
                                                <p class="text-muted mb-2">Quantity</p>
                                                <form action="cart" method="post" style="display: flex; align-items: center;">
                                                    <input type="hidden" name="id_product" value="${p.id}">
                                                    <input type="text" name="quantity" value="${p.quantity}" style="width: 60px; text-align: center; margin-left: 10px;" oninput="document.getElementById('quantity_${p.id}').value = this.value;">
                                                </form>
                                            </div>
                                        </div>
                                        <!-- Phần Total -->
                                        <div class="col-md-4">
                                            <div class="mt-3">
                                                <p class="text-muted mb-2">Total</p>
                                                <h5 class="font-size-16 mb-0">$${p.quantity * p.price}</h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <c:set var="total" value="${total + p.quantity * p.price}"></c:set>
                        </c:forEach>



                    </div>

                    <div class="row my-4">
                        <div class="col-sm-6">
                            <a href="#" class="btn btn-link text-muted">
                                <i class="mdi mdi-arrow-left me-1"></i> Continue Shopping </a>
                        </div> <!-- end col -->
                        <div class="col-sm-6">
                            <div class="text-sm-end mt-2 mt-sm-0">
                                <form action="checkout" method="post">
                                 <button type="submit">
                                    <i class="mdi mdi-cart-outline me-1"></i> Checkout </button>
                                    </form>
                            </div>
                        </div> <!-- end col -->
                    </div> <!-- end row-->
                </div>

                <div class="col-xl-4">
                    <div class="mt-5 mt-lg-0">
                        <div class="card border shadow-none">
                            <div class="card-header bg-transparent border-bottom py-3 px-4">
                                <h5 class="font-size-16 mb-0">Chi Tiết Hóa Đơn <span class="float-end">#MN0124</span></h5>
                            </div>
                            <div class="card-body p-4 pt-2">

                                <div class="table-responsive">
                                    <table class="table mb-0">
                                        <tbody>
                                            <tr>
                                                <td>Sub Total :</td>
                                                <td class="text-end">$ ${total}</td>
                                            </tr>
                                            <tr>
                                                <td>VAT : </td>
                                                <td class="text-end">$ ${total *0.1}</td>
                                            </tr>


                                            <tr class="bg-light">
                                                <th>Total :</th>
                                                <td class="text-end">
                                                    <span class="fw-bold">
                                                        $ ${total *1.1}
                                                    </span>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- end table-responsive -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end row -->

        </div> <!-- container-fluid -->
    </div>
    <!-- End Page-content -->

