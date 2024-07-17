<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
</head>
<body>
	<h2>Sign Up</h2>
	<h2><a href="EmployeeLogin.jsp">Login</a></h2>
	<form action="emp_reg" method="post">
		<label>Name</label>
		<input type="text" name="emp_name"/><br><br>
		
		<label>Phone Number</label>
		<input type="text" name="phone"/><br><br>
		
		<label>Email</label>
		<input type="email" name="email_id"/><br><br>
		
		
		<label>Role</label>
		<input type="text" name="role"><br><br>
		
		<label>Age</label>
		<input type="text" name="age"/><br><br>
		
		
		<label>Password</label>
		<input type="password" name="emp_pass"><br><br>
		
		<input type="submit" value="Register"/>
		
	</form>
</body>
</html>