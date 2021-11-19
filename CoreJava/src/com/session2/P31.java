package com.session2;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register-p31")
public class P31  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Enumeration<String> names = req.getParameterNames();
		// print the result
		out.println("<table border='2'>");
		while(names.hasMoreElements()) {
			String ob = names.nextElement();
			out.println("<tr><td>"+ob.toUpperCase()+" : </td><td>"+req.getParameter(ob)+"</td></tr>");
		}
		out.println("</table>");
		out.println("Registered Successfully");
	}
}
