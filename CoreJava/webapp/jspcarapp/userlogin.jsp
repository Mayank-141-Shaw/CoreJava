<%@page import="com.jspcarapp.bean.Account"%>
<%@page import="com.jspcarapp.dao.AccountController"%>
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
		// get the username and password from the form
		// get account object from db using username
		// if account is null user does not exist --> redirect to homepage
		// if account is present --> make a alert message and add user to session tracking --> redirect to usermenu
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Account account = AccountController.getAccount(username, password);
		
		if(account != null){
			session.setAttribute("alert", "Logged in Successfully");
			session.setAttribute("currentUser", account);
			response.sendRedirect("usermenu.jsp");
		}else{
			session.setAttribute("alert", "User does not exist");
			response.sendRedirect("userloginform.jsp");
		}
		
	%>
</body>
</html>