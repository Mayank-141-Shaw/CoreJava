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
import com.servletcarapp.model.Car;

@WebServlet(urlPatterns = "/carapp/addcar")
public class AdminAddCarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Admin admin = (Admin) req.getSession().getAttribute("currentAdmin");
		String model = req.getParameter("carmodel");
		int carprice = Integer.parseInt(req.getParameter("carprice"));
		
		// update the car status are rented to user id and increase car count by 1
		// forward back to usermenu.html
		
		// simply add new car to the car table
		
		int status;
		try {
			Car car = new Car();
			car.setModel(model);
			car.setPrice(carprice);
			car.setLentStatus(false);
			// update the first query
			status = CarController.addNewCar(car);
			if(status == 1) {
				// success 
				
				req.getSession().setAttribute("currentAdmin", admin);
				req.getRequestDispatcher("adminmenu.html").include(req, resp);
				out.println("<h1>Car Added successfully</h1>");
			}else {
				req.getRequestDispatcher("adminmenu.html").include(req, resp);
				out.println("<h1>Some error occured</h1>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
