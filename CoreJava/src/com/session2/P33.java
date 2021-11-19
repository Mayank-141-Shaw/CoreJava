package com.session2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login-p33")
public class P33 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static HashMap<String, String> credentials = new HashMap<String, String>();
	final String DB_url = "jdbc:mysql://localhost:3306/mydb";
	final String DB_user = "root";
	final String DB_password = "@Mayank99";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
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
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		String uname = req.getParameter("name");
		System.out.println("Uname : "+uname);
		String pass = req.getParameter("pass");
		System.out.println("Password : "+pass);
		
		// getting data from table usersp33
		String getUserDataQuery = "Select * from mydb.usersp33 where name=?;";
		try {
			ps = con.prepareStatement(getUserDataQuery);
			ps.setString(1, uname.toLowerCase());
			rs = ps.executeQuery();
			if(!rs.isBeforeFirst()) {
				// close all the connections 
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(con!=null)con.close();
				
				// then send the dispatcher
				req.getRequestDispatcher("registerP33.html").forward(req, resp);
			}else {
				// check if the password is correct or not
				getUserDataQuery = "Select * from mydb.usersp33 where name=? and pass=?;";
				ps = con.prepareStatement(getUserDataQuery);
				ps.setString(1, uname.toLowerCase());
				ps.setString(2, pass);
				rs = ps.executeQuery();
				// checking password
				if(!rs.isBeforeFirst()) {
					// password is wrong enter the password again
					
					out.println("Wrong password try again");
					req.getRequestDispatcher("loginP33.html").include(req, resp);

				}else {
					// all is correct
					out.println("Welcome! "+uname+"<br>");
					int hourOfDay = new Calendar.Builder().build().get(Calendar.HOUR_OF_DAY);
					if(hourOfDay > 22 && hourOfDay < 4) out.println("Good Night");
					else if(hourOfDay >= 4  && hourOfDay < 12) out.println("Good Morning");
					else if(hourOfDay >= 12 && hourOfDay < 17) out.println("Good Afternoon");
					else out.println("Good Evening");
						
					out.println();
				}
			}
		} catch (SQLException  e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(con!=null)con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
