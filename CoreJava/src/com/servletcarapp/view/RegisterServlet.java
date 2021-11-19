package com.servletcarapp.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servletcarapp.controller.AccountController;
import com.servletcarapp.model.Account;

@WebServlet(urlPatterns = "/carapp/register")
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Account account = new Account(-1, req.getParameter("name"), 
				req.getParameter("address"), 
				req.getParameter("phone"),
				req.getParameter("uname"),
				req.getParameter("pass"),
				0);
		
		int status;
		try {
			status = AccountController.addNewAccount(account);
			if(status == 1) {
				// success 
				req.getRequestDispatcher("homepage.html").include(req, resp);
				out.println("<h1>Account registered successfully</h1>");
			}else {
				req.getRequestDispatcher("homepage.html").include(req, resp);
				out.println("<h1>Account may already exist</h1>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
