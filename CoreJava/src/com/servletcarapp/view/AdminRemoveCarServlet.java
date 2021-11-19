package com.servletcarapp.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servletcarapp.controller.AccountController;
import com.servletcarapp.controller.CarController;
import com.servletcarapp.controller.CarlentController;
import com.servletcarapp.model.Account;
import com.servletcarapp.model.Admin;

@WebServlet(urlPatterns = "/carapp/removecar")
public class AdminRemoveCarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Admin admin = (Admin) req.getSession().getAttribute("currentAdmin");
		int carid = Integer.parseInt(req.getParameter("carid"));
		
		// update the car status are rented to user id as false and decrease car count by 1
		// delete row where carid match for given uid
		// forward back to usermenu.html
		
		// simply remove the car from car table
		
		int status;
		try {
			status = CarController.removeCar(carid);
			
			if(status==1) {
				// success go back to adminmenu.html
				req.getSession().setAttribute("currentAdmin", admin);
				req.getRequestDispatcher("adminmenu.html").include(req, resp);
				out.println("<h1>Car Removed successfully</h1>");
			}else {
				req.getRequestDispatcher("adminmenu.html").include(req, resp);
				out.println("<h1>Some error occured</h1>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
