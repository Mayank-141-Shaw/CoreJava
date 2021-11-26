<%@page import="java.util.Iterator"%>
<%@page import="com.jspcarapp.dao.CarController"%>
<%@page import="com.jspcarapp.bean.Car"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
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
		if(action.equals("register")){
			// redirect to registerform.jsp
			response.sendRedirect("registerform.jsp");
		}else if(action.equals("login")){
			// redirect to userloginform.jsp
			response.sendRedirect("userloginform.jsp");
		}else if(action.equals("adminlogin")){
			// redirect to adminloginform.jsp
			response.sendRedirect("adminloginform.jsp");
		}else if(action.equals("showAllCars")){
			// include the homepage and show the car data
			ArrayList<Car> cars = CarController.getAllCars();
			request.getRequestDispatcher("homepagemenu.jsp").include(request, response);
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
			out.println("</table></div>");
		}else if(action.equals("showAvailableCars")){
			// include the homepage and show the cars
			ArrayList<Car> cars = CarController.getAvailableCars();
			request.getRequestDispatcher("homepagemenu.jsp").include(request, response);
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
			out.println("</table></div>");
		}
	%>
</body>
</html>