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

@WebServlet("/editurlmark")
public class EditScreenMarkServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final static String query = "select Physics, Chemistry, Math, Biology from marks where roll_no=?";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        PrintWriter pw = res.getWriter();

        res.setContentType("text/html");

        String rollno = req.getParameter("rollno");

        pw.println("<link rel='stylesheet' href='css/editScreenMark.css'>");
        pw.println("<marquee><h2 class='marquee-header'>Student Data Base Edit</h2></marquee>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection("jdbc:mysql:///projectdb", "root", "Tanmay@256");
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, rollno);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                pw.println("<div class='form-container'>");
                pw.println("<form action='editmark?rollno=" + rollno + "' method='post'>");

                pw.println("<table class='table table-hover table-striped'>");

                pw.println("<tr>");
                pw.println("<td>Physics</td>");
                pw.println("<td><input type='text' name='physics' value='" + rs.getInt("Physics") + "'></td>");
                pw.println("</tr>");

                pw.println("<tr>");
                pw.println("<td>Chemistry</td>");
                pw.println("<td><input type='text' name='chemistry' value='" + rs.getInt("Chemistry") + "'></td>");
                pw.println("</tr>");

                pw.println("<tr>");
                pw.println("<td>Math</td>");
                pw.println("<td><input type='text' name='math' value='" + rs.getInt("Math") + "'></td>");
                pw.println("</tr>");

                pw.println("<tr>");
                pw.println("<td>Biology</td>");
                pw.println("<td><input type='text' name='biology' value='" + rs.getInt("Biology") + "'></td>");
                pw.println("</tr>");

                pw.println("<tr>");
                pw.println("<td><button type='submit' class='btn btn-outline-success'>Save</button></td>");
                pw.println("<td><button type='reset' class='btn btn-outline-danger'>Cancel</button></td>");
                pw.println("</tr>");

                pw.println("</table>");
                pw.println("</form>");
                pw.println("</div>");
            } else {
                pw.println("<h2 class='bg-danger text-light text-center'>No record found for roll number " + rollno + "</h2>");
            }

        } catch (SQLException se) {
            pw.println("<h2 class='bg-danger text-light text-center'>" + se.getMessage() + "</h2>");
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        pw.println("<div style='text-align:center;'><a href='index.jsp' class='home-button'>Home</a></div>");

        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
