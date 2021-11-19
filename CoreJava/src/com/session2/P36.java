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
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/login-p36")
public class P36 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		String uname = req.getParameter("name");
		System.out.println("Uname : "+uname);
		String pass = req.getParameter("pass");
		System.out.println("Password : "+pass);
		
		if(!uname.toLowerCase().equals("admin")) {
			// username is wrong try again
			out.print("<span>User id incorrect. Try agai</span>");
			req.getRequestDispatcher("loginP36.html").include(req, resp);
		}else {
			if(!pass.equals("admin123")) {
				// password is wrong try again
				out.print("<span>Password incorrect. Try again</span>");				
				req.getRequestDispatcher("loginP36.html").include(req, resp);
			}else {
				// both are correct, make a new session and send to home page
				HttpSession session = req.getSession();
				session.setAttribute("uid", uname.toLowerCase());
				session.setAttribute("pass", pass);
				req.getRequestDispatcher("homeP36.html").forward(req, resp);
			}
		}
				
	}
	
}
