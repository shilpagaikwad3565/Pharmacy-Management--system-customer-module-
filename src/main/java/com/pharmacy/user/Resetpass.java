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
@WebServlet("/reset")
public class Resetpass  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String email = req.getParameter("email");
        String newPassword = req.getParameter("newPassword");
		resp.setContentType("text/html");
		
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","root","Shilpa@3565");
			String query = "UPDATE Users SET password=? WHERE email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setString(2, email);
            int i=ps.executeUpdate();
            if (i > 0) {
                // Password successfully updated
              
                PrintWriter out = resp.getWriter();
                pw.println("<h3>Your password has been successfully reset!</h3>");
                pw.println("<a href='Login.jsp'>Go to Login</a>");
            } else {
                
                
                pw.println("<h3>No account found with that email address.</h3>");
                
            }
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			 
		}
	
		
	


}