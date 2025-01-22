<link rel="stylesheet" href="css/bootstrap.css">
<style>
/
body {
    background-color: #f4f4f9; 
    font-family: Arial, sans-serif; 
}


#form {
    width: 500px;
    margin: auto;
    margin-top: 10px;
    background-color: #fff; 
    padding: 30px;
    border-radius: 10px; 
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1); 
}


h2 {
    color: #d9534f; 
    text-align: center;
    font-size: 28px;
    margin-bottom: 30px;
}


table {
    width: 100%; 
    margin-bottom: 20px;
}


td {
    padding: 10px;
}


input[type="text"], input[type="email"], input[type="password"], select {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
    margin-bottom: 15px;
}


input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus, select:focus {
    border-color: #28a745; 
    outline: none;
}
input[type="radio"] {
    margin-right: 10px;
}
button {
    padding: 10px 20px;
    border-radius: 5px;
    font-size: 16px;
    width: 100%; 
}


button.btn-outline-success {
    background-color: #28a745;
    color: white;
    border: none;
}

button.btn-outline-success:hover {
    background-color: #218838;
}


button.btn-outline-danger {
    background-color: #dc3545;
    color: white;
    border: none;
    margin-top: 10px;
}

button.btn-outline-danger:hover {
    background-color: #c82333;
}

a {
    color: #007bff;
    font-size: 14px;
    text-decoration: none;
    display: block;
    text-align: center;
    margin-top: 20px;
}

a:hover {
    text-decoration: underline;
}


</style>
</head>
<body class="container-fluid">

  <form action="register" method="get" class="form" id="form">
    <h2 class="text-red">Registration Form</h2>
       <table class="table table-hover">
        <tr>
        <td>Name</td>
        <td><input type="text" name="userName" required></td>
        </tr>
        <tr>
        <td>Email</td>
        <td><input type="email" name="Email" required></td>
        </tr>
         <tr>
         <td>Mobile</td>
        <td><input type="text" name="mobile" required ></td>
        </tr>
        <tr>
         <td>password</td>
        <td><input type="password" name="password" required ></td>
        </tr>
        <tr>
         <td>City</td>
        <td><select name="city">
        <option value="pune">Pune</option>
         <option value="Thane">Thane</option>
          <option value="nanded">Nanded</option>
           <option value="latur">Latur</option>
            <option value="mumbai">Mumbai</option>
        </select>
        </td>
        </tr>
        <tr>
        <td>Gender</td>
        <td><input type="radio" name ="gender" value="male">Male &nbsp;
        <input type="radio" name ="gender" value="female">Female
        </td>
        </tr>
        <tr>
        <tr class="card-footer">
        <td><button type="submit" class="btn btn-outline-success">Register</button></td>
        <td><button type="Reset" class="btn btn-outline-danger">Reset</button></td>
         
        </tr>
        </table>
         
        
          
        </form>
         <a href='Login.jsp' style='margin-left:400px;'>already registered Login here</a>
       
       
        </body>
       