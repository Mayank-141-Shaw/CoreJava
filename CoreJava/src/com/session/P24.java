package com.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class P24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String Driver = "com.mysql.cj.jdbc.Driver";
		final String DB_url = "jdbc:mysql://localhost:3306/mydb";
		final String DB_user = "root";
		final String DB_password = "@Mayank99";
		
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		
		try {
			
			// register the driver
			Class.forName(Driver);
			System.out.println("Driver Loaded");
			
			// get connection
			con = DriverManager.getConnection(DB_url, DB_user, DB_password);
			System.out.println("Connected");
			
			

			// use statement object to perform queries
			st = con.createStatement();

			
			
			// Increment sal by 7% who is a manager and display records in descending of sal
			System.out.println("\nSalary of clerks 5% decremented");
			String selectQuery = "select (1.07*sal) as new_sal from emp\r\n"
					+ "where job='manager'\r\n"
					+ "order by new_sal desc;";
			rs = st.executeQuery(selectQuery);
			System.out.println("New Salary\n------------");
			while(rs.next()) {
				System.out.println(rs.getInt("new_sal"));
			}
			rs.close();
						
			
			// Display eno and ename who have sal between 2000 and 3000. Display the records order by empno in ascending
			System.out.println("\nDisplay eno and ename who have sal between 2000 and 3000");
			selectQuery = "select empno, ename from emp\r\n"
					+ "where sal between 2000 and 3000 order by empno;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Empno\t| Ename\n------------");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t| "+rs.getString("ename"));
			}
			rs.close();
			
			
			// Display unique records of empno and job who are from dept 10 or 20
			System.out.println("\nDisplay unique records of empno and job who are from dept 10 or 20");
			selectQuery = "select distinct empno, job from emp\r\n"
					+ "where deptno in (10, 20);";
			rs = st.executeQuery(selectQuery);
			System.out.println("Empno\t| Job\n------------");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t| "+rs.getString("job"));
			}
			rs.close();
			
			
			// Display unique jobs from emp except manager
			System.out.println("\nDisplay unique jobs from emp except manager");
			selectQuery = "select distinct job from emp\r\n"
					+ "where job!='manager';";
			rs = st.executeQuery(selectQuery);
			System.out.println("Job\n------------");
			while(rs.next()) {
				System.out.println(rs.getString("job"));
			}
			rs.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				if(con!=null)con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
