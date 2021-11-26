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
	<jsp:useBean id="account" class="com.jspcarapp.bean.Account" />
	<jsp:setProperty property="*" name="account"/>
	<% 
		// add the new account into the table as new user
		// use account controller to add to the db
		System.out.println(account.getName());
	System.out.println(account.getAddress());
	System.out.println(account.getPhone());
	System.out.println(account.getUsername());
	System.out.println(account.getPassword());
		int status = AccountController.addNewAccount(account);
		if(status > 0){
			// success redirect back to homepage.html
			// set a alert message to the session
			session.setAttribute("alert", "Registered Successfully");
			
			response.sendRedirect("homepagemenu.jsp");
		}else{
			session.setAttribute("alert", "Not Registered");
			response.sendRedirect("homepagemenu.jsp");
		}
		
	%>
</body>
</html>