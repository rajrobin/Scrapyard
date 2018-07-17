package com.uci.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.uci.rest.model.Shipping;
import com.uci.rest.model.Todo;
import com.uci.rest.model.keyboard;
import com.uci.rest.model.purchase;
import com.uci.rest.service.TodoService;
import com.uci.rest.service.jsonToObject;
import com.uci.rest.service.keyboardService;
import com.uci.rest.service.purchaseService;

@Path("/purchase")
public class purchaseResource {

	//This method represents an endpoint with the URL /keyboard/{id} and a GET request ( Note that {id} is a placeholder for a path parameter)
    @GET
    @Produces( { MediaType.APPLICATION_JSON }) //This provides only JSON responses
    public Response getPurchase() {
        //invokes the DB method which will fetch a keyboard item object by id
        purchase purchase = purchaseService.getLatestPurchase();

        //Respond with a 404 if there is no such todo_list item for the id provided
        if(purchase == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        //Respond with a 200 OK if you have a keyboard object to return as response
        return Response.ok(purchase).build();
    }
	
	
    //This method represents an endpoint with the URL /todos and a POST request.
    // Since there is no @PathParam mentioned, the /todos as a relative path and a POST request will invoke this method.
    @POST
    @Consumes({MediaType.APPLICATION_JSON}) //This method accepts a request of the JSON type
    public Response addTodo(Todo todo) {

        //The todo object here is automatically constructed from the json request. Jersey is so cool!
        if(TodoService.AddTodo(todo)) {
            return Response.ok().entity("TODO Added Successfully").build();
        }

        // Return an Internal Server error because something wrong happened. This should never be executed
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

    //Similar to the method above.
    @POST
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED}) //This method accepts form parameters.
    //If you were to send a POST through a form submit, this method would be called.
    public Response addPurchase(
    						@FormParam("productids") String productids,
    						@FormParam("fullname") String fullname,
                            @FormParam("email") String email,
    						@FormParam("phone") String  phone,
    						@FormParam("streetaddress") String  streetaddress,
    						@FormParam("cityname") String  cityname,
    						@FormParam("statename") String  statename,
    						@FormParam("zipcode") String  zipcode,
    						@FormParam("cardname") String cardname,
    						@FormParam("cardnumber") String cardnumber,
    						@FormParam("expmonth") String expmonth,
    						@FormParam("expyear") String  expyear,
    						@FormParam("cvv") String  cvv,
    						@FormParam("shipping") String shipping,
    						@FormParam("firstname") String firstname,
    						@FormParam("address") String address,
    						@FormParam("city") String city,
    						@FormParam("state") String state,
    						@FormParam("zip") String zip,
    						@FormParam("totalprice") String totalprice,
    						@FormParam("totalqty") String totalqty){
    	
    	Shipping shipType = jsonToObject.getShippingByName(shipping);
    	double total = shipType.getPrice() + Double.parseDouble(totalprice);
    	
        purchase purchase = new purchase();
        
        purchase.setProduct_id(Integer.parseInt(productids));
        purchase.setFull_name(fullname);
        purchase.setEmail(email);
		purchase.setPhone_number(phone);
		purchase.setStreet_address(streetaddress);
		purchase.setCity(cityname);
		purchase.setState(statename);
		purchase.setZip(zipcode);
		purchase.setCardholder_name(cardname);
		purchase.setCard_number(cardnumber);
		purchase.setCard_exp_month(expmonth);
		purchase.setCard_exp_year(expyear); 
		purchase.setCvv(cvv);
		purchase.setQuantity(Integer.parseInt(totalqty));
		purchase.setShipping(shipping);
		purchase.setShipping_name(firstname);
		purchase.setShipping_street(address);
		purchase.setShipping_city(city);
		purchase.setShipping_state(state);
		purchase.setShipping_zip(zip);
		purchase.setTotal_price(Double.toString(total));
        

        System.out.println(purchase);

        if(purchaseService.AddPurchase(purchase)) {
        	purchase receipt = jsonToObject.getLatestPurchase();
        	
        	String receiptString = "Thank you for your purchase!<br>" +
        			"Name: " + receipt.getFull_name() +
        			"<br>Email: " + receipt.getEmail() +
        			"<br>Phone: " + receipt.getPhone_number() +
        			"<br>Street: " + receipt.getStreet_address() +
        			"<br>City: " + receipt.getCity() +
        			"<br>State: " + receipt.getState() +
        			"<br>ZipCode: " + receipt.getZip() +
        			"<br>Cardholder Name: " + receipt.getCardholder_name() +
        			"<br>Card Number: " + receipt.getPhone_number() +
        			"<br>Expiration Month: " + receipt.getCard_exp_month() +
        			"<br>Expiration Year: " + receipt.getCard_exp_year() +
        			"<br>CVV: " + receipt.getCvv() +
        			"<br>Shipping: " + receipt.getShipping() +
        			"<br>Name: " + receipt.getShipping_name() +
        			"<br>Shipping Address: " + receipt.getShipping_street() +
        			"<br>Shipping City: " + receipt.getShipping_city() +
        			"<br>Shipping State: " + receipt.getShipping_state() +
        			"<br>Shipping Zip: " + receipt.getShipping_zip() +
        			"<br>Quantity: " + receipt.getQuantity() +
        			"<br>Total Price: " + receipt.getTotal_price();
        	
        	
            return Response.ok().entity(receiptString).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }
    
    
    
  //This method represents a DELETE request where the id is provided as a path parameter and the request body is provided in JSON
    @DELETE
    @Path("delete")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    public Response deleteTodo() {

        //Retrieve the todo_object that you want to delete.
        purchase retrievedpurchase = purchaseService.getLatestPurchase();

        if(retrievedpurchase == null) {
            //If not found throw a 404
            return Response.status(Response.Status.NOT_FOUND).
                    entity("We could not find the requested resource").build();
        }

        // This calls the JDBC method which in turn calls the DELETE SQL command.
        if(purchaseService.deletePurchase()) {
            return Response.ok().entity("The most recent order has been deleted.").build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

}
