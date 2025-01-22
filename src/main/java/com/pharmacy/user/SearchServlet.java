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

@WebServlet("/searchbar")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        
        resp.setContentType("text/html");

        String searchQuery = req.getParameter("searchQuery");

        

        try {
           
            Class.forName("com.mysql.jdbc.Driver");

           
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Shilpa@3565");

            
            String query = "SELECT product_name, product_price, product_image FROM products WHERE product_name LIKE ?";
            PreparedStatement ps = con.prepareStatement(query);

            
            ps.setString(1, "%" + searchQuery + "%");

                       ResultSet rs = ps.executeQuery();

            
            if (!rs.next()) {
                pw.println("<h3> products not found..</h3>");
            } else {
               
                pw.println("<h2>product found</h2>");
                pw.println("<ul>");
                do {
                    String productName = rs.getString("product_name");
                    double productPrice = rs.getDouble("product_price");
                    String productImage = rs.getString("product_image");

                  
                    pw.println("<li>");
                    pw.println("<strong>Product Name:</strong> " + productName + "<br>");
                    pw.println("<strong>Price:" + productPrice + "<br>");
                   
                        pw.println("<img src='" + productImage + "' alt='" + productName + "' style='width: 100px; height: 100px;'><br>");
                    
                    pw.println("</li>");
                } while (rs.next());
                pw.println("</ul>");
            }

           
            rs.close();
            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
        }
    }
}
