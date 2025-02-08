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


@WebServlet("/editmark")
public class EditMarkDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final static String query = "update marks set Physics=?,Chemistry=?,Math=?,Biology=? where roll_no=?";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//set content type
		res.setContentType("text/html");
		
		//link the bootstrap
		pw.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
		
		//get the values
		String rollno=req.getParameter("rollno");
		int physics=Integer.parseInt(req.getParameter("physics"));
		int chemistry=Integer.parseInt(req.getParameter("chemistry"));
		int math=Integer.parseInt(req.getParameter("math"));
		int biology=Integer.parseInt(req.getParameter("biology"));
		
		
		
		
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
			pstmt.setInt(1, physics);
			pstmt.setInt(2, chemistry);
			pstmt.setInt(3, math);
			pstmt.setInt(4, biology);
			pstmt.setString(5,rollno);
			
			

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
		pw.println("<a href='showmarkdata'><button class='btn btn-outline-success'>Show Students</button></a>");
		pw.println("</div>");
		//close the stream
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
