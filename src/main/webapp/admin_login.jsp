<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin login</title>
</head>
<body>
<div class="header">
<h2>Admin page</h2>
</div>
<div class="container">
<form action="adminlogin" method="post">
<label>User Name:</label>
<input type="text" name="admin_name" placeholder="enter admin user"/><br><br>
<label>Password:</label>
<input type="password" name="admin_pass" placeholder="enter admin user"/><br><br>
<input type="submit" value="Login"/>
</form>
</div>
  <% if (request.getAttribute("status") != null && request.getAttribute("status").equals("failed")) { %>
        <p class="error-message">Invalid username or password. Please try again.</p>
    <% } %>
</body>
</html>