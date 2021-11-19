package com.servletcarapp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.servletcarapp.model.Account;

public class AccountController {
	
	public static int increaseCarsRented(int uid) throws SQLException {
		
		int status = 0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "UPDATE mvccaracc set carsrented=carsrented+1 where id=?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, uid);
			status = pst.executeUpdate();
			
			pst.close();
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		
		return status;
	}
	
	public static int decreaseCarsRented(int uid) throws SQLException {
		int status = 0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "UPDATE mvccaracc set carsrented=carsrented-1 where id=?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, uid);
			status = pst.executeUpdate();
			
			pst.close();
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		
		return status;	
			
	}
		
	public static Account getAccount(String uname, String pass) {
		Account acc = null;
		
		Connection con = JDBCProperties.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM mvccaracc WHERE username=? and password=?;";
			pst = con.prepareStatement(query);
			pst.setString(1, uname);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			if(rs.isBeforeFirst()) {
				rs.next();
				System.out.println("Account exists");
				acc = new Account();
				acc.setId(rs.getInt("id"));
				acc.setName(rs.getString("name"));
				acc.setAddress(rs.getString("address"));
				acc.setPhone(rs.getString("phone"));
				acc.setUsername(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				acc.setCarsRented(rs.getInt("carsrented"));
			}
			rs.close();
			pst.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return acc;
	}
	
	// for inserting new student
	public static int addNewAccount(Account acc) throws SQLException{
		Connection con = JDBCProperties.getConnection();
		PreparedStatement pst = null;
		int returnValue = 0;
		try {
			String insertQuery = "INSERT INTO mvccaracc(name, address, phone, username, password, carsrented) VALUES(?,?,?,?,?,?)";
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, acc.getName());
			pst.setString(2, acc.getAddress());
			pst.setString(3, acc.getPhone());
			pst.setString(4, acc.getUsername());
			pst.setString(5, acc.getPassword());
			pst.setInt(6, acc.getCarsRented());
			
			returnValue = pst.executeUpdate();
			pst.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pst!=null)pst.close();
			if(con!=null)con.close();
			System.out.println("Both COnnections closed");
		}
		
		return returnValue;
	}

	public static int updateAccount(Account acc) {
		Connection con = JDBCProperties.getConnection();
		PreparedStatement pst = null;
		int returnValue = 0;
		try {
			String updateQuery = "UPDATE mvccaracc set name=?, address=?, phone=?, username=?, password=? where id=?";
			pst = con.prepareStatement(updateQuery);
			pst.setString(1, acc.getName());
			pst.setString(2, acc.getAddress());
			pst.setString(3, acc.getPhone());
			pst.setString(4, acc.getUsername());
			pst.setString(5, acc.getPassword());
			pst.setInt(6, acc.getId());
			
			returnValue = pst.executeUpdate();
			pst.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Both Connections closed");
		}
		
		return returnValue;
	}
	
	
}
