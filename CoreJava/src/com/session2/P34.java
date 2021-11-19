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

@WebServlet(urlPatterns = "/login-p34")
public class P34 extends HttpServlet {

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
		
		HttpSession session = req.getSession();
		if(session.getAttribute("uname")==null) {
			// user does not exist yet
			// register a new user
			req.getRequestDispatcher("registerP34.html").forward(req, resp);
		}else {
			if(!session.getAttribute("uname").equals(uname.toLowerCase())) {
				// then send the dispatcher
				req.getRequestDispatcher("registerP34.html").forward(req, resp);
			}else {
				// check if the password is correct or not
				if(!session.getAttribute("pass").equals(pass)) {
					out.println("Wrong password try again");
					req.getRequestDispatcher("loginP34.html").include(req, resp);

				}else {
					// all is correct
					out.println("Welcome! "+session.getAttribute("uname")+"<br>");
					int hourOfDay = new Calendar.Builder().build().get(Calendar.HOUR_OF_DAY);
					if(hourOfDay > 22 && hourOfDay < 4) out.println("Good Night");
					else if(hourOfDay >= 4  && hourOfDay < 12) out.println("Good Morning");
					else if(hourOfDay >= 12 && hourOfDay < 17) out.println("Good Afternoon");
					else out.println("Good Evening");
						
					out.println();
				}
			}

		}
		
	}
	
}
