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

@WebServlet("/registerstudent")
public class RegisterstudentServlet extends HttpServlet {
    private final static String query = "insert into student(reg_no,roll_no,s_name,email,gender,dob,phone,course) values(?,?,?,?,?,?,?,?)";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Get PrintWriter
        PrintWriter pw = res.getWriter();
        // Set content type
        res.setContentType("text/html");
        pw.println("<link rel='stylesheet' type='text/css' href='css/registerstudentservlet.css'>");

        // Get the parameters from the request
        String regno = req.getParameter("registrationNumber");
        String rollno = req.getParameter("rollNumber");
        String name = req.getParameter("studentName");
        String email = req.getParameter("studentEmail");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");
        String phone = req.getParameter("studentPhone");
        String course = req.getParameter("studentCourse");

        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Generate the connection
        try (Connection con = DriverManager.getConnection("jdbc:mysql:///projectdb", "root", "Tanmay@256");
             PreparedStatement pstmt = con.prepareStatement(query)) {
             
            // Set the values
            pstmt.setString(1, regno);
            pstmt.setString(2, rollno);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.setString(5, gender);
            pstmt.setString(6, dob);
            pstmt.setString(7, phone);
            pstmt.setString(8, course);

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
