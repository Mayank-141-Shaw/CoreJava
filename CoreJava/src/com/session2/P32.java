package com.session2;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(urlPatterns = "/login-p32")
public class P32 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static HashMap<String, String> credentials = new HashMap<String, String>();
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		credentials.putIfAbsent("admin", "admin123");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if(getServletContext().getAttribute("credentialMap") != null) {
			System.out.println("Its not null");
			credentials.putAll( (Map<String,String>) getServletContext().getAttribute("credentialMap"));
//			credentials.putAll( (Map<String,String>) req.getAttribute("credentialMap"));
		}
		System.out.println(credentials.keySet().toString());
		String uname = req.getParameter("name");
		System.out.println("Uname : "+uname);
		String pass = req.getParameter("pass");
		System.out.println("Password : "+pass);
		
		Enumeration<String> names = req.getAttributeNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement().toString());
		}
		
		if( !credentials.containsKey(uname.toLowerCase()) ) {
//			req.setAttribute("credentialMap", (Object)credentials);
			getServletContext().setAttribute("credentialMap", credentials);
			req.getRequestDispatcher("registerP32.html").forward(req, resp);
		}else {
			System.out.println("Inside cred : "+credentials.get(uname));
			
			if( !credentials.get(uname).equals(pass) ) {
				// wrong password try again
//				req.setAttribute("credentialMap", (Object)credentials);
				getServletContext().setAttribute("credentialMap", credentials);
				req.getRequestDispatcher("loginP32.html").include(req, resp);
				out.println("Wrong password try again");
			}else {
				// login was success
				
				out.println("Welcome! "+uname+"<br>");
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
