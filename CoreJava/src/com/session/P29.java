package com.session;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

public class P29 {

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
		CallableStatement cst = null;
		
		try {
			
			// register the driver
			Class.forName(Driver);
			System.out.println("Driver Loaded");
			
			// get connection
			con = DriverManager.getConnection(DB_url, DB_user, DB_password);
			System.out.println("Connected");
			
			

			// use statement object to perform queries
			st = con.createStatement();

			//Create a procedure to Display employees experience level with company	
			System.out.println("\nCreate a procedure to Display employees experience level with company");
//			String proceduretQuery = "CREATE procedure GetExpLevel(IN Empid INT, OUT level VARCHAR(20))\r\n"
//					+ "begin\r\n"
//					+ "	declare hdt date;\r\n"
//					+ "    declare diff int;\r\n"
//					+ "    set hdt = (select hiredate from mydb.emp where empno=Empid);\r\n"
//					+ "    \r\n"
//					+ "    if hdt = null then set level = 'Emp does not exist';\r\n"
//					+ "    end if;\r\n"
//					+ "    \r\n"
//					+ "    set diff = datediff(now(), hdt);\r\n"
//					+ "    \r\n"
//					+ "    if diff > (365*4) then set level = 'Senior'; \r\n"
//					+ "    elseif diff <=(365*4) and diff > (365*2) then set level = 'Middle';\r\n"
//					+ "    else set level = 'Junior';\r\n"
//					+ "    end if;\r\n"
//					+ "end;";
//			if(st.executeUpdate(proceduretQuery)==1) System.out.println("Procedure created");
//			else System.out.println("Procedure may already exist");
//			
			// get the status for a random emp id
			int id = 7499;
			String callQuery = "{ CALL GetExpLevel(?, ?) }";
			cst = con.prepareCall(callQuery);
			cst.setInt(1, id);
			// register output parameter
			cst.registerOutParameter(2,  Types.VARCHAR);
			
			// execute the query
			cst.executeUpdate();
			
			System.out.println("Status of emp with id "+id+" is "+cst.getString(2));
			
			cst.close();
			
			
			
			// Create a function to give incremented salary value if passed Int and Percentage parameter.
			// salIncre(2000,10) --> Output 2200   (10% incremented) 
//			System.out.println("\nCreate a function to give incremented salary value if passed Int and Percentage parameter");
//			String functionQuery = "create function SalInc( salary DECIMAL(10,2), inc DECIMAL)\r\n"
//					+ "returns DECIMAL(10,2)\r\n"
//					+ "deterministic\r\n"
//					+ "begin\r\n"
//					+ "    return salary * ((100+inc)/100);\r\n"
//					+ "end;";
//			if(st.executeUpdate(functionQuery)==1) System.out.println("Procedure created");
//			else System.out.println("Procedure may already exist");
//			
			// get the status for a random emp id
			int percent = 10;
			callQuery = "select empno, ename, sal, SalInc(sal, ?) as Salary_Level from emp;";
			ps = con.prepareStatement(callQuery);
			ps.setInt(1, percent);
			// register output parameter
			rs = ps.executeQuery();
			System.out.println("Empno\t| Name\t| Salary\t| New Salary\n-------------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("empno")+"\t| "+rs.getString("ename")+"\t| "+rs.getInt("sal")+"\t| "+rs.getFloat("Salary_Level"));
			}
			
			rs.close();
			ps.close();
			
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
