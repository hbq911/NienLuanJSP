<%-- 
    Document   : update
    Created on : Aug 15, 2024, 1:27:25 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>update</h1>
        <form action="admin?action=update" method="post" enctype="multipart/form-data">
            <input type="text" name="id" value="${product.id}" />
            
            <div>
                <label for="name">Product Name:</label>
                <input type="text" id="name" name="name" value="${product.name}" required />
            </div>
            <div>
                <label for="image">Image:</label>
                <input type="file" id="image" name="image" />
            </div>
            <div>
                <label for="price">Price:</label>
                <input type="number" id="price" name="price" value="${product.price}" required />
            </div>
            <div>
                <label for="quantity">Quantity:</label>
                <input type="number" id="quantity" name="quantity" value="${product.quantity}" required />
            </div>
            <div>
                <label for="id_category">Category ID:</label>
                <input type="number" id="id_category" name="id_category" value="${product.id_category}" required />
            </div>
            <button type="submit">Update Product</button>
        </form>


    </body>
</html>
