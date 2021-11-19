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

@WebServlet(urlPatterns = "/carapp/returncar")
public class ReturnCarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Account acc = (Account) req.getSession().getAttribute("currentUser");
		int uid = acc.getId();
		int carid = Integer.parseInt(req.getParameter("carid"));
		
		// update the car status are rented to user id as false and decrease car count by 1
		// delete row where carid match for given uid
		// forward back to usermenu.html
		
		
		int status1, status2, status3;
		try {
			// update car as false
			status1 = CarController.returnCar(carid);
			// remove existing carlent
			status2 = CarlentController.removeCarlent(carid, uid);
			// update user by decrease his car rent count
			status3 = AccountController.decreaseCarsRented(uid);
			if(status1 == 1 && status2 == 1 && status3 == 1) {
				// success reduce count by 1
				acc.setCarsRented( acc.getCarsRented()-1 );
				req.getSession().setAttribute("currentUser", acc);
				req.getRequestDispatcher("usermenu.html").include(req, resp);
				out.println("<h1>Car Returned successfully</h1>");
			}else {
				req.getRequestDispatcher("usermenu.html").include(req, resp);
				out.println("<h1>Some error occured</h1>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
