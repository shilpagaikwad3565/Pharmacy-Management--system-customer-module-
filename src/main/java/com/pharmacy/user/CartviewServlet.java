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

@WebServlet("/mycart")
public class CartviewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        // Set content type
        resp.setContentType("text/html");
        pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Shilpa@3565");

            // Query to get cart items
            String query = "SELECT product_id, quantity, product_name, product_price FROM cart";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            double totalPrice = 0; // Initialize total price

            pw.println("<div style='margin:auto;width:900px;margin-top:100px;'>");
            pw.println("<h2>Your Cart</h2>");
            pw.println("<table class='table table-hover table-striped bg-light'>");
            pw.println("<tr>");
            pw.println("<th>Product Id</th>");
            pw.println("<th>Quantity</th>");
            pw.println("<th>Product Name</th>");
            pw.println("<th>Product Price</th>");
            pw.println("<th>Action</th>");
            pw.println("</tr>");

            while (rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                String productName = rs.getString("product_name");
                double productPrice = rs.getDouble("product_price");

                // Calculate the total price
                totalPrice += productPrice * quantity;

                // Display each product
                pw.println("<tr>");
                pw.println("<td>" + productId + "</td>");
                pw.println("<td>" + quantity + "</td>");
                pw.println("<td>" + productName + "</td>");
                pw.println("<td>" + productPrice + "</td>");
                
                pw.println("<td><form action='mycart' method='POST'>"
                		+ "<button class='btn btn-danger' name='delete' value='" + productId + "'>Delete</button></form></td>");
                pw.println("</tr>");
            }

            // Show the total price
            pw.println("<tr><td colspan='4'><strong>Total Price: </strong></td><td><strong>" + totalPrice + "</strong></td></tr>");

            // Button for Buy Now
            pw.println("<tr><td colspan='5'><a href='#' class='btn btn-success btn-lg'>Buy Now</a></td></tr>");

            pw.println("</table>");
            pw.println("</div>");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            pw.println("<h3>Database error occurred. Please try again later.</h3>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();

        
        String productId = req.getParameter("delete");

        if (productId != null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "Shilpa@3565");

               
                String deleteQuery = "DELETE FROM cart WHERE product_id = ?";
                PreparedStatement ps = con.prepareStatement(deleteQuery);
                ps.setInt(1, Integer.parseInt(productId));
                int count = ps.executeUpdate();

                if (count > 0) {
                    pw.println("<h3>Product deleted successfully!</h3>");
                } else {
                    pw.println("<h3>Failed to delete the product!</h3>");
                }

                
                resp.sendRedirect("mycart");

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                pw.println("<h3>Database error occurred. Please try again later.</h3>");
            }
        }
    }
}
