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
		Account acc = (Account) session.getAttribute("currentUser");
		int uid = acc.getId();
		int carid = Integer.parseInt(request.getParameter("carid"));
		
		// update the car status are rented to user id as false and decrease car count by 1
		// delete row where carid match for given uid
		// forward back to usermenu.html
		
		
		int status1, status2, status3;
		// update car as false
		status1 = CarController.returnCar(carid);
		// remove existing carlent
		status2 = CarlentController.removeCarlent(carid, uid);
		// update user by decrease his car rent count
		status3 = AccountController.decreaseCarsRented(uid);
		if(status1 == 1 && status2 == 1 && status3 == 1) {
			// success reduce count by 1
			acc.setCarsRented( acc.getCarsRented()-1 );
			session.setAttribute("currentUser", acc);
			session.setAttribute("alert", "Car Returned Successfully");
			response.sendRedirect("usermenu.jsp");
		}else {
			session.setAttribute("alert", "Some Error Occured");
			response.sendRedirect("usermenu.jsp");
		}						
	%>
</body>
</html>