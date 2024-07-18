<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style>
    body {
        background-image: url('img/emp9.jpg');
        background-size: cover;
        background-position: center;
        font-family: Arial, sans-serif;
        color: #fff;
    }
    h2 {
        text-align: center;
        color: black;
    }
    .container {
        display: flex;
        justify-content: space-around;
        padding: 50px;
    }
    .get_emp_id, .account-login {
        background: rgba(0, 0, 0, 0.6);
        padding: 20px;
        border-radius: 10px;
        width: 300px;
    }
    label {
        display: block;
        margin-bottom: 8px;
    }
    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border: none;
        border-radius: 5px;
    }
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background: #00BFFF;
        border: none;
        border-radius: 5px;
        color: #fff;
        font-size: 16px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background:#00008B ;
    }
    p {
        color: #fff;
        text-align: center;
    }
</style>
</head>
<body>
    <h2>Login</h2>
    <div class="container">
        <div class="get_emp_id">
            <h2>Get Employee ID</h2>
            <form action="get1" method="post">
                <label for="phone_number">Phone Number</label>
                <input type="text" id="phone_number" name="phone_number" required/><br><br>
                
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required/><br><br>
                
                <input type="submit" value="Get"/>
            </form>
            <%
                String emp_id = (String) request.getAttribute("emp_id");
                String emp_password = (String) request.getAttribute("emp_password");
                if (emp_id != null && emp_password != null) {
                    out.println("<p>Your Employee ID: " + emp_id + "</p>");
                    out.println("<p>Your Employee Password: " + emp_password + "</p>");
                }
            %>
        </div>
        <div class="account-login">
            <h2>Account Login</h2>
            <form action="login1" method="post">
                <label for="employee-id">Enter your Employee ID</label>
                <input type="text" name="emp_id" required/><br><br>       
                
                <label for="employee-password">Enter your Account Password</label>
                <input type="password" name="emp_password" required/><br><br>
                
                <input type="submit" value="Login" name="signin"/>
            </form>
        </div>
    </div>
</body>
</html>
