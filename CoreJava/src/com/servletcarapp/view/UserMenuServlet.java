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
import com.servletcarapp.model.Car;

@WebServlet(urlPatterns = "/carapp/usermenu")
public class UserMenuServlet extends HttpServlet{

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
				Account account = (Account) session.getAttribute("currentUser");
				
				req.getRequestDispatcher("usermenu.html").include(req, resp);
				out.println("<div class='container table-container'><h1>User Details</h1>");
				out.println("<table><tr><td>User ID</td><td>"+account.getId()+"</td></tr>"
						+ "<tr><td>Name</td><td>"+account.getName()+"</td></tr>"
						+ "<tr><td>Address</td><td>"+account.getAddress()+"</td></tr>"
						+ "<tr><td>Mobile</td><td>"+account.getPhone()+"</td></tr>"
						+ "<tr><td>User Name</td><td>"+account.getUsername()+"</td></tr>"
						+ "<tr><td>Password</td><td>"+account.getPassword()+"</td></tr>"
						+ "<tr><td>Cars Rented</td><td>"+account.getCarsRented()+"</td></tr>");
				out.println("</table></div>");
				
			}else if(action.equals("rentcar")) {
				// select one car from available to rent from the list of cars 
				// then submit it to RentCarServlet
				// update the car status are rented to user id and increase car count by 1
				// forward back to usermenu.html
				ArrayList<Car> cars = CarController.getAvailableCars();
				HttpSession session = req.getSession();
				session.getAttribute("currentUser");
				if(session.getAttribute("currentUser") != null) {
					out.print("<html>"
							+ "<head>"
							+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
							+ "<link href=\"style.css\" rel=\"stylesheet\">"
							+ "</head><body>");
					out.print("<div class='container'>");
					out.print("<form action='rentcar' method='POST'>");
					out.print("<table>"
							+ "<tr><td><label>Enter car id to rent</label></td>"
							+ "<td><input type='number' name='carid'/></td></tr>"
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
					
				}else req.getRequestDispatcher("homepage.html").forward(req, resp);
				
			}else if(action.equals("returncar")) {
			
				// show list of all cars rented by user by its id
				// enter car id to return and send req to ReturnCarServlet
				// update car status as false and reduce user car count by 1
				// forward back to usermenu.html
				HttpSession session = req.getSession();
				Account acc;
				if(session.getAttribute("currentUser") != null) {
					acc = (Account) session.getAttribute("currentUser");
					ArrayList<Car> cars = CarController.getCarsRentedByUser(acc.getId());
					out.print("<html>"
							+ "<head>"
							+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
							+ "<link href=\"style.css\" rel=\"stylesheet\">"
							+ "</head><body>");
					out.print("<div class='container'>");
					out.print("<form action='returncar' method='POST'>");
					out.print("<table>"
							+ "<tr><td><label>Enter car id to return</label></td>"
							+ "<td><input type='number' name='carid'/></td></tr>"
							+ "<tr><td><input type='reset' value='RESET' /></td>"
							+ "<td><input type='submit' value='SUBMIT'/></td></tr>"
							+ "</table>");
					out.print("</form></div>");
					
					out.println("<div class='container table-container'><h1>All Rented Cars</h1>");
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
				
				
				
			}else if(action.equals("updateself")) {
				
				// update user details
				// better send to another updateuser.html
				// get data to update and update table in UpdateUserServlet
				// forward back to usermanu.html
				req.getRequestDispatcher("userupdate.html").forward(req, resp);
				
			}else if(action.equals("logout")) {
				// remove session currentUser data
				// forward back to homepage.html
				req.getSession().removeAttribute("currentUser");
				req.getSession().invalidate();
				req.getRequestDispatcher("/carapp/homepage.html").forward(req, resp);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
