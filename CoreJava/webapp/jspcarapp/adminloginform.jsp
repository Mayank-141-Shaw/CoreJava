<%@page import="com.jspcarapp.dao.AccountController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Admin Login</h1>
	</div>
	<div class="container">
		<form action="adminlogin.jsp" method="POST">
			<table>
				<tr>
					<td><label>User Name</label></td>
					<td><input type="text" name="username" required /></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><input type="password" name="password" required /></td>
				</tr>
				<tr>
					<td><input type="reset" value="RESET" /></td>
					<td><input type="submit" value="SUBMIT" /></td>
				</tr>
			</table>
		</form>
		
	</div>
	
	<% if(session.getAttribute("alert") != null){
			out.print("<div class=\"container\">");
			out.print("<span style=\"padding: 10px; width:inherit; border-radius: 15px;	background-color: green;color: white;font-weight: bolder;font-size: 15px;\" class=\"alert-msg\">"+session.getAttribute("alert").toString()+"</span>");
			out.print("</div>");
			session.setAttribute("alert", null);
			}
		%>
</body>
</html>