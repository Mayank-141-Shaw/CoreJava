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
import com.servletcarapp.model.Account;

@WebServlet(urlPatterns = "/carapp/userupdate")
public class UserUpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		// get username and password
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		HttpSession session = req.getSession();
		Account curAcc = (Account)session.getAttribute("currentUser");
		if(curAcc != null) {
			// update the account , if success update sesseion currentUser object
			// else keep session object same give some error msg and go back to usermenu
			// cars rented amount cannot be changed explicitly by user
			
			int status;
			try {
				Account acc = new Account();
				acc.setId(curAcc.getId());
				acc.setName(name);
				acc.setAddress(address);
				acc.setPhone(phone);
				acc.setUsername(uname);
				acc.setPassword(pass);
				acc.setCarsRented(curAcc.getCarsRented());
				status = AccountController.updateAccount(acc);
				if(status != 0) {
					// success , update in session and forward to usermenu.html
					session.setAttribute("currentUser", acc);
					req.getRequestDispatcher("usermenu.html").forward(req, resp);
				}else {
					req.getRequestDispatcher("homepage.html").include(req, resp);
					out.println("<div class='container'><h1>Not Logged In</h1></div>");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else req.getRequestDispatcher("homepage.html").forward(req, resp);
		
		
	}
}
