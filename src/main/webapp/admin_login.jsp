<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin login</title>
<style>
    body {
        background-image: url('img/emp5.jpg'); /* Replace with your image URL */
        background-size: cover;
        font-family: Arial, sans-serif;
    }
    .header {
        text-align: center;
        margin-top: 50px;
        color: white;
        text-shadow: 2px 2px 4px #000000;
    }
    .container {
        background-color: rgba(255, 255, 255, 0.8);
        padding: 30px;
        border-radius: 10px;
        max-width: 400px;
        margin: auto;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    }
    label {
        display: block;
        margin-bottom: 20px;
        color:#000000 ;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 7px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="submit"] {
        background-color: #00BFFF;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #87CEFA;
    }
    .error-message {
        color: red;
        text-align: center;
        margin-top: 20px;
    }
</style>
</head>
<body>
<div class="header">
<h2>Admin Login</h2>
</div>
<div class="container">
<form action="adminlogin" method="post">
<label>User Name:</label>
<input type="text" name="admin_name" placeholder="Enter admin username"/><br><br>
<label>Password:</label>
<input type="password" name="admin_pass" placeholder="Enter admin password"/><br><br>
<input type="submit" value="Login"/>
</form>
</div>
<% if (request.getAttribute("status") != null && request.getAttribute("status").equals("failed")) { %>
    <p class="error-message">Invalid username or password. Please try again.</p>
<% } %>
</body>
</html>
