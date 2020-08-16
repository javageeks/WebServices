package com.meensat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.meensat.model.Hotel;

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
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return hotels;
	}

}
