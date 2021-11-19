package com.session2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register-p32")
public class RegisterP32Servlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, String> credentials = new HashMap<String, String>();
		if(getServletContext().getAttribute("credentialMap") != null)
			credentials.putAll( (Map<String,String>) getServletContext().getAttribute("credentialMap"));
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		System.out.println(credentials.keySet().toString());
		User newUser = new User(Integer.parseInt(req.getParameter("uid")),
								req.getParameter("email"),
								req.getParameter("mobile"),
								req.getParameter("uname"),
								req.getParameter("pass"));
		
		credentials.putIfAbsent(newUser.getName(), newUser.getPass());
//		req.setAttribute("credentialMap", credentials);
		getServletContext().setAttribute("credentialMap", credentials);
		
		out.println("Registered Successfully !");
		req.getRequestDispatcher("loginP32.html").include(req, resp);
	}
}
