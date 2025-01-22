package com.pharmacy.user;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/AddToCartServlet")
public class AddtocartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        
        int productId = Integer.parseInt(req.getParameter("product_id"));
        String productName = req.getParameter("product_name");
        double productPrice = Double.parseDouble(req.getParameter("product_price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

      try 
            {
            	Class.forName("com.mysql.jdbc.Driver");
            	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Shilpa@3565");
            String query = "INSERT INTO cart (product_id, product_name, product_price, quantity) VALUES (?, ?, ?, ?)";

                 PreparedStatement stmt = con.prepareStatement(query);
                    
                stmt.setInt(1, productId);
                stmt.setString(2, productName);
                stmt.setDouble(3, productPrice);
                stmt.setInt(4, quantity);

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    pw.println("<h3>Product added successfully.</h3>");
                   
                } else {
                    System.out.println("Error: Product not added.");
                    pw.println("<h3>Error adding product to cart.</h3>");
                }
            }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            pw.println("<a href='mycart'><button class='btn btn-primary'>show cart</button></a>");
        } 
    }
        
    }

