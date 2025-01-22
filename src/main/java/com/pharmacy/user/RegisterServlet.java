package com.pharmacy.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter pw = resp.getWriter();
	
		resp.setContentType("text/html");
		
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
	
		String username = req.getParameter("userName");
		String email = req.getParameter("Email");
		String mobile = req.getParameter("mobile");
		String password = req.getParameter("password");
		String city = req.getParameter("city");
		String gender = req.getParameter("gender");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","root","Shilpa@3565");  //for creating connection path
			String query="insert into Users(username,email,mobile,password,city,gender)values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);{
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, mobile);
			ps.setString(4, password);
			ps.setString(5, city);
			ps.setString(6, gender);
			int count = ps.executeUpdate();
			if(count>0)
			{
				pw.println("<h2 class='text-success text-center' style='margin-top:200px;'>Record Registerd Succesfully..........</h2>");
			}
			else
			{
				pw.println("<h2> Record not Registerd</h2>");
			}
	
			}}
			catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		
		    
		      pw.println("<a href='Login.jsp'><button class='btn btn-outline-danger 'style='margin-left:500px;margin-top:40px;'>Login here</button></a>");
		      pw.println("<a href='Registration.jsp'><button class='btn btn-outline-success 'style='margin-left:30px;margin-top:40px;'>back to home</button></a>");
		      pw.println("<a href='showuser'><button class='btn btn-outline-danger 'style='margin-left:30px;margin-top:40px;'>show users</button></a>");
				
		}


}
