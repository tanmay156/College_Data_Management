package com.student;

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

@WebServlet("/chandan")
public class RegisterStaffServlet extends HttpServlet {
    private final static String query = "insert into staff1(id,name,department,salary) values(?,?,?,?)";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Get PrintWriter
        PrintWriter pw = res.getWriter();
        // Set content type
        res.setContentType("text/html");
        pw.println("<link rel='stylesheet' type='text/css' href='css/registerstaffservlet.css'>");

        // Get the parameters from the request
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String department = req.getParameter("department");
        String salary = req.getParameter("salary");
        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Generate the connection
        try(Connection con = DriverManager.getConnection("jdbc:mysql:///projectdb","root","Tanmay@256");
             PreparedStatement pstmt = con.prepareStatement(query)) {
             
            // Set the values
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, department);
            pstmt.setString(4, salary);

            // Execute the query
            int count = pstmt.executeUpdate();
            pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
            if (count == 1) {
                pw.println("<h2 class='bg-success text-light text-center'>Record Registered Successfully</h2>");
            } else {
                pw.println("<h2 class='bg-danger text-light text-center'>Record Not Registered</h2>");
            }
        } catch (SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Home button
        pw.println("<a href='index.jsp'><button class='btn btn-outline-success home-button'>Home</button></a>");
        pw.println("</div>");
        // Close the stream
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
