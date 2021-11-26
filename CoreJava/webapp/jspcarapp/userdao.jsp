<%@page import="java.util.Iterator"%>
<%@page import="com.jspcarapp.dao.CarController"%>
<%@page import="com.jspcarapp.bean.Car"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jspcarapp.bean.Account"%>
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
			Account account = (Account) session.getAttribute("currentUser");
			
			request.getRequestDispatcher("usermenu.jsp").include(request, response);
			out.println("<div class='container table-container'><h1>User Details</h1>");
			out.println("<table><tr><td>User ID</td><td>"+account.getId()+"</td></tr>"
					+ "<tr><td>Name</td><td>"+account.getName()+"</td></tr>"
					+ "<tr><td>Address</td><td>"+account.getAddress()+"</td></tr>"
					+ "<tr><td>Mobile</td><td>"+account.getPhone()+"</td></tr>"
					+ "<tr><td>User Name</td><td>"+account.getUsername()+"</td></tr>"
					+ "<tr><td>Password</td><td>"+account.getPassword()+"</td></tr>"
					+ "<tr><td>Cars Rented</td><td>"+account.getCarsRented()+"</td></tr>");
			out.println("</table></div>");
			
		}else if(action.equals("rentcar")){
			ArrayList<Car> cars = CarController.getAvailableCars();
			Account acc = (Account)session.getAttribute("currentUser");
			if(session.getAttribute("currentUser") != null) {
				out.print("<html>"
						+ "<head>"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
						+ "<link href=\"style.css\" rel=\"stylesheet\">"
						+ "</head><body>");
				out.print("<div class='container'>");
				out.print("<form action='rentcar.jsp' method='POST'>");
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
			
		}else if(action.equals("returncar")){
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
				out.print("<form action='returncar.jsp' method='POST'>");
				out.print("<table>"
						+ "<tr><td><label>Enter car id to return</label></td>"
						+ "<td><input type='number' name='carid'/></td></tr>"
						+ "<tr><td><input type='reset' value='RESET' /></td>"
						+ "<td><input type='submit' value='SUBMIT'/></td></tr>"
						+ "</table>");
				out.print("</form></div>");
				
				out.println("<div class='container table-container'><h1>All Cars</h1>");
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
			}
			else response.sendRedirect("homepagemenu.jsp");
			
		}else if(action.equals("update")){
			if(session.getAttribute("currentUser") != null) {
				Account acc = (Account) session.getAttribute("currentUser");
				out.print("<html>"
						+ "<head>"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
						+ "<link href=\"style.css\" rel=\"stylesheet\">"
						+ "</head><body>");
				out.println("<div class='container'><h1>User Update Form</h1></div>");
				out.print("<div class='container'>");
				out.print("<form action=\"userupdate.jsp\" method=\"POST\">"
						+"<table>"
						+"<tr>"
						+"<td><label>Name</label></td>"
						+"<td><input type=\"text\" name=\"name\" value="+acc.getName()+" required /></td>"
						+"</tr>"
						+"<tr>"
						+"<td><label>Address</label></td>"
						+"<td><input type=\"text\" name=\"address\" value="+acc.getAddress()+" required /></td>"
						+"</tr>"
						+"<tr>"
						+"<td><label>Phone</label></td>"
						+"<td><input type=\"tel\" name=\"phone\" value="+acc.getPhone()+" required /></td>"
						+"</tr>"
						+"<tr>"
						+"<td><label>User Name</label></td>"
						+"<td><input type=\"text\" name=\"username\" value="+acc.getUsername()+" required /></td>"
						+"</tr>"
						+"<tr>"
						+"<td><label>Password</label></td>"
						+"<td><input type=\"password\" name=\"password\" value="+acc.getPassword()+" required /></td>"
						+"</tr>"
						+"<tr>"
						+"<td><input type=\"reset\" value=\"RESET\" /></td>"
						+"<td><input type=\"submit\" value=\"SUBMIT\" /></td>"
					+"</tr></table></form>");
				out.println("</body></html>");
			}
			
			
		}else if(action.equals("logout")){
			// add alert as log out successful
			session.setAttribute("currentUser", null);			
			session.setAttribute("alert", "Logged Out");
			// session.invalidate();
			// redirect to homepagemenu.jsp
			response.sendRedirect("homepagemenu.jsp");
		}
	%>
</body>
</html>