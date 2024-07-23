<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Time Tracker</title>
<style>
    @import url('https://fonts.googleapis.com/css2?family=DM+Sans:ital,opsz,wght@0,9..40,100..1000;1,9..40,100..1000&display=swap');

body{
    height: 90vh;
}
.container{
    display: flex;
    justify-content: space-around;
    align-items: center;
    height: 90vh;
}
.home{
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    height: 60vh;
    flex-direction: column;
}
.buttons{
    display:flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}
img{
    border-radius: 20px;
}
h1{
    font-family: "DM Sans", sans-serif;
    font-optical-sizing: auto;
    font-weight: 800;
    font-style: normal;
    font-size: 50px;
    margin-bottom: 5px;
}
h4{
    margin-top: 5px;
    font-family: "DM Sans", sans-serif;
    font-optical-sizing: auto;
    font-weight: 800;
    font-style: normal;
    font-size: 20px;
    text-align: center;
}
.header{
    display: flex;
    align-items: center;
    flex-direction: column;

}
button{
    background-color: #0080ff;
    border: 0 solid transparent;
    width: 190px;
    height: 60px;
    border-radius: 10px;
    margin: 20px;
    transition: 0.2s ease-out;
}
a{
    text-decoration: none;
    color: aliceblue;
    font-size: 20px;
    font-weight: 600;
}
button:hover{
    text-align: center;
    background-color: #0040ff;
}
</style>
</head>
<body>
<div class="container">
  <div class="image">
<img src="img/emp4.jpg" alt="logo" height="500">
  </div>
    <div class="home">
       <div class="header">
           <h1>Employee time tracker</h1>
           <h4>This Time Tracking software that lets your employees track time <br/>they spend working on projects and tasks.</h4>
       </div>
            <div class="buttons">
                   <button><a href="admin_login.jsp">Admin</a></button>
                   <button><a href="empReg.jsp">Employee</a></button>	
             </div>
     </div>
</div>
	
</body>
</html>