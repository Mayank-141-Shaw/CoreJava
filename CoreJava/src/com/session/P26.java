package com.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class P26 {

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

			
			// Display emp details with 7% increment who belongs to BOSTON location
			System.out.println("\nDisplay emp details with 7% increment who belongs to BOSTON location");
			String selectQuery = "select * from emp e inner join dept d\r\n"
					+ "using (deptno) where d.loc='boston' order by empno;";
			rs = st.executeQuery(selectQuery);
			if(rs.isBeforeFirst()) {
				System.out.println("Total Emps Data\n------------");
				ArrayList<String> col_names = new ArrayList<String>();
				int tot_col = rs.getMetaData().getColumnCount();
				for(int i = 1; i<=tot_col; i++) {
					col_names.add(rs.getMetaData().getColumnName(i));
				}
				col_names.forEach(e -> System.out.print(e+"\t| "));
				System.out.println();
				col_names.forEach(e -> System.out.print("------------"));
				while(rs.next()) {
					System.out.println("\n"+rs.getInt(col_names.get(0))+"\t| "+
							rs.getInt(col_names.get(1))+"\t| "+
							rs.getString(col_names.get(2))+"\t| "+
							rs.getString(col_names.get(3))+"\t| "+
							rs.getInt(col_names.get(4))+"\t| "+
							rs.getDate(col_names.get(5))+"\t| "+
							rs.getInt(col_names.get(6))+"\t| "+
							rs.getInt(col_names.get(7))+"\t| "+
							rs.getString(col_names.get(8))+"\t| "+
							rs.getString(col_names.get(9)));
				}
			}else {
				System.out.println("No employees works in Boston");
			}
			
			rs.close();
			
			
			// Count the no. of employees works for RESEARCH dept
			System.out.println("\nCount the no. of employees works for RESEARCH dept");
			selectQuery = "select count(*) as ct from emp e inner join dept d\r\n"
					+ "using (deptno) where d.dname='research';";
			rs = st.executeQuery(selectQuery);
			System.out.println("Total Count\n------------");
			while(rs.next()) {
				System.out.println(rs.getInt("ct"));
			}	
			
			rs.close();
									
			
			
			// Find out the max salary received in SALES dept
			System.out.println("\nFind out the max salary received in SALES dept");
			selectQuery = "select max(sal) as ms from emp e inner join dept d\r\n"
					+ "using (deptno) group by d.dname having d.dname='sales';";
			rs = st.executeQuery(selectQuery);
			System.out.println("Max Salary\n------------");
			while(rs.next()) {
				System.out.println(rs.getInt("ms"));
			}	
			
			rs.close();
									
			
			// Display date of joining of emp whose dept location is not available
			System.out.println("\nDisplay date of joining of emp whose dept location is not available");
			selectQuery = "select hiredate from emp e inner join dept d\r\n"
					+ "using (deptno) where d.loc is null;";
			rs = st.executeQuery(selectQuery);
			if(rs.isBeforeFirst()) {
				System.out.println("Hire Date\n------------");
				while(rs.next()) {
					System.out.println(rs.getDate("hiredate"));
				}	
			}else {
				System.out.println("No such employee exists");
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
