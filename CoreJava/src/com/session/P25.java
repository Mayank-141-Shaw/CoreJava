package com.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class P25 {

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

			
			// Count total no. of emps
			System.out.println("\nCount total no. of emps");
			String selectQuery = "select count(*) as total_emp from emp;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Total Emps\n------------");
			while(rs.next()) {
				System.out.println(rs.getInt("total_emp"));
			}
			rs.close();
			
			
			// Count dept wise total emps
			System.out.println("\nCount dept wise total emps");
			selectQuery = "select deptno, count(*) as dep_wise_count from emp\r\n"
					+ "group by deptno order by deptno;";
			rs = st.executeQuery(selectQuery);
			System.out.println("DeptNo\t | Dept_Wise_Count\n------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("deptno")+"\t| "+rs.getInt("dep_wise_count"));
			}
			rs.close();
			
			
			// Display min salary of emps
			System.out.println("\nDisplay min salary of emps");
			selectQuery = "select ename, min(sal) as min_sal from emp;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Ename\t| Min_Salary\n--------------------");
			while(rs.next()) {
				System.out.println(rs.getString("ename")+"\t| "+rs.getInt("min_sal"));
			}
			rs.close();
			
			
			// Display the max salary of each dept
			System.out.println("\nDisplay the max salary of each dept");
			selectQuery = "select deptno, max(sal) as max_sal from emp\r\n"
					+ "group by deptno order by deptno;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Deptno\t| Max Salary\n--------------------");
			while(rs.next()) {
				System.out.println(rs.getString("deptno")+"\t| "+rs.getInt("max_sal"));
			}
			rs.close();
			
			
			// Count people have salary > 2000
			System.out.println("\nCount people have salary > 2000");
			selectQuery = "select count(*) as people_count from emp where sal>2000;";
			rs = st.executeQuery(selectQuery);
			System.out.println("People With Salary > 2000\n-----------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("people_count"));
			}
			rs.close();
			
			
			// Count people from each dept have salary < 3000
			System.out.println("\nCount people from each dept have salary < 3000");
			selectQuery = "select deptno, count(*) as ct from emp where sal < 3000 "
					+ "group by deptno order by deptno;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Deptno\t| Count\n---------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("deptno")+"\t| "+rs.getInt("ct"));
			}
			rs.close();
			
			
			// Display dept has < 3 people
			System.out.println("\nDisplay dept has < 3 people");
			selectQuery = "select deptno, count(*) as ct from emp group by deptno having count(*) < 3 order by deptno;";
			rs = st.executeQuery(selectQuery);
			// check if cursor if before the first row 
			// if its not then the first row does not exist and resultset is empty
			if(rs.isBeforeFirst()) {
				System.out.println("Deptno\t| Count\n---------------------");
				while(rs.next()) {
					System.out.println(rs.getInt("deptno")+"\t| "+rs.getInt("ct"));
				}
			}else {
				System.out.println("No rows to show");
			}
			
			rs.close();
			
			
			
			// Display deptno where dept's max(sal) > 3000
			System.out.println("\nDisplay deptno where dept's max(sal) > 3000");
			selectQuery = "select deptno, max(sal) as max_sal from emp \r\n"
					+ "group by deptno having max(sal) > 3000 order by deptno;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Deptno\t| Max Salary\n---------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("deptno")+"\t| "+rs.getInt("max_sal"));
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
