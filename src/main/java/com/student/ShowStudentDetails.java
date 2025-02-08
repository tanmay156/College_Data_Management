package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showstudentdata")
public class ShowStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private final static String query = "select * from student";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Get PrintWriter
		PrintWriter pw = res.getWriter();
		
		// Set content type
		res.setContentType("text/html");
		
		// Link to external CSS file
		pw.println("<link rel='stylesheet' href='css/showstudentdetails.css'>");
		pw.println("<marquee><h2 class='marquee-header'style=\"color:blue;\" >Student Details</h2></marquee>");
		
		// Load and register the JDBC Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Establishing a connection
		try (Connection con = DriverManager.getConnection("jdbc:mysql:///projectdb", "root", "Tanmay@256");
			 PreparedStatement pstmt = con.prepareStatement(query)) {
			
			// For select statement we have to use ResultSet
			ResultSet rs = pstmt.executeQuery();
			
			pw.println("<div class='table-container'>");
			pw.println("<table>");
			pw.println("<thead>");
			pw.println("<tr>");
			
			// Column headers
			pw.println("<th>Registration Number</th>");
			pw.println("<th>Roll Number</th>");
			pw.println("<th>Name</th>");
			pw.println("<th>Email</th>");
			pw.println("<th>Gender</th>");
			pw.println("<th>DOB</th>");
			pw.println("<th>Phone</th>");
			pw.println("<th>Course</th>");
			pw.println("<th>Edit</th>");
			pw.println("<th>Delete</th>");
			pw.println("</tr>");
			pw.println("</thead><tbody>");
			
			// Table rows
			while (rs.next()) {
				pw.println("<tr>");
				pw.println("<td>" + rs.getString(1) + "</td>");
				pw.println("<td>" + rs.getString(2) + "</td>");
				pw.println("<td>" + rs.getString(3) + "</td>");
				pw.println("<td>" + rs.getString(4) + "</td>");
				pw.println("<td>" + rs.getString(5) + "</td>");
				pw.println("<td>" + rs.getString(6) + "</td>");
				pw.println("<td>" + rs.getString(7) + "</td>");
				pw.println("<td>" + rs.getString(8) + "</td>");
				pw.println("<td><a href='editurlstudent?rollno=" + rs.getInt(2) + "' class='edit-link'>Edit</a></td>");
				pw.println("<td><a href='deleteurlstudent?rollno=" + rs.getInt(2) + "' class='delete-link'>Delete</a></td>");
				pw.println("</tr>");
			}
			pw.println("</tbody></table>");
			pw.println("<div style='text-align:center;'><a href='index.jsp' class='home-button'>Home</a></div>");
			pw.println("</div>");
			
			// Closing the stream
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
