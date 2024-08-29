

<%@page import="demo.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shopping Cart</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Your Shopping Cart</h2>

            <table class="table table-bordered mt-3">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Tên sản phẩm</th>
                        <th scope="col">Giá</th>
                        <th scope="col">Số lượng</th>
                        <th scope="col">Tổng tiền</th>
                        <th scope="col">Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Product> ds = (ArrayList<Product>) request.getAttribute("ds");
                        double a = 0;
                        if (ds != null && !ds.isEmpty()) {
                            for (Product product : ds) {
                    %>
                    <tr>
                        <td><%= product.getName()%></td>
                        <td><%= String.format("%.2f", product.getPrice())%><sup>đ</sup></td>
                        <td><%= product.getQuantity()%></td>
                        <td><%= String.format("%.2f", product.getPrice())%><sup>đ</sup></td>
                        <%a = a + product.getPrice();%>
                        <td>
                            <form action="removeProduct" method="post">
                                <input type="hidden" name="productName" value="<%= product.getName()%>">
                                <button type="submit" class="btn btn-danger btn-sm">Remove</button>
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="5" class="text-center">Giỏ hàng rỗng</td>
                    </tr
                    <% }%>
                    ><tr>
                        <td colspan="5" class="text-center">Thành tiền: <%=a%> <sup>đ</sup></td>
                    </tr>
                </tbody>
            </table>

            <div class="text-right">
                <a href="Home" class="btn btn-primary">Continue Shopping</a>
                <a href="checkout" class="btn btn-success">Checkout</a>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
