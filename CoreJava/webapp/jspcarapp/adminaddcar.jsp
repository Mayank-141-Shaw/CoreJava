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
<jsp:useBean id="car" class="com.jspcarapp.bean.Car"/>
<jsp:setProperty property="*" name="car"/>
	<% 
		
	Admin admin = (Admin) session.getAttribute("currentAdmin");
	
	// simply add new car to the car table
	
	int status;
	car.setLentStatus(false);
	// update the first query
	status = CarController.addNewCar(car);
	if(status == 1) {
		// success 
		session.setAttribute("currentAdmin", admin);
		session.setAttribute("alert", "Car Added Successfully");
		response.sendRedirect("adminmenu.jsp");
	}else {
		session.setAttribute("alert", "Some Error Occured");
		response.sendRedirect("adminmenu.jsp");
	}
				
		
	%>
</body>
</html>