package com.session2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register-p33")
public class RegisterP33Servlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	final String DB_url = "jdbc:mysql://localhost:3306/mydb";
	final String DB_user = "root";
	final String DB_password = "@Mayank99";
	
	Connection con = null;
	PreparedStatement ps = null;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  	// driver name for mysql driver
			System.out.println("Driver Loaded");
			
			// creating a connection
			con = DriverManager.getConnection(DB_url, DB_user, DB_password);
			System.out.println("Connection established");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		User newUser = new User(Integer.parseInt(req.getParameter("uid")),
								req.getParameter("email"),
								req.getParameter("mobile"),
								req.getParameter("uname"),
								req.getParameter("pass"));
		
		String query = "Insert into usersp33(name, email, mobile, pass) values(?,?,?,?);";
		try {
			
			ps = con.prepareStatement(query);
			ps.setString(1, newUser.getName());
			ps.setString(2, newUser.getEmail());
			ps.setString(3,  newUser.getMobile());
			ps.setString(4,  newUser.getPass());
			if(ps.executeUpdate()==1) System.out.println("New entry added");
			else System.out.println("User already exists");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		out.println("Registered Successfully !");
		req.getRequestDispatcher("loginP33.html").include(req, resp);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			if(ps!=null)ps.close();
			if(con!=null)con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
