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
	<jsp:useBean id="newData" class="com.jspcarapp.bean.Account"/>
	<jsp:setProperty property="*" name="newData"/>
	<% 
			// get username and password
			Account curAcc = (Account)session.getAttribute("currentUser");
			if(curAcc != null) {
				// update the account , if success update sesseion currentUser object
				// else keep session object same give some error msg and go back to usermenu
				// cars rented amount cannot be changed explicitly by user
				
				int status;
				try {
					newData.setCarsRented(curAcc.getCarsRented());
					newData.setId(curAcc.getId());
					status = AccountController.updateAccount(newData);
					if(status != 0) {
						// success , update in session and forward to usermenu.html
						session.setAttribute("currentUser", newData);
						session.setAttribute("alert", "Update Successful");
						response.sendRedirect("usermenu.jsp");
					}else {
						session.setAttribute("alert", "Cannot Update");
						response.sendRedirect("usermenu.jsp");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				session.setAttribute("alert", "Not Logged In");
				response.sendRedirect("homepagemenu.jsp");
			}
		
	%>
</body>
</html>