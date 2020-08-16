package org.restful_jersey_client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.meensat.model.Hotel;


/**
 * Hello world!
 *
 */
public class App {
	private static final String REST_URI = "http://localhost:8080/restful_jersey/rest/hotel";
	public static void main(String[] args) {
		getAllHotelsInfo();
		
		//save();
	}

	  public static List<Hotel> getAllHotelsInfo() {
		  Client client = ClientBuilder.newClient();
	        return client
	          .target(REST_URI)
	          .path("getAll")
	          .request(MediaType.APPLICATION_JSON)
	          .get(new GenericType<List<Hotel>>(){});
	    }
	
	  public static Response  save() {
		  Hotel h = new Hotel();
		  h.setHotelId(212);
		  h.setHotelName("XYZ");
		  Client client = ClientBuilder.newClient();
	        return client
	          .target(REST_URI)
	          .path("addHotel")
	          .request(MediaType.APPLICATION_JSON)
	          .post(Entity.entity(h, MediaType.APPLICATION_JSON));
	    }
}
