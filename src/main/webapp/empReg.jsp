<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<style>
    body {
        background-image: url('img/emp11.jpg');
        background-size: cover;
        background-repeat: no-repeat;
        background-attachment: fixed;
        font-family: Arial, sans-serif;
        color: #333;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    form {
        background-color: rgba(255, 255, 255, 0.8);
        padding: 60px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 300px;
        text-align: center;
    }
    h2 {
        margin: 0 0 20px;
    }
    label {
        display: block;
        margin: 10px 0 5px;
        text-align: left;
    }
    input[type="text"],
    input[type="email"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0 20px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #00BFFF;
        border: none;
        border-radius: 5px;
        color: white;
        font-size: 16px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #00008B;
    }
    a {
        color: #00BFFF;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <form action="emp_reg" method="post">
        <h2>Sign Up</h2>
        <h2><a href="EmployeeLogin.jsp">Login</a></h2>
        <label>Name</label>
        <input type="text" name="emp_name"/><br>
        
        <label>Phone Number</label>
        <input type="text" name="phone"/><br>
        
        <label>Email</label>
        <input type="email" name="email_id"/><br>
        
        <label>Role</label>
        <input type="text" name="role"><br>
        
        <label>Age</label>
        <input type="text" name="age"/><br>
        
        <label>Password</label>
        <input type="password" name="emp_pass"><br>
        
        <input type="submit" value="Register"/>
    </form>
</body>
</html>
