
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
        }
        .form-container h1 {
            margin-top: 0;
            color: #333;
            text-align: center;
        }
        .form-container label {
            display: block;
            margin: 10px 0 5px;
            color: #666;
        }
        .form-container input[type="text"], 
        .form-container input[type="file"], 
        .form-container input[type="submit"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .form-container input[type="submit"] {
            background-color: #28a745;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #218838;
        }
        .form-container input[type="file"] {
            padding: 0;
            border: 1px solid #ddd;
        }
        .form-container .form-group {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Product Form</h1>
        <form action="add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="idC">ID Category</label>
                <input type="text" id="idC" name="idC" />
            </div>
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" id="name" name="name" />
            </div>
            <div class="form-group">
                <label for="image">Image</label>
                <input type="file" id="image" name="image" required="required" />
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input type="text" id="price" name="price" />
            </div>
            <div class="form-group">
                <label for="quantity">Quantity</label>
                <input type="text" id="quantity" name="quantity" />
            </div>
            <input type="submit" value="Save" />
        </form>
    </div>
</body>
</html>
