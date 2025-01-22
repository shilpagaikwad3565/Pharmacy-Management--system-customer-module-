<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>


body {
    background-color: #f8f9fa; 
    font-family: Arial, sans-serif; 
    margin: 0;
    padding: 0;
}


.form {
    background-color: pink; 
    padding: 30px;
    border-radius: 10px; 
    box-shadow: 0 4px 8px black(0, 0, 0, 0.6);
    max-width: 500px;
    margin-top: 100px;
    margin-left:400px;
}

h2 {
    color: #28a745; 
    text-align: center;
    font-size: 28px;
    text-decoration: underline;
}


table {
    width: 100%;
    margin-top: 30px;
}


input[type="text"],
input[type="password"] {
    width: 100%; 
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    margin-bottom: 15px; 
    font-size: 16px;
}
input[type="text"]:focus,
input[type="password"]:focus {
    border-color: #28a745; 
    outline: none; 
}

button {
    width:450px; 
    padding: 10px;
    font-size: 16px;
    border-radius: 10px;
    background-color:green;
    color:white;
}

 {
    background-color: #28a745;
    color: white;
}



button.btn-outline-danger:hover {
    background-color: #c82333;
    color: white;
}

</style>
<meta charset="UTF-8">
<title>Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body class="container-fluid ">


<form action="login"  method="get"  class="form" id="form">
<h2 class=" text-Success " > Login  Here</h2>
<table class="table table-hover" >
       <tr>
        <td>UserName</td>
        <td><input type="text" name="username" required></td>
        </tr>
        <tr>
        <td>Password</td>
        <td><input type="password" name="password" required></td>
        </tr>
        
        </table>
       <button type="submit">login</button>
      
       
        </form>
         <a href='Registration.jsp'style="margin-left:500px;color:red"> new user please Register here....</a>


</body>
</html>