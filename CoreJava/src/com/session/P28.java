package com.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

public class P28 {

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

			// Display the most senior employees? (Based on days)		
			System.out.println("\nDisplay the most senior employees? (Based on days)");
			String selectQuery = "select *, max(datediff(now(), hiredate)) as dd from emp;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Name\t| No. of days\n-----------------------");
			while(rs.next()) {
				System.out.println(rs.getString("ename")+"\t| "+rs.getInt("dd"));
			}	
			
			rs.close();
			
			
			
			// Give 5% increment to employees who are here since last 3 years?
			System.out.println("\nGive 5% increment to employees who are here since last 3 years");
			selectQuery = "select (sal*1.05) as new_sal, ename, empno from emp\r\n"
					+ "where datediff(now(), hiredate) <= (365*3);";
			rs = st.executeQuery(selectQuery);
			if(rs.isBeforeFirst()) {
				System.out.println("Name\t| New Salary\t| Emp No\n-----------------------");
				while(rs.next()) {
					System.out.println(rs.getString("ename")+"\t| "+rs.getInt("new_sal")+"\t| "+rs.getInt("empno"));
				}	
			}else {
				System.out.println("All employees are older than 3 years");
			}
			
			rs.close();
			
			
			
			// Give 7% increment to employees who are here since last 5 years and salary < 2000
			System.out.println("\nGive 7% increment to employees who are here since last 5 years and salary < 2000");
			selectQuery = "select (sal*1.07) as new_sal, ename, empno from emp\r\n"
					+ "where datediff(now(), hiredate) <= (365*5) and sal < 2000;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Name\t| New Salary\t| Emp No\n-----------------------");
			while(rs.next()) {
				System.out.println(rs.getString("ename")+"\t| "+rs.getInt("new_sal")+"\t| "+rs.getInt("empno"));
			}	
			
			rs.close();			
			
			
			
			// Display yearly report which shows year wise no. of joinings
			System.out.println("\nGive 7% increment to employees who are here since last 5 years and salary < 2000");
			selectQuery = "select *, year(hiredate) as Year, count(*) as no_of_joinings from emp\r\n"
					+ "group by year(hiredate);";
			rs = st.executeQuery(selectQuery);
			System.out.println("Year\t| No. of Joinings\n-----------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("Year")+"\t| "+rs.getInt("no_of_joinings"));
			}	
			
			rs.close();						
			
			
			// Display monthly report which shows month wise no. of joinings
			String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", 
						"September", "October", "November", "December"};
			
			System.out.println("\nGive 7% increment to employees who are here since last 5 years and salary < 2000");
			selectQuery = "select year(hiredate) as y, month(hiredate) as mt, count(*) as ct\r\n"
					+ "from emp group by y,mt order by y, mt;";
			rs = st.executeQuery(selectQuery);
			System.out.println("Year\t| Month\t| No. of Joinings\n-----------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("y")+"\t| "+months[rs.getInt("mt") - 1]+"\t| "+rs.getInt("ct"));
			}	
			
			rs.close();			
			
			
			// Create a seperate table from existing emp table for emps who have recently joined (i.e. last year)
			System.out.println("\nCreate a seperate table from existing emp table for emps who have recently joined (i.e. last year)");
			selectQuery = "insert into emp_recent\r\n"
					+ "select * from emp\r\n"
					+ "where datediff(now(), hiredate) <= 365; ";
			if(st.executeUpdate(selectQuery)==1)
				System.out.println("Inserted Successfully");
			else
				System.out.println("No rows to insert");
			
			
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
