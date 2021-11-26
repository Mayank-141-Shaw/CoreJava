<%@page import="com.jspcarapp.bean.Car"%>
<%@page import="com.jspcarapp.bean.Admin"%>
<%@page import="com.jspcarapp.dao.CarlentController"%>
<%@page import="com.jspcarapp.bean.Account"%>
<%@page import="com.jspcarapp.dao.CarController"%>
<%@page import="com.jspcarapp.dao.AccountController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.js"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% 
	Admin admin = (Admin) session.getAttribute("currentAdmin");
	
	int carid = Integer.parseInt(request.getParameter("carid"));
		
	// simply remove the car from car table
	
	int status;
	status = CarController.removeCar(carid);
	
	if(status==1) {
		// success go back to adminmenu.html
		session.setAttribute("currentAdmin", admin);
		session.setAttribute("alert", "Car Removed Successfully");
		response.sendRedirect("adminmenu.jsp");
	}else {
		session.setAttribute("alert", "Some Error Occured");
		response.sendRedirect("adminmenu.jsp");
	}
	
		
	%>
</body>
</html>