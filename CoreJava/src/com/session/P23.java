package com.session;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class P23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String DB_url = "jdbc:mysql://localhost:3306/mydb";
		final String DB_user = "root";
		final String DB_password = "@Mayank99";
		
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		PreparedStatement psl = null;
		CallableStatement cs = null;
		
		try {
			// register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");  	// driver name for mysql driver
			System.out.println("Driver Loaded");

			// creating a connection
			con = DriverManager.getConnection(DB_url, DB_user, DB_password);
			System.out.println("Connection established");
			
			
			// use statement object to perform queries
			st = con.createStatement();
			
			System.out.println("\nSalary of clerks 5% decremented");
			String selectQuery = "select (sal*0.95) as new_sal from emp\r\n"
					+ "where job='clerk'";
			rs = st.executeQuery(selectQuery);
			System.out.println("New Salary\n------------");
			while(rs.next()) {
				System.out.println(rs.getInt("new_sal"));
			}
			rs.close();
			
			System.out.println();
			
			
			// Display eno and ename who have sal between 2000 and 3000?
			
			System.out.println("\nEno and Ename who have sal between 2000 and 3000");
			selectQuery = "select empno, ename from emp\r\n"
					+ "where sal between 2000 and 3000;";
			rs = st.executeQuery(selectQuery);
			System.out.println("EmpNo\t| Ename\n------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t| "+rs.getString("ename"));
			}
			rs.close();
			
			
			//Display eno and job who are from dept 10 or 20
			System.out.println("\neno and job who are from dept 10 or 20");
			selectQuery = "select empno, job from emp \r\n"
					+ "where deptno=10 || deptno=20;";
			rs = st.executeQuery(selectQuery);
			System.out.println("EmpNo\t| Job\n------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t| "+rs.getString("job"));
			}
			rs.close();
			
			
			
			
			
			// Display eno,mgr who have salary > 2000 or deptno > 10 or job is clerk
			System.out.println("\neno,mgr who have salary > 2000 or deptno > 10 or job is clerk");
			selectQuery = "select empno, mgr from emp\r\n"
					+ "where sal>2000 || deptno>10 || job='clerk';";
			rs = st.executeQuery(selectQuery);
			System.out.println("EmpNo\t| Manager\n--------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t| "+rs.getInt("mgr"));
			}
			rs.close();
			
			
			
			
			
			// Increment sal by 15% who is not reporting to any one
			System.out.println("\nIncrement sal by 15% who is not reporting to any one");
			selectQuery = "select empno, (1.15*sal) as new_sal from emp\r\n"
					+ "where mgr is null;";
			rs = st.executeQuery(selectQuery);
			System.out.println("EmpNo\t| New Salary\n--------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t| "+rs.getInt("new_sal"));
			}
			rs.close();
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
