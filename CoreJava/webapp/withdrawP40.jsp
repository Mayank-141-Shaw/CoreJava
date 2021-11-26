<%@page import="com.session.jsp.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="exception.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		int amount = Integer.parseInt(request.getParameter("amt"));
	%>
	<%= Account.withdraw(amount) %>
	<br>
	<%= Account.showBalance() %>
</body>
</html>