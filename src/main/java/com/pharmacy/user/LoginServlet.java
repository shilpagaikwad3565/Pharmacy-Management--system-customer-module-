package com.pharmacy.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet<user>  extends HttpServlet{
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","root","Shilpa@3565");
			String query = "select username ,password from Users where username=?";
			PreparedStatement ps = con.prepareStatement(query);{
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();
			
			
			 if (rs.next()) {
	                String storedPassword = rs.getString("password");
	                
	                // Compare entered password with stored password
	                if (storedPassword.equals(password)) {
	                    pw.println("Login successful...");
	                } else {
	                    pw.println("Invalid password.");
	                }
	            } else {
	            	
	                pw.println("Invalid username.");
	            }
			
		
			
		
			
			
		}}
		
		
		
		
			catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		pw.println("<a href='Profile.html'><button class='btn btn-outline-danger 'style='margin-left:50px;margin-top:10px;'>Account</button></a>");
		

		
	

}

	
}