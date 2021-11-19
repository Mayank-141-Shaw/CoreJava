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

@WebServlet(urlPatterns = "/carapp/rentcar")
public class RentCarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Account acc = (Account) req.getSession().getAttribute("currentUser");
		int uid = acc.getId();
		int carid = Integer.parseInt(req.getParameter("carid"));
		
		// update the car status are rented to user id and increase car count by 1
		// forward back to usermenu.html
		
		int status1, status2, status3;
		try {
			// update the first query
			status1 = CarController.rentCar(carid);
			// insert new car id and user id
			status2 = CarlentController.addNewCarlent(carid, uid);
			// update user by increase his car rent count
			status3 = AccountController.increaseCarsRented(uid);
			if(status1 == 1 && status2 == 1 && status3 == 1) {
				// success 
				// update the session object by increasing rents count
				acc.setCarsRented( acc.getCarsRented()+1 );
				req.getSession().setAttribute("currentUser", acc);
				req.getRequestDispatcher("usermenu.html").include(req, resp);
				out.println("<h1>Car Rented successfully</h1>");
			}else {
				req.getRequestDispatcher("usermenu.html").include(req, resp);
				out.println("<h1>Some error occured</h1>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
