package com.jspcarapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspcarapp.bean.Account;
import com.jspcarapp.bean.Car;

public class CarController {
	
	public static int rentCar(int carId) throws Exception{
		int status = 0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "UPDATE car set lentstatus=true where carid=?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, carId);
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
	
	public static int returnCar(int carId) throws Exception{
		int status = 0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "UPDATE car set lentstatus=false where carid=?;";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, carId);
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
	
	public static ArrayList<Car> getAllCars() throws Exception{
		ArrayList<Car> cars = new ArrayList<Car>();
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "SELECT * FROM car;";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Car car = new Car();
				car.setCarid(rs.getInt("carid"));
				car.setModel(rs.getString("model"));
				car.setPrice(rs.getInt("price"));
				car.setLentStatus(rs.getBoolean("lentstatus"));
				cars.add(car);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return cars;
	}
	
	public static ArrayList<Car> getAvailableCars() throws Exception{
		ArrayList<Car> cars = new ArrayList<Car>();
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "select * from car where lentstatus=false;";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Car car = new Car();
				car.setCarid(rs.getInt("carid"));
				car.setModel(rs.getString("model"));
				car.setPrice(rs.getInt("price"));
				car.setLentStatus(rs.getBoolean("lentstatus"));
				cars.add(car);
			}
			rs.close();
			pst.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return cars;
	}
	
	
	public static ArrayList<Car> getCarsRentedByUser(int uid) {
		
		ArrayList<Car> cars = new ArrayList<Car>();
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "select * from car where carid in (select carid from carlents where uid = ?);";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, uid);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Car car = new Car();
				car.setCarid(rs.getInt("carid"));
				car.setModel(rs.getString("model"));
				car.setPrice(rs.getInt("price"));
				car.setLentStatus(rs.getBoolean("lentstatus"));
				cars.add(car);
			}
			pst.close();
			rs.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return cars;
	}

	public static int addNewCar(Car car) {
		int status = 0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "INSERT INTO car(model, price, lentstatus) values(?,?,?);";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, car.getModel());
			pst.setInt(2, car.getPrice());
			pst.setBoolean(3, false);
			status = pst.executeUpdate();
			
			pst.close();
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
		
		return status;
	}

	public static int removeCar(int carid) {
		int status = 0;
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "DELETE FROM car where carid=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, carid);
			status = pst.executeUpdate();
			
			pst.close();
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
		
		return status;
	}
	
	
}
