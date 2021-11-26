package com.session.jsp;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomGreetTag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		
		@SuppressWarnings("deprecation")
		int hour = new Date().getHours();
		String greet;
		if(hour >=4 && hour < 12) greet = "Good Morning";
		else if(hour>=12 && hour<16) greet = "Good Afternoon";
		else if(hour>=16 && hour<22) greet = "Good Evening";
		else greet = "Good Night";
		
		JspWriter out = getJspContext().getOut();
		out.print("<span style=\"padding:10px; background-color:red; color:white;\">Hi User! "+greet+"</span>");
		
	}
}
