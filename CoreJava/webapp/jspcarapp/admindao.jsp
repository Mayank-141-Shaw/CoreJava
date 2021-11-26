<%@page import="java.util.Iterator"%>
<%@page import="com.jspcarapp.dao.CarController"%>
<%@page import="com.jspcarapp.bean.Car"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jspcarapp.bean.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		String action = request.getParameter("action");
		// check the type of action
		if(action.equals("viewdata")){
			// show the data here
			Admin admin = (Admin) session.getAttribute("currentAdmin");
			
			request.getRequestDispatcher("adminmenu.jsp").include(request, response);
			out.println("<div class='container table-container'><h1>Admin Details</h1>");
			out.println("<table><tr><td>User ID</td><td>"+admin.getId()+"</td></tr>"
					+ "<tr><td>Name</td><td>"+admin.getName()+"</td></tr>"
					+ "<tr><td>Address</td><td>"+admin.getAddress()+"</td></tr>"
					+ "<tr><td>Mobile</td><td>"+admin.getPhone()+"</td></tr>"
					+ "<tr><td>User Name</td><td>"+admin.getUsername()+"</td></tr>"
					+ "<tr><td>Password</td><td>"+admin.getPassword()+"</td></tr>");
			out.println("</table></div>");			
		}else if(action.equals("addcar")){
			
			ArrayList<Car> cars = CarController.getAllCars();
			Admin acc = (Admin)session.getAttribute("currentAdmin");
			if(session.getAttribute("currentAdmin") != null) {
				out.print("<html>"
						+ "<head>"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
						+ "<link href=\"style.css\" rel=\"stylesheet\">"
						+ "</head><body>");
				
				out.print("<div class='container'>");
				out.print("<form action='adminaddcar.jsp' method='POST'>");
				out.print("<table>"
						+ "<tr><td><label>Enter car Model</label></td>"
						+ "<td><input type='text' name='model' required/></td></tr>"
						+ "<tr><td><label>Enter Car Price</label></td>"
						+ "<td><input type='number' min='0' name='price' required/></td></tr>"
						+ "<tr><td><input type='reset' value='RESET' /></td>"
						+ "<td><input type='submit' value='SUBMIT'/></td></tr>"
						+ "</table>");
				out.print("</form></div>");
				
				out.println("<div class='container table-container'><h1>All Cars In Stock</h1>");
				out.println("<table>");
				out.println("<tr><th>Car Id</th><th>Car Model</th><th>Car Price</th></tr>");
				Iterator<Car> itr = cars.iterator();
				while(itr.hasNext()){
					Car car  = itr.next();
					out.println("<tr> <td>"+car.getCarid()+"</td> "
							+ "<td>"+car.getModel()+"</td> "
							+ "<td>"+car.getPrice()+"</td> "
							+ "</tr>");
				}
				out.println("</table></div></body></html>");
				
			}else response.sendRedirect("homepagemenu.jsp");
		}else if(action.equals("removecar")){
			
			ArrayList<Car> cars = CarController.getAvailableCars();
			Admin acc = (Admin)session.getAttribute("currentAdmin");
			if(session.getAttribute("currentAdmin") != null) {
				out.print("<html>"
						+ "<head>"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
						+ "<link href=\"style.css\" rel=\"stylesheet\">"
						+ "</head><body>");
				
				out.print("<div class='container'>");
				out.print("<form action='adminremovecar.jsp' method='POST'>");
				out.print("<table>"
						+ "<tr><td><label>Enter car id to remove</label></td>"
						+ "<td><input type='number' name='carid' required/></td></tr>"
						+ "<tr><td><input type='reset' value='RESET' /></td>"
						+ "<td><input type='submit' value='SUBMIT'/></td></tr>"
						+ "</table>");
				out.print("</form></div>");
				
				out.println("<div class='container table-container'><h1>All Cars Available</h1>");
				out.println("<table>");
				out.println("<tr><th>Car Id</th><th>Car Model</th><th>Car Price</th></tr>");
				Iterator<Car> itr = cars.iterator();
				while(itr.hasNext()){
					Car car  = itr.next();
					out.println("<tr> <td>"+car.getCarid()+"</td> "
							+ "<td>"+car.getModel()+"</td> "
							+ "<td>"+car.getPrice()+"</td> "
							+ "</tr>");
				}
				out.println("</table></div></body></html>");
				
			}else response.sendRedirect("homepagemenu.jsp");
			
		}else if(action.equals("logout")){
			// add alert as log out successful
			session.setAttribute("currentAdmin", null);			
			session.setAttribute("alert", "Logged Out");
			// session.invalidate();
			// redirect to homepagemenu.jsp
			response.sendRedirect("homepagemenu.jsp");
		}
	%>
</body>
</html>