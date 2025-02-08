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


@WebServlet("/registermark")
public class RegistermarkServlet extends HttpServlet {
	private final static String query = "insert into marks(roll_no,Physics,Chemistry,Math,Biology) values(?,?,?,?,?)";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		
		//get the values
		
		String rollno=req.getParameter("rollNumber");
		int physics=Integer.parseInt(req.getParameter("physicsMark"));
		int chemistry=Integer.parseInt(req.getParameter("chemistryMark"));
		int math=Integer.parseInt(req.getParameter("mathMark"));
		int biology=Integer.parseInt(req.getParameter("biologyMark"));		

		//load the JDBC driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			e.printStackTrace();
		}
		//generate the connection
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///projectdb","root","Tanmay@256");
				PreparedStatement pstmt = con.prepareStatement(query);)
		{
			//set the values
			pstmt.setString(1, rollno);
			pstmt.setInt(2, physics);
			pstmt.setInt(3, chemistry);
			pstmt.setInt(4, math);
			pstmt.setInt(5, biology);

			
			
			//execute the query
			int count = pstmt.executeUpdate();
			pw.println("<div class='card' style='margin:auto;width:300px;margin-top:100px'>");
			if(count==1) {
				pw.println("<h2 class='bg-danger text-light text-center'>Record Registered Successfully</h2>");
			}else {
				pw.println("<h2 class='bg-danger text-light text-center'>Record Not Registered</h2>");
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
		pw.println("</div>");
		//close the stream
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
