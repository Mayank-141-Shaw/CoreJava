package com.session2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/addstudent-p36")
public class AddStudentP36 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		String stname = req.getParameter("stname");
		System.out.println("Name : "+stname);
		String stcourse = req.getParameter("stcourse");
		System.out.println("Course : "+stcourse);
		int marks = Integer.parseInt(req.getParameter("marks"));
		System.out.println("Marks : "+marks);
		
		// update this data
		Student student = new Student();
		student.setStname(stname);
		student.setStcourse(stcourse);
		student.setMarks(marks);
		
		int status;
		try {
			status = StudentController.addStudent(student);
			req.getRequestDispatcher("homeP36.html").include(req, resp);
			if(status==1) {
				out.print("<h4>Student added successfully</h4>");
			}else {
				out.print("<h4>Something went wrong</h4>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
	}
	
}
