package com.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//ADMIN
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String username=req.getParameter("username");
		String password=req.getParameter("pass");
		String contact=req.getParameter("contact");
		
		
		
		
		RequestDispatcher dispatcher=null;
		
		Connection con=null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/projectdb?useSSL=false";
			String uname="root";
			String pass="Tanmay@256";
			con=DriverManager.getConnection(url,uname,pass);
			
			String qry="insert into admin(name,email,username,password,contact) values(?,?,?,?,?)";
			
			PreparedStatement pstmt=con.prepareStatement(qry);
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, username);
			pstmt.setString(4, password);
			pstmt.setString(5, contact);
			
			
			int rowCount=pstmt.executeUpdate();
			
			dispatcher=req.getRequestDispatcher("registration.jsp");
			
			if(rowCount>0)
			{
				req.setAttribute("status", "success");
			}
			else
			{
				req.setAttribute("status", "failed");
			}
			dispatcher.forward(req, res);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				con.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
