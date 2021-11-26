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
		int carid = Integer.parseInt(request.getParameter("carid"));
		Account acc = (Account) session.getAttribute("currentUser");
		// update the car status are rented to user id and increase car count by 1
		// forward back to usermenu.html
			
		int status1, status2, status3;
		// update the first query
		status1 = CarController.rentCar(carid);
		// insert new car id and user id
		status2 = CarlentController.addNewCarlent(carid, acc.getId());
		// update user by increase his car rent count
		status3 = AccountController.increaseCarsRented(acc.getId());
		if(status1 == 1 && status2 == 1 && status3 == 1) {
			// success 
			// update the session object by increasing rents count
			acc.setCarsRented( acc.getCarsRented()+1 );
			session.setAttribute("currentUser", acc);
			session.setAttribute("alert", "Car Rented Successfully");
			response.sendRedirect("usermenu.jsp");
		}else {
			session.setAttribute("alert", "Some Error Occured");
			response.sendRedirect("usermenu.jsp");
		}			
		
	%>
</body>
</html>