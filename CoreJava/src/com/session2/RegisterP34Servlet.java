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
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/register-p34")
public class RegisterP34Servlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		User newUser = new User(Integer.parseInt(req.getParameter("uid")),
								req.getParameter("email"),
								req.getParameter("mobile"),
								req.getParameter("uname"),
								req.getParameter("pass"));
		
		// put these values in the sessiom
		HttpSession session = req.getSession();
		session.setAttribute("uid", newUser.getUid());
		session.setAttribute("email", newUser.getEmail());
		session.setAttribute("mobile", newUser.getMobile());
		session.setAttribute("uname", newUser.getName());
		session.setAttribute("pass", newUser.getPass());		
		
		out.println("Registered Successfully !");
		req.getRequestDispatcher("loginP34.html").include(req, resp);
	}
	
}
