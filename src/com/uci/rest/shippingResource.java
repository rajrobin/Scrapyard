package com.uci.rest;

import com.uci.rest.model.Shipping;
import com.uci.rest.model.Todo;
import com.uci.rest.model.keyboard;
import com.uci.rest.service.TodoService;
import com.uci.rest.service.keyboardService;
import com.uci.rest.service.shippingService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class contains the methods that will respond to the various endpoints that you define for your RESTful API Service.
 *
 */
//todos will be the pathsegment that precedes any path segment specified by @Path on a method.
@Path("/shipping")
public class shippingResource {


    //This method represents an endpoint with the URL /keyboard/{id} and a GET request ( Note that {id} is a placeholder for a path parameter)
    @Path("{name}")
    @GET
    @Produces( { MediaType.APPLICATION_JSON }) //This provides only JSON responses
    public Response getShippingByName(@PathParam("name") String name) {
        //invokes the DB method which will fetch a keyboard item object by id
        Shipping shipping = shippingService.getShippingByName(name);

        //Respond with a 404 if there is no such todo_list item for the id provided
        if(shipping == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        //Respond with a 200 OK if you have a keyboard object to return as response
        return Response.ok(shipping).build();
    }
    
}