package com.session2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/home-p36")
public class HomeP36 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	final String DB_url = "jdbc:mysql://localhost:3306/mydb";
	final String DB_user = "root";
	final String DB_password = "@Mayank99";
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	HttpSession session;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  	// driver name for mysql driver
			System.out.println("Driver Loaded");
			
			// creating a connection
			con = DriverManager.getConnection(DB_url, DB_user, DB_password);
			System.out.println("Connection established");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String action = req.getParameter("action");
		System.out.println("Action : "+action);
		
		session = req.getSession();
		
		if(action.equals("view")) {
			// get data from Student table and display as table
			req.getRequestDispatcher("homeP36.html").include(req, resp);
			try {
				ArrayList<Student> students = (ArrayList<Student>) StudentController.getStudents();
				out.print("<table>");
				out.print("<tr><th>ID</th> <th>Name</th> <th>Course</th> <th>Marks</th></tr>");
				Iterator<Student> itr = students.iterator();
				while(itr.hasNext()) {
					Student student = itr.next();
					out.print("<tr> <td>"+student.getStid()+"</td>"
							+ "<td>"+student.getStname()+"</td> "
							+ "<td>"+student.getStcourse()+"</td> "
							+ "<td>"+student.getMarks()+"</td> "
							+ "</tr>");
				}
				out.print("</table>");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if(action.equals("add")) {
			// transfer to studentActionP36.html
			req.getRequestDispatcher("addStudentP36.html").forward(req, resp);
		}else if(action.equals("update")) {
			// transfer to studentActionP36.html
			req.getRequestDispatcher("updateStudentP36.html").forward(req, resp);
		}else if(action.equals("delete")) {
			// tansfer to studentActionP36.html
			req.getRequestDispatcher("deleteStudentP36.html").forward(req, resp);
		}else {
			// remove session data
			session.invalidate();
			// log out
			// forward back to login page
			req.getRequestDispatcher("loginP36.html").forward(req, resp);
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(con!=null)con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
