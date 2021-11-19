package com.session2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/updatestudent-p36")
public class UpdateStudentP36 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int stid = Integer.parseInt(req.getParameter("stid"));
		System.out.println("ID : "+stid);
		String stname = req.getParameter("stname");
		System.out.println("Name : "+stname);
		String stcourse = req.getParameter("stcourse");
		System.out.println("Course : "+stcourse);
		int marks = Integer.parseInt(req.getParameter("marks"));
		System.out.println("Marks : "+marks);
		
		// update this data
		Student student = new Student();
		student.setStid(stid);
		student.setStname(stname);
		student.setStcourse(stcourse);
		student.setMarks(marks);
		
		int status;
		try {
			status = StudentController.updateStudentWithId(student);
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
