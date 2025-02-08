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

@WebServlet("/deleteurlstaff")
public class DeleteStaffDetails extends HttpServlet{
	private static final long serialVersionUID = 1L;	
	
	protected void doGet(HttpServletRequest request , HttpServletResponse res) throws IOException {
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("<link rel='stylesheet' href='css/DeleteStudentDetails.css'></link>");
		String id = request.getParameter("id");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///projectdb","root","Tanmay@256");
				
				PreparedStatement pstmt = con.prepareStatement("delete from staff1 where id=?");
				)
		{
			pstmt.setString(1, id);
			int count = pstmt.executeUpdate();
			pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
			if(count==1) {
				pw.println("<h2 class='bg-danger text-light text-center'>Deleted Successfully</h2>");
			}else {
				pw.println("<h2 class='bg-danger text-light text-center'>Record Not Deleted</h2>");
			}
		} catch (SQLException se) {
			pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		pw.println("<a href='index.jsp'><button class='btn btn-outline-success'>Home</button></a>");
		pw.println("&nbsp; &nbsp;");
		pw.println("<a href='showstaffdata'><button class='btn btn-outline-success'>Show Staff Details</button></a>");
		pw.println("</div>");
		//close the stream
		pw.close();
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
