package com.servletcarapp.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servletcarapp.controller.CarController;
import com.servletcarapp.model.Car;

@WebServlet(urlPatterns = "/carapp/homepage")
public class HomePageServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String action = req.getParameter("action");
		System.out.println("Action : "+action);
		
		
		try {
			// check what action to handle
			if(action.equals("register")) {
				// forward to register.html
				// get input and add it to db
				// from there forward back to homepage.html
				req.getRequestDispatcher("register.html").forward(req, resp);
			}else if(action.equals("login")) {
				// send to userlogin.html
				req.getRequestDispatcher("userlogin.html").forward(req, resp);
			}else if(action.equals("adminlogin")) {
				// send to userlogin.html
				req.getRequestDispatcher("adminlogin.html").forward(req, resp);
			}else if(action.equals("showAllCars")) {
			
				// include the homepage and add all cars data from the db
				
				ArrayList<Car> cars = CarController.getAllCars();
				req.getRequestDispatcher("homepage.html").include(req, resp);
				out.println("<div class='container table-container'><h1>All Cars</h1>");
				out.println("<table>");
				out.println("<tr><th>Car Id</th><th>Car Model</th><th>Car Price</th></tr>");
				cars.forEach(car -> {
					out.println("<tr> <td>"+car.getCarid()+"</td> "
							+ "<td>"+car.getModel()+"</td> "
							+ "<td>"+car.getPrice()+"</td> "
							+ "</tr>");
				});
				out.println("</table></div>");
			
			}else if(action.equals("showAvailableCars")) {
				
				// include the homepage and all available cars only
				
				ArrayList<Car> cars = CarController.getAvailableCars();
				req.getRequestDispatcher("homepage.html").include(req, resp);
				out.println("<div class='container table-container'><h1>All Cars</h1>");
				out.println("<table>");
				out.println("<tr><th>Car Id</th><th>Car Model</th><th>Car Price</th></tr>");
				cars.forEach(car -> {
					out.println("<tr> <td>"+car.getCarid()+"</td> "
							+ "<td>"+car.getModel()+"</td> "
							+ "<td>"+car.getPrice()+"</td> "
							+ "</tr>");
				});
				out.println("</table></div>");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
