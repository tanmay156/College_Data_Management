package com.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		HttpSession session=req.getSession();
		RequestDispatcher dispatcher=null;
		Connection con=null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb" ,"root", "Tanmay@256"); 
			String qry="select * from admin where username=? and password=?";
			
			
			PreparedStatement pstmt=con.prepareStatement(qry);
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				session.setAttribute("name", rs.getString("username"));
				dispatcher=req.getRequestDispatcher("index.jsp");     //redirecting to home page if existing user
			}
			else 
			{
				req.setAttribute("status", "failed");
				dispatcher=req.getRequestDispatcher("login.jsp");    //if failed then redirecting to log in page
			}
			dispatcher.forward(req, res);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
