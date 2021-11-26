<%@page import="java.util.Calendar"%>
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
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		int id = Integer.parseInt(request.getParameter("id"));
		String gender = request.getParameter("gender");
		
		int hour = Calendar.HOUR_OF_DAY;
		String greet;
		if(hour>=4 && hour<12) greet = "Good Morning";
		else if(hour>= 12 && hour <=16) greet = "Good Afternoon";
		else if(hour>16 && hour<22) greet = "Good Evening";
		else greet = "Good Night";
		
	%>
	<h1>Student Details</h1>
	<h4>
		<%= "Hi "+name+", "+greet+" "+((gender.equals("male"))?"Sir":"Madam") %>
	</h4>
</body>
</html>