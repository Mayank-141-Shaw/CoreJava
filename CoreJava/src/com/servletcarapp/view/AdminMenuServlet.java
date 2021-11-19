package com.servletcarapp.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servletcarapp.controller.CarController;
import com.servletcarapp.model.Account;
import com.servletcarapp.model.Admin;
import com.servletcarapp.model.Car;

@WebServlet(urlPatterns = "/carapp/adminmenu")
public class AdminMenuServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String action = req.getParameter("action");
		System.out.println("Action : "+action);
		
		
		try {
			// check what action to handle
			if(action.equals("seedata")) {
				// get user data from servletcontext
				HttpSession session = req.getSession();
				Admin admin = (Admin) session.getAttribute("currentAdmin");
				
				req.getRequestDispatcher("adminmenu.html").include(req, resp);
				out.println("<div class='container table-container'><h1>User Details</h1>");
				out.println("<table><tr><td>Admin ID</td><td>"+admin.getId()+"</td></tr>"
						+ "<tr><td>Name</td><td>"+admin.getName()+"</td></tr>"
						+ "<tr><td>Address</td><td>"+admin.getAddress()+"</td></tr>"
						+ "<tr><td>Mobile</td><td>"+admin.getPhone()+"</td></tr>"
						+ "<tr><td>User Name</td><td>"+admin.getUsername()+"</td></tr>"
						+ "<tr><td>Password</td><td>"+admin.getPassword()+"</td></tr>");
				out.println("</table></div>");
				
			}else if(action.equals("addcar")) {
				// select one car from available to rent from the list of cars 
				// then submit it to AdminAddCarServlet
				// add new car row to the car table there
				// forward back to adminmenu.html
				ArrayList<Car> cars = CarController.getAllCars();
				HttpSession session = req.getSession();
				session.getAttribute("currentAdmin");
				if(session.getAttribute("currentAdmin") != null) {
					out.print("<html>"
							+ "<head>"
							+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
							+ "<link href=\"style.css\" rel=\"stylesheet\">"
							+ "</head><body>");
					out.print("<div class='container'>");
					out.print("<form action='addcar' method='POST'>");
					out.print("<table>"
							+ "<tr><td><label>Enter car Model</label></td>"
							+ "<td><input type='text' name='carmodel' required/></td></tr>"
							+ "<tr><td><label>Enter Car Price</label></td>"
							+ "<td><input type='number' min='0' name='carprice' required/></td></tr>"
							+ "<tr><td><input type='reset' value='RESET' /></td>"
							+ "<td><input type='submit' value='SUBMIT'/></td></tr>"
							+ "</table>");
					out.print("</form></div>");
					
					out.println("<div class='container table-container'><h1>All Cars</h1>");
					out.println("<table>");
					out.println("<tr><th>Car Id</th><th>Car Model</th><th>Car Price</th></tr>");
					cars.forEach(car -> {
						out.println("<tr> <td>"+car.getCarid()+"</td> "
								+ "<td>"+car.getModel()+"</td> "
								+ "<td>"+car.getPrice()+"</td> "
								+ "</tr>");
					});
					out.println("</table></div></body></html>");
					
				}else req.getRequestDispatcher("homepage.html").forward(req, resp);
				
			}else if(action.equals("removecar")) {
			
				// show list of all available cars rented by user by its id
				// enter car id to remove and send req to AdminRemoveCarServlet
				// delete car using its id given
				// forward back to adminmenu.html
				HttpSession session = req.getSession();
				Admin admin;
				if(session.getAttribute("currentAdmin") != null) {
					admin = (Admin) session.getAttribute("currentAdmin");
					ArrayList<Car> cars = CarController.getAvailableCars();
					out.print("<html>"
							+ "<head>"
							+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
							+ "<link href=\"style.css\" rel=\"stylesheet\">"
							+ "</head><body>");
					out.print("<div class='container'>");
					out.print("<form action='removecar' method='POST'>");
					out.print("<table>"
							+ "<tr><td><label>Enter car id to remove</label></td>"
							+ "<td><input type='number' name='carid' required/></td></tr>"
							+ "<tr><td><input type='reset' value='RESET' /></td>"
							+ "<td><input type='submit' value='SUBMIT'/></td></tr>"
							+ "</table>");
					out.print("</form></div>");
					
					out.println("<div class='container table-container'><h1>All Available Cars</h1>");
					out.println("<table>");
					out.println("<tr><th>Car Id</th><th>Car Model</th><th>Car Price</th></tr>");
					cars.forEach(car -> {
						out.println("<tr> <td>"+car.getCarid()+"</td> "
								+ "<td>"+car.getModel()+"</td> "
								+ "<td>"+car.getPrice()+"</td> "
								+ "</tr>");
					});
					out.println("</table></div></body></html>");
				}
				else req.getRequestDispatcher("homepage.html").forward(req, resp);
				
				
				
			}else if(action.equals("logout")) {
				// remove session currentUser data
				// forward back to homepage.html
				req.getSession().removeAttribute("currentAdmin");
				req.getSession().invalidate();
				req.getRequestDispatcher("/carapp/homepage.html").forward(req, resp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
