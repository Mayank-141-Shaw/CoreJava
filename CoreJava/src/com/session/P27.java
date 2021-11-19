package com.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class P27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String Driver = "com.mysql.cj.jdbc.Driver";
		final String DB_url = "jdbc:mysql://localhost:3306/mydb";
		final String DB_user = "root";
		final String DB_password = "@Mayank99";
		
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		PreparedStatement ps = null;
		
		try {
			
			// register the driver
			Class.forName(Driver);
			System.out.println("Driver Loaded");
			
			// get connection
			con = DriverManager.getConnection(DB_url, DB_user, DB_password);
			System.out.println("Connected");
			
			

			// use statement object to perform queries
			st = con.createStatement();

			String createTableQuery = "CREATE TABLE IF NOT EXISTS Student_Info("+
					"rno INT AUTO_INCREMENT PRIMARY KEY,"
					+ "name VARCHAR(50) NOT NULL,"
					+ "city VARCHAR(50) NOT NULL);";
			
			System.out.println("Student Table creation : "+st.executeUpdate(createTableQuery));
			

			// create table subject 
			String createSubjectTable = "CREATE TABLE IF NOT EXISTS Subject("
					+ "sub_code INT PRIMARY KEY,"
					+ "sub_name VARCHAR(50) NOT NULL);";
			System.out.println("Subject Table creation : "+st.executeUpdate(createSubjectTable));

			
			// create table marks
			String createMarksTable = "CREATE TABLE IF NOT EXISTS Marks("
					+ "rno int,"
					+ "foreign key (rno) references Student_Info(rno),"
					+ "sub_code int,"
					+ "foreign key (sub_code) references Subject(sub_code),"
					+ "marks int);";
			System.out.println("Marks Table creation : "+st.executeUpdate(createMarksTable));
			
//			// insert some records in info table
//			String names[] = {"gautam", "balaji", "rushin"};
//			String city[] = {"jalgaon", "parbhani", "jalgaon"};
//			String insertQuery = "INSERT INTO Student_Info(name, city) VALUES(?, ?) ";
//			ps = con.prepareStatement(insertQuery);
//			for(int i=0; i<names.length; i++) {
//				ps.setString(1, names[i]);
//				ps.setString(2, city[i]);
//				ps.addBatch();
//			}
//
//			System.out.println("Records added in Student Info : "+ps.executeBatch().length);
//			ps.close();
//
//			// insert some records in subject table
//			int code[] = {100, 101};
//			String sub_name[] = {"DBMS", "SE"};
//			insertQuery = "INSERT INTO Subject(sub_code, sub_name) VALUES(?, ?) ";
//			ps = con.prepareStatement(insertQuery);
//			for(int i=0; i<code.length; i++) {
//				ps.setInt(1, code[i]);
//				ps.setString(2, sub_name[i]);
//				ps.addBatch();
//			}
//
//			System.out.println("Records added in Subject : "+ps.executeBatch().length);
//			ps.close();

			
			

//			// insert some records in marks table
//			int sub_code[] = {100, 100, 101, 101, 100, 101};
//			Integer marks[] = {80, null, 90, 78, 30, null};
//			int rno[] = {1,2,1,2,3,3};
//			String insertQuery = "INSERT INTO Marks(rno, sub_code, marks) VALUES(?, ?, ?) ";
//			ps = con.prepareStatement(insertQuery);
//			for(int i=0; i<sub_code.length; i++) {
//				ps.setInt(1, rno[i]);
//				ps.setInt(2, sub_code[i]);
//				
//				if(marks[i] == null) ps.setNull(3, java.sql.Types.NULL);
//				else ps.setInt(3, marks[i]);
//				
//				ps.addBatch();
//			}
//
//			System.out.println("Records added in Marks : "+ps.executeBatch().length);
//			ps.close();

			
			
			// Find out average marks of each student along with roll number of student
			System.out.println("\nFind out average marks of each student along with roll number of student");
			String selectQuery = "select rno, avg(marks) as avm from student_info s inner join marks m\r\n"
					+ "using (rno) group by rno ;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Roll Number| Average Marks\n---------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("rno")+"\t| "+rs.getFloat("avm"));
			}	
			
			rs.close();
			
			// Find out how many students have failed i.e. obtained less than 40 marks in DBMS
			System.out.println("\nFind out how many students have failed i.e. obtained less than 40 marks in DBMS");
			selectQuery = "select count(rno) as ct from marks m \r\n"
					+ "where m.marks < 40 and \r\n"
					+ "m.sub_code=(select sub_code from subject where sub_name='dbms');";
			rs = st.executeQuery(selectQuery);
			System.out.println("Total Failed\n---------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("ct"));
			}	
			
			rs.close();
			
			
			// Find names of Students who are absent in Exam i.e. students having null marks
			System.out.println("\nFind names of Students who are absent in Exam");
			selectQuery = "select distinct s.name from student_info s, marks m\r\n"
					+ "where m.marks is null and s.rno=m.rno;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Absentees\n---------------------");
			while(rs.next()) {
				System.out.println(rs.getString("s.name"));
			}	
			
			rs.close();
			
			
			// Find the name of students who live in either ‘pune’ or 'jalgaon’
			System.out.println("\nFind the name of students who live in either ‘pune’ or 'jalgaon’");
			selectQuery = "select name, city from student_info\r\n"
					+ "where city in ('pune', 'jalgaon');";
			rs = st.executeQuery(selectQuery);
			System.out.println("Name\t| City\n---------------------");
			while(rs.next()) {
				System.out.println(rs.getString("name")+"\t| "+rs.getString("city"));
			}	
			
			rs.close();
			
			
			// Find out roll no and total marks of each student
			System.out.println("\nFind out roll no and total marks of each student");
			selectQuery = "select rno, sum(marks) as total_marks from student_info s inner join marks m\r\n"
					+ "using (rno) group by rno; ";
			rs = st.executeQuery(selectQuery);
			System.out.println("Roll No\t| Total Marks\n---------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("rno")+"\t| "+rs.getInt("total_marks"));
			}	
			
			rs.close();
			
			// Find those student names which start with 'ba'
			System.out.println("\nFind those student names which start with 'ba'");
			selectQuery = "select * from student_info \r\n"
					+ "where name like 'ba%';";
			rs = st.executeQuery(selectQuery);
			System.out.println("Roll No\t| Name\t| City\n-----------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("rno")+"\t| "+rs.getString("name")+"\t| "+rs.getString("city"));
			}	
			
			rs.close();
			
			
			// Display total no of students having greater than 75 marks in any one subject
			System.out.println("\nDisplay total no of students having greater than 75 marks in any one subject");
			selectQuery = "select count(distinct rno) as ct from marks where marks > 75;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Total Count\n-----------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("ct"));
			}	
			
			rs.close();
			
			
			
			// Display marks of all students for DBMS subject
			System.out.println("\nDisplay marks of all students for DBMS subject");
			selectQuery = "select rno, marks from marks \r\n"
					+ "where sub_code=(select sub_code from subject where sub_name='dbms');";
			rs = st.executeQuery(selectQuery);
			System.out.println("Roll No\t| Marks\n-----------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("rno")+"\t| "+rs.getInt("marks"));
			}	
			
			rs.close();
			
			
			// Display no of students appeared for the exam
			System.out.println("\nDisplay no of students appeared for the exam");
			selectQuery = "select count(distinct rno) as ct from marks where marks is not null;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Total Students\n-----------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("ct"));
			}	
			
			rs.close();
			
			// Display all subjects marks of students whose name is gautam
			System.out.println("\nDisplay all subjects marks of students whose name is gautam");
			selectQuery = "select marks from marks where rno=(select rno from student_info where name='gautam')";
			rs = st.executeQuery(selectQuery);
			System.out.println("Gautam Marks\n-----------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("marks"));
			}	
			
			rs.close();
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
