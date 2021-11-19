package com.session2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
	
	public static List<Student> getStudents() throws Exception{
		List<Student> students = new ArrayList<Student>();
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "SELECT * FROM mydb.student";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				students.add(new Student(rs.getInt("stid"), rs.getString("stname"), rs.getString("stcourse"), rs.getInt("marks")));
			}
			
			rs.close();
			pst.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return students;
	}
	
	public static int addStudent(Student student) throws Exception{
		int status = 0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "INSERT INTO student(stname, stcourse, marks) VALUES(?,?,?);";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, student.getStname());
			pst.setString(2, student.getStcourse());
			pst.setInt(3,  student.getMarks());
			
			status = pst.executeUpdate();
			
			pst.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return status;
	}
	
	public static int updateStudentWithId(Student student) throws Exception{
		int status = 0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "UPDATE student SET stname=?, stcourse=?, marks=? where id=?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, student.getStname());
			pst.setString(2, student.getStcourse());
			pst.setInt(3,  student.getMarks());
			pst.setInt(4, student.getStid());
			
			status = pst.executeUpdate();
			
			pst.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return status;
	}
	
	public static int deleteStudentWithId(int id) throws Exception{
		int status = 0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "DELETE from student where id=?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			
			status = pst.executeUpdate();
			
			pst.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return status;
	}
}
