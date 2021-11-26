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
	<div class="container">
		<h1>Welcome to JSP Car Rental </h1>
	</div>
	<div class="container">
		<div class="console-box">
			<form action="homepage.jsp" method="POST">
				<input type="hidden" name="action" value="register"/>
				<button type="submit">REGISTER ACCOUNT</button>	
			</form>
			<form action="homepage.jsp" method="POST">
				<input type="hidden" name="action" value="login"/>
				<button type="submit">LOGIN</button>	
			</form>
			<form action="homepage.jsp" method="POST">
				<input type="hidden" name="action" value="adminlogin"/>
				<button type="submit">ADMIN LOGIN</button>	
			</form>
			<form action="homepage.jsp" method="POST">
				<input type="hidden" name="action" value="showAllCars"/>
				<button type="submit">SHOW ALL CARS</button>	
			</form>
			<form action="homepage.jsp" method="POST">
				<input type="hidden" name="action" value="showAvailableCars"/>
				<button type="submit">SHOW ALL AVAILABLE CARS</button>	
			</form>
			<a href="../index.html"><button>EXIT</button>	</a>	
			
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