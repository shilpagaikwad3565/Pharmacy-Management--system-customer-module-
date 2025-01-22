package com.pharmacy.user;

import java.io.IOException;
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
@WebServlet("/manageaccount")
public class UserProfileServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		    
		        String username = req.getParameter("username");
		        String password = req.getParameter("password");  

		        try {
		        	  Class.forName("com.mysql.jdbc.Driver");
		              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Shilpa@3565");
		           
		            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
		            PreparedStatement ps = con.prepareStatement(query);
		            ps.setString(1, username);
		            ps.setString(2, password); 
		            
		            
		            
		            ResultSet rs = ps.executeQuery();

		            if (rs.next()) {
		                
		                String email = rs.getString("email");
		                String city = rs.getString("city");
		                String mobile = rs.getString("mobile");

		            } } 
		            catch (ClassNotFoundException | SQLException e) {
						
						e.printStackTrace();
					}
		               

		               


	}

}
