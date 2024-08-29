<%-- 
    Document   : adminOrders
    Created on : Aug 16, 2024, 10:30:00 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>User ID</th>
                    <th>Total</th>
                    <th>Order Date</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.user_id}</td>
                    <td>${order.total}</td>
                    <td>${order.order_date}</td>
                    <td>${order.status}</td>
                    <td>
                        <form action="confirmOrder" method="post">
                            <input type="hidden" name="order_id" value="${order.id}">
                            <button type="submit" class="btn btn-success">Confirm</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
