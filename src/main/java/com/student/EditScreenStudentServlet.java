package com.student;

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

@WebServlet("/editurlstudent")
public class EditScreenStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final static String query = "select reg_no,s_name,email,gender,dob,phone,course from student where roll_no=?";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Get PrintWriter
        PrintWriter pw = res.getWriter();

        // Set content type
        res.setContentType("text/html");

        // Get the roll number
        String rollno = req.getParameter("rollno");

        pw.println("<link rel='stylesheet' href='css\\editscreenstudentservlet.css'>"); // Link to the CSS file
        pw.println("<marquee><h2 class='text-primary'>Student Data Base Edit</h2></marquee>");

        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Generate the connection
        try (Connection con = DriverManager.getConnection("jdbc:mysql:///projectdb", "root", "Tanmay@256");
             PreparedStatement pstmt = con.prepareStatement(query)) {
            // Set value
            pstmt.setString(1, rollno);

            // For select, we need result set
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            pw.println("<div class='form-container'>");

            // Form action for edit
            pw.println("<form action='editstudent?rollno=" + rollno + "' method='post'>");

            pw.println("<table class='table table-hover table-striped'>");

            pw.println("<tr>");
            pw.println("<td>Registration Number</td>");
            pw.println("<td><input type='text' name='regno' value='" + rs.getString(1) + "'></td>");
            pw.println("</tr>");

            pw.println("<tr>");
            pw.println("<td>Name</td>");
            pw.println("<td><input type='text' name='name' value='" + rs.getString(2) + "'></td>");
            pw.println("</tr>");

            pw.println("<tr>");
            pw.println("<td>Email</td>");
            pw.println("<td><input type='email' name='email' value='" + rs.getString(3) + "'></td>");
            pw.println("</tr>");

            pw.println("<tr>");
            pw.println("<td>Gender</td>");
            pw.println("<td><input type='text' name='gender' value='" + rs.getString(4) + "'></td>");
            pw.println("</tr>");

            pw.println("<tr>");
            pw.println("<td>DOB</td>");
            pw.println("<td><input type='date' name='dob' value='" + rs.getString(5) + "'></td>");
            pw.println("</tr>");

            pw.println("<tr>");
            pw.println("<td>Phone</td>");
            pw.println("<td><input type='text' name='contact' value='" + rs.getString(6) + "'></td>");
            pw.println("</tr>");

            pw.println("<tr>");
            pw.println("<td>Course</td>");
            pw.println("<td><input type='text' name='course' value='" + rs.getString(7) + "'></td>");
            pw.println("</tr>");

            pw.println("<tr>");
            pw.println("<td><button type='submit' class='btn btn-outline-success'>Save</button></td>");
            pw.println("<td><button type='reset' class='btn btn-outline-danger'>Cancel</button></td>");
            pw.println("</tr>");

            pw.println("</table>");

            pw.println("</form>");
        } catch (SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //pw.println("<a href='index.jsp'><button class='btn btn-outline-success'>Home</button></a>");
        pw.println("</div>");
        // Close the stream
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
