package com.servletcarapp.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servletcarapp.controller.AccountController;
import com.servletcarapp.controller.AdminController;
import com.servletcarapp.model.Account;
import com.servletcarapp.model.Admin;

@WebServlet(urlPatterns = "/carapp/adminLogin")
public class AdminLoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		// get username and password
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		int status;
		try {
			Admin acc;
			acc = AdminController.getAdmin(uname, pass);
			if(acc != null) {
				// success , track in session and forward to usermenu.html
				HttpSession session = req.getSession();
				session.setAttribute("currentAdmin", acc);
				req.getRequestDispatcher("adminmenu.html").forward(req, resp);
			}else {
				req.getRequestDispatcher("adminlogin.html").include(req, resp);
				out.println("<div class='container'><h1>Username or password was incorrect</h1></div>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
