<%@page import="com.jspcarapp.bean.Admin"%>
<%@page import="com.jspcarapp.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<% Admin admin = (Admin)session.getAttribute("currentAdmin");
		String username = admin.getUsername();
	%>
	<div class="container">
		<h1>Welcome <%= username.toUpperCase() %></h1>
	</div>
	<div class="container">
		<div class="console-box">
			<form action="admindao.jsp" method="POST">
				<input type="hidden" name="action" value="viewdata"/>
				<button type="submit">VIEW DETAILS</button>	
			</form>
			<form action="admindao.jsp" method="POST">
				<input type="hidden" name="action" value="addcar"/>
				<button type="submit">ADD A CAR</button>	
			</form>
			<form action="admindao.jsp" method="POST">
				<input type="hidden" name="action" value="removecar"/>
				<button type="submit">REMOVE A CAR</button>	
			</form>
			<form action="admindao.jsp" method="POST">
				<input type="hidden" name="action" value="logout"/>
				<button type="submit">LOG OUT</button>	
			</form>
			
		</div>
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