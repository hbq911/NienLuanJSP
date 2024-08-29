<%@page import="java.util.ArrayList"%>
<%@page import="deamor.model.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<div class="main-content">
    <div class="page-content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-3 col-lg-4">
                    <div class="card">
                        <div class="p-4 border-top">
                                <div>
                                    <h5 class="font-size-15 mb-0"><a href="#filtersizes-collapse" class="text-dark d-block" data-bs-toggle="collapse">Danh mục <i class="mdi mdi-chevron-up float-end accor-down-icon"></i></a></h5>

                                    <div class="collapse show" id="filtersizes-collapse">
                                        <div class="mt-4">
                                            <div class="d-flex align-items-center">
                                                <div class="flex-grow-1">
                                                    <h5 class="font-size-15 mb-0">Chọn danh mục </h5>
                                                </div>
                                                <div class="w-xs">
                                                    <select class="form-select">
                                                        <option value="1">Tìm kiếm nhiều nhất</option>
                                                        <option value="2">Mua nhiều nhất</option>
                                                        <option value="3">Ưu đãi nhất</option>
                                                        <option value="3">Đang giảm giá</option>
                                       
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                        <div class="p-4 border-top">
                                <div>
                                    <h5 class="font-size-15 mb-0"><a href="#filtersizes-collapse" class="text-dark d-block" data-bs-toggle="collapse">Mức giá <i class="mdi mdi-chevron-up float-end accor-down-icon"></i></a></h5>

                                    <div class="collapse show" id="filtersizes-collapse">
                                        <div class="mt-4">
                                            <div class="d-flex align-items-center">
                                                <div class="flex-grow-1">
                                                    <h5 class="font-size-15 mb-0">Chọn mức giá </h5>
                                                </div>
                                                <div class="w-xs">
                                                    <select class="form-select">
                                                        <option value="1">Dưới 30000</option>
                                                        <option value="2">Dưới 50000</option>
                                                        <option value="3">Dưới 100000</option>
                                       
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                        <div class="custom-accordion">
                            <div class="p-4 border-top">
                                <div>
                                    <h5 class="font-size-15 mb-0"><a href="#filtersizes-collapse" class="text-dark d-block" data-bs-toggle="collapse">Sizes đồ uống <i class="mdi mdi-chevron-up float-end accor-down-icon"></i></a></h5>

                                    <div class="collapse show" id="filtersizes-collapse">
                                        <div class="mt-4">
                                            <div class="d-flex align-items-center">
                                                <div class="flex-grow-1">
                                                    <h5 class="font-size-15 mb-0">Chọn Sizes</h5>
                                                </div>
                                                <div class="w-xs">
                                                    <select class="form-select">
                                                        <option value="1">S</option>
                                                        <option value="2">M</option>
                                                        <option value="3">L</option>
                                       
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <div class="p-4 border-top">
                                <!-- <div>
                                    <h5 class="font-size-15 mb-0"><a href="#filterprodductcolor-collapse" class="text-dark d-block" data-bs-toggle="collapse">Colors <i class="mdi mdi-chevron-up float-end accor-down-icon"></i></a></h5>

                                    <div class="collapse show" id="filterprodductcolor-collapse">
                                        <div class="mt-4">
                                            <div class="form-check mt-2">
                                                <input type="checkbox" class="form-check-input" id="productcolorCheck1">
                                                <label class="form-check-label" for="productcolorCheck1"><i class="mdi mdi-circle text-dark mx-1"></i> Black</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="checkbox" class="form-check-input" id="productcolorCheck2">
                                                <label class="form-check-label" for="productcolorCheck2"><i class="mdi mdi-circle text-light mx-1"></i> White</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="checkbox" class="form-check-input" id="productcolorCheck3">
                                                <label class="form-check-label" for="productcolorCheck3"><i class="mdi mdi-circle text-secondary mx-1"></i> Gray</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="checkbox" class="form-check-input" id="productcolorCheck4">
                                                <label class="form-check-label" for="productcolorCheck4"><i class="mdi mdi-circle text-primary mx-1"></i> Blue</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="checkbox" class="form-check-input" id="productcolorCheck5">
                                                <label class="form-check-label" for="productcolorCheck5"><i class="mdi mdi-circle text-success mx-1"></i> Green</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="checkbox" class="form-check-input" id="productcolorCheck6">
                                                <label class="form-check-label" for="productcolorCheck6"><i class="mdi mdi-circle text-danger mx-1"></i> Red</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="checkbox" class="form-check-input" id="productcolorCheck7">
                                                <label class="form-check-label" for="productcolorCheck7"><i class="mdi mdi-circle text-warning mx-1"></i> Yellow</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="checkbox" class="form-check-input" id="productcolorCheck8">
                                                <label class="form-check-label" for="productcolorCheck8"><i class="mdi mdi-circle text-purple mx-1"></i> Purple</label>
                                            </div>
                                        </div>
                                    </div>

                                </div> -->
                            </div>

                            <div class="p-4 border-top">
                                <div>
                                    <h5 class="font-size-15 mb-0"><a href="#filterproduct-color-collapse" class="text-dark d-block" data-bs-toggle="collapse">Đánh giá của khách hàng <i class="mdi mdi-chevron-up float-end accor-down-icon"></i></a></h5>

                                    <div class="collapse show" id="filterproduct-color-collapse">
                                        <div class="mt-4">
                                            <div class="form-check mt-2">
                                                <input type="radio" id="productratingRadio1" name="productratingRadio1" class="form-check-input">
                                                <label class="form-check-label" for="productratingRadio1">5 <i class="mdi mdi-star text-warning"></i>  </label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="radio" id="productratingRadio1" name="productratingRadio1" class="form-check-input">
                                                <label class="form-check-label" for="productratingRadio1">4 <i class="mdi mdi-star text-warning"></i>  Trở lên</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="radio" id="productratingRadio2" name="productratingRadio1" class="form-check-input">
                                                <label class="form-check-label" for="productratingRadio2">3 <i class="mdi mdi-star text-warning"></i>  Trở lên</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="radio" id="productratingRadio3" name="productratingRadio1" class="form-check-input">
                                                <label class="form-check-label" for="productratingRadio3">2 <i class="mdi mdi-star text-warning"></i>  Trở lên</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="radio" id="productratingRadio4" name="productratingRadio1" class="form-check-input">
                                                <label class="form-check-label" for="productratingRadio4">1 <i class="mdi mdi-star text-warning"></i></label>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                            <div class="p-4 border-top">
                                <div>
                                    <h5 class="font-size-15 mb-0"><a href="#filterproduct-discount-collapse" class="text-dark d-block" data-bs-toggle="collapse">Đánh giá <i class="mdi mdi-chevron-up float-end accor-down-icon"></i></a></h5>

                                    <div class="collapse show" id="filterproduct-discount-collapse">
                                        <div class="mt-4">
                                            <div class="form-check mt-2">
                                                <input type="radio" id="productdiscountRadio1" name="productdiscountRadio" class="form-check-input">
                                                <label class="form-check-label" for="productdiscountRadio1">50% Trở lên</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="radio" id="productdiscountRadio2" name="productdiscountRadio" class="form-check-input">
                                                <label class="form-check-label" for="productdiscountRadio2">40% Trở lên</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="radio" id="productdiscountRadio3" name="productdiscountRadio" class="form-check-input">
                                                <label class="form-check-label" for="productdiscountRadio3">30% Trở lên</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="radio" id="productdiscountRadio4" name="productdiscountRadio" class="form-check-input">
                                                <label class="form-check-label" for="productdiscountRadio4">20% Trở lên</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="radio" id="productdiscountRadio5" name="productdiscountRadio" class="form-check-input">
                                                <label class="form-check-label" for="productdiscountRadio5">10% or more</label>
                                            </div>
                                            <div class="form-check mt-2">
                                                <input type="radio" id="productdiscountRadio6" name="productdiscountRadio" class="form-check-input">
                                                <label class="form-check-label" for="productdiscountRadio6">ít hơn 10%</label>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>

                        </div>

                    </div>
                </div>

                <div class="col-xl-9 col-lg-8">
                    <div class="card">
                        <div class="card-body">
                            <ul class="nav nav-tabs nav-tabs-custom mt-3 mb-2 ecommerce-sortby-list">
                                <li class="nav-item">
                                    <a class="nav-link disabled fw-medium" href="#" tabindex="-1">Sản Phẩm:</a>
                                </li>
                                <c:forEach items="${list}" var="c" varStatus="status">
                                    <li class="nav-item">
                                        <a class="nav-link" href="Home?id_cate=${c.id}">${c.name}</a>
                                    </li>
                                </c:forEach>
                            </ul>

                            <div class="row">
                                <%
                                    ArrayList<Product> ds = (ArrayList<Product>) request.getAttribute("listP");
                                    int id_cate = 0;
                                    if (ds != null) {
                                        id_cate = ds.get(0).getId_category();
                                    }

                                    int index = 0;
                                    for (Product product : ds) {
                                        if (index % 3 == 0) {
                                            out.println("<div class='row'>"); // Mở một dòng mới
                                        }
                                %>
                                    <div class="col-xl-4 col-sm-6">
                                        <div class="card dash-product-box shadow-none border text-center">
                                            <div class="card-body">
                                                <div class="dash-product-img text-center">
                                                    <img src="getImage?id=<%= product.getId()%>" class="img-fluid" alt="">
                                                </div>
                                                <h5 class="font-size-17 mt-1">
                                                    <a href="" class="text-dark lh-base"><%=product.getName()%></a>
                                                </h5>
                                                <h5 class="font-size-20 text-primary mt-3 mb-0">
                                                    <del class="font-size-17 text-muted fw-normal me-1"><%= product.getPrice()%></del> <%= product.getPrice()-50%>
                                                </h5>
                                                <div class="font-size-16 mt-2">
                                                    <i class="mdi mdi-star text-warning"></i>
                                                    <i class="mdi mdi-star text-warning"></i>
                                                    <i class="mdi mdi-star text-warning"></i>
                                                    <i class="mdi mdi-star-half-full text-warning"></i>
                                                </div>
                                                <div class="mt-4">
                                                    <a href="
                                                       <c:if test="${u==null}">
                                                       login
                                                        </c:if>
                                                        <c:if test="${u!=null}">
                                                            addtocart?id_product=<%=product.getId()%>&name=<%= product.getName()%>&image=getImage?id=<%= product.getId()%>&price=<%= product.getPrice()%>&quantity=1&status=1&id_category=<%= product.getId_category()%>
                                                        </c:if> " class="btn btn-primary btn-sm w-lg">
                                                        <i class="mdi mdi-cart me-1 align-middle"></i> THÊM VÀO GIỎ HÀNG
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                <%
                                        index++;
                                        if (index % 3 == 0) {
                                            out.println("</div>"); // Đóng dòng hiện tại
                                        }
                                    }
                                    if (index % 3 != 0) {
                                        out.println("</div>"); // Đóng dòng cuối nếu không đầy đủ 3 sản phẩm
                                    }
                                %>
                            </div>

                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="float-sm-end">
                                        <ul class="pagination pagination-rounded mb-sm-0">
                                            <li class="page-item disabled">
                                                <a href="#" class="page-link"><i class="mdi mdi-chevron-left"></i></a>
                                            </li>
                                            <% for (int i = 1; i <= 9; i++) {%>
                                            <li class="page-item ">
                                                <a href="Home?trang=<%=i%>&id_cate=<%=id_cate%>" class="page-link"><%=i%></a>
                                            </li>
                                            <%}%>
                                            <li class="page-item">
                                                <a href="#" class="page-link"><i class="mdi mdi-chevron-right"></i></a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="float-sm-end">
                                        <!-- Thêm nội dung ở đây nếu cần -->
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- container-fluid -->
</div>
<!-- End Page-content -->