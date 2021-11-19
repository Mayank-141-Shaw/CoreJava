package com.servletcarapp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.servletcarapp.model.Account;
import com.servletcarapp.model.Car;

public class CarlentController {
	
	public static int addNewCarlent(int carId, int uid) throws Exception{
		int status = 0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "INSERT INTO carlents(carid, uid) values(?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, carId);
			pst.setInt(2, uid);
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
	
	public static int removeCarlent(int carId, int uid) throws Exception{
		int status = 0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "Delete from carlents where carid=? and uid=?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, carId);
			pst.setInt(2, uid);
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
		
}
