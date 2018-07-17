package com.uci.rest.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.glassfish.jersey.client.ClientConfig;

import com.uci.rest.model.Shipping;
import com.uci.rest.model.keyboard;
import com.uci.rest.model.purchase;

public class jsonToObject {
	private static URI getBaseURI()
	{
		return UriBuilder.fromUri("http://centaurus-4.ics.uci.edu:9693/keyboardp4/").build();
		//return UriBuilder.fromUri("http://localhost:8080/pa3/").build();
	}
	
	public static keyboard getKeyboard(int id)
	{
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		String jsonResponse = target.path("v1").path("api").path("keyboard/" + id).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		keyboard kb = null;
		try {
			kb = objectMapper.readValue(jsonResponse, new TypeReference<keyboard>() {});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Name: " + kb.getName() + "\nDescription: " + kb.getDescription()  + "\nColor: " + kb.getColor());		
		return kb;
	}
	
	public static List<keyboard> getAllKeyboards()
	{
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		String jsonResponse = target.path("v1").path("api").path("keyboard").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		List<keyboard> kbs = null;
		try {
			kbs = objectMapper.readValue(jsonResponse, new TypeReference<List<keyboard>>() {});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Name: " + kb.getName() + "\nDescription: " + kb.getDescription()  + "\nColor: " + kb.getColor());
		
		return kbs;
	}
	
	public static purchase getLatestPurchase()
	{
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		String jsonResponse = target.path("v1").path("api").path("purchase").request().accept(MediaType.APPLICATION_JSON).get(String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		purchase p = null;
		try {
			p = objectMapper.readValue(jsonResponse, new TypeReference<purchase>() {});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Name: " + kb.getName() + "\nDescription: " + kb.getDescription()  + "\nColor: " + kb.getColor());		
		return p;
	}
	
	public static Shipping getShippingByName(String name)
	{
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI());
		String jsonResponse = target.path("v1").path("api").path("shipping/" + name).request().accept(MediaType.APPLICATION_JSON).get(String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		Shipping s = null;
		try {
			s = objectMapper.readValue(jsonResponse, new TypeReference<Shipping>() {});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Name: " + kb.getName() + "\nDescription: " + kb.getDescription()  + "\nColor: " + kb.getColor());		
		return s;
	}
}
