package com.meensat.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meensat.dao.HotelDao;
import com.meensat.model.Hotel;

@Path("/hotel")
public class HotelBookingService {

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllHotels() throws JsonProcessingException {
		System.out.println("-------------");
		List<Hotel> hotelList = HotelDao.getAllHotels();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(hotelList);
		 return Response
			      .status(Response.Status.OK)
			      .entity(json)
			      .header("Access-Control-Allow-Origin", "*")
			      .build();

	}

	@POST
	@Path("/addHotel")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getAllHotels(Hotel hotel) throws JsonProcessingException {
		System.out.println(hotel);
		boolean result = HotelDao.addHotels(hotel);
		if(!result) {
			 return Response
				      .status(Response.Status.EXPECTATION_FAILED)
				      .entity("Somthing wrong")
				      .header("Access-Control-Allow-Origin", "*")
				      .build();
		}else {
			 return Response
				      .status(Response.Status.CREATED)
				      .entity("ALl Good SUCESS !!")
				      .header("Access-Control-Allow-Origin", "*")
				      .build();
		}
	
		
		
	}
}
