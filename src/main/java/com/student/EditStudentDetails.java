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


@WebServlet("/editstudent")
public class EditStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final static String query = "update student set reg_no=?,s_name=?,email=?,gender=?,dob=?,phone=?,course=? where roll_no=?";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//set content type
		res.setContentType("text/html");
		
		//link the bootstrap
		pw.println("<link rel='stylesheet' href='css/EditStudentDetails.css'></link>");
		
		//get the values
		String regno=req.getParameter("regno");
		String rollno=req.getParameter("rollno");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String dob=req.getParameter("dob");
		String contact=req.getParameter("contact");
		String course=req.getParameter("course");
		
		
		
		
		//load the JDBC driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		//generate the connection
		try (Connection con = DriverManager.getConnection("jdbc:mysql:///projectdb", "root", "Tanmay@256");
				PreparedStatement pstmt = con.prepareStatement(query);)
		{
			//set the values
			pstmt.setString(1,regno);
			pstmt.setString(2,name);
			pstmt.setString(3,email);
			pstmt.setString(4,gender);
			pstmt.setString(5,dob);
			pstmt.setString(6,contact);
			pstmt.setString(7,course);
			pstmt.setString(8,rollno);
			

			//execute the query
			int count = pstmt.executeUpdate();
			pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
			if(count==1) {
				pw.println("<h2 class='bg-danger text-light text-center'>Record Edited Successfully</h2>");
			}else {
				pw.println("<h2 class='bg-danger text-light text-center'>Record Not Edited</h2>");
			}
		}
		catch(SQLException se)
		{
			pw.println("<h2 class='bg-danger text-light text-center'>"+se.getMessage()+"</h2>");
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		pw.println("<a href='index.jsp'><button class='btn btn-outline-success'>Home</button></a>");
		pw.println("&nbsp; &nbsp;");
		pw.println("<a href='showstudentdata'><button class='btn btn-outline-success'>Show Students</button></a>");
		pw.println("</div>");
		//close the stream
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
