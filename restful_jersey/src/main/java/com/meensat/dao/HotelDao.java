package com.meensat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.meensat.model.Hotel;
import com.mysql.jdbc.PreparedStatement;

public class HotelDao {

	public static List<Hotel> getAllHotels() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		// JDBC Connection
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restful_webservices", "root", "root");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from hotel");
			System.out.println(rs.getFetchSize());
			while (rs.next()) {
				
				Hotel hotel = new Hotel();
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
				hotel.setHotelId(rs.getInt(1));
				hotel.setHotelName(rs.getString(2));
				hotels.add(hotel);
				System.out.println(hotels.toString());
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(hotels.size());
		return hotels;
	}
	
	public static boolean addHotels(Hotel hotel) {
		System.out.println(hotel);
	
		// JDBC Connection
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restful_webservices", "root", "root");

			 PreparedStatement updateemp = (PreparedStatement) con.prepareStatement("insert into hotel values(?,?)");
			      
			      updateemp.setInt(1,hotel.getHotelId());
			      updateemp.setString(2, hotel.getHotelName());
			     
			      int a =  updateemp.executeUpdate();
			
			      if(a == 0) {
			    	  result = true; 
			      }
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}
