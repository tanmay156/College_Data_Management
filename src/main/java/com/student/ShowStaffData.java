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

@WebServlet("/showstaffdata")
public class ShowStaffData extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private final static String query = "select * from staff1";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Get PrintWriter
		PrintWriter pw = res.getWriter();
		
		// Set content type
		res.setContentType("text/html");
		
		// Link to external CSS file
		pw.println("<link rel='stylesheet' href='css/showstudentdetails.css'>");
		pw.println("<marquee><h2 class='marquee-header'style=\"color:blue;\" >Staff Details</h2></marquee>");
		
		// Load and register the JDBC Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Establishing a connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///projectdb","root","Tanmay@256");
			 PreparedStatement pstmt = con.prepareStatement(query)) {
			
			// For select statement we have to use ResultSet
			ResultSet rs = pstmt.executeQuery();
			
			pw.println("<div class='table-container'>");
			pw.println("<table>");
			pw.println("<thead>");
			pw.println("<tr>");
			
			// Column headers
			pw.println("<th>id</th>");
			pw.println("<th>name</th>");
			pw.println("<th>department</th>");
			pw.println("<th>salary</th>");
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
				pw.println("<td><a href='editurlstaff?id=" + rs.getInt(1) + "' class='edit-link'>Edit</a></td>");
				pw.println("<td><a href='deleteurlstaff?id=" + rs.getInt(1) + "' class='delete-link'>Delete</a></td>");
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
