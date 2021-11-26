<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%! 
		public double findEmi(int loanAmt, int period, float rate){
			return ((loanAmt * rate * Math.pow((1 + rate), period)) / ( Math.pow((1 + rate), period) - 1));
		}
	%>
	<%
		int loanAmt = Integer.parseInt(request.getParameter("loanAmt"));
		int period = Integer.parseInt(request.getParameter("period"))*12; // into months
		float rate = (float)Integer.parseInt(request.getParameter("rate"))/1200; // in monthly rate
		
		double emi = findEmi(loanAmt, period, rate);
		System.out.println(emi);
		System.out.println(loanAmt);
		System.out.println(period);
		System.out.println(rate);
	%>
	<h1>EMI Calculator Result</h1>
	<div style="display:flex; text-align:center; background-color: red; padding: 10px; flex-basis: auto;">
		<span style="color: white; font-weight: bold;">
			<%= "Hi, Your Monthly EMI will be : Rs"+Math.ceil(emi) %>
		</span>
	</div>
</body>
</html>