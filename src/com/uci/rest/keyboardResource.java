package com.uci.rest;

import com.uci.rest.model.Todo;
import com.uci.rest.model.keyboard;
import com.uci.rest.service.TodoService;
import com.uci.rest.service.keyboardService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class contains the methods that will respond to the various endpoints that you define for your RESTful API Service.
 *
 */
//todos will be the pathsegment that precedes any path segment specified by @Path on a method.
@Path("/keyboard")
public class keyboardResource {


    //This method represents an endpoint with the URL /keyboard/{id} and a GET request ( Note that {id} is a placeholder for a path parameter)
    @Path("{id}")
    @GET
    @Produces( { MediaType.APPLICATION_JSON }) //This provides only JSON responses
    public Response getTodoById(@PathParam("id") int id/* The {id} placeholder parameter is resolved */) {
        //invokes the DB method which will fetch a keyboard item object by id
        keyboard keyboard = keyboardService.getKeyboardById(id);

        //Respond with a 404 if there is no such todo_list item for the id provided
        if(keyboard == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        //Respond with a 200 OK if you have a keyboard object to return as response
        return Response.ok(keyboard).build();
    }
    
    //This method represents an endpoint with the URL /todos and a GET request.
    // Since there is no @PathParam mentioned, the /todos as a relative path and a GET request will invoke this method.
    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getAllKeyboards() {
        List<keyboard> keyboardList = keyboardService.getAllKeyboards();

        if(keyboardList == null || keyboardList.isEmpty()) {

        }

        return Response.ok(keyboardList).build();
    }
    
  //This method represents a PUT request where the id is provided as a path parameter and the request body is provided in JSON
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updateTodo(@PathParam("id") int id, keyboard keyboard) {

        // Retrieve the todo that you will need to change
        keyboard retrievedkeyboard = keyboardService.getKeyboardById(id);

        if(retrievedkeyboard == null) {
            //If not found then respond with a 404 response.
            return Response.status(Response.Status.NOT_FOUND).
                    entity("We could not find the requested resource").build();
        }

        // This is the todo_object retrieved from the json request sent.
        keyboard.setId(id);

        // if the user has provided null, then we set the retrieved values.
        // This is done so that a null value is not passed to the todo object when updating it.
        if(keyboard.getDescription() == null) {
        	keyboard.setDescription(retrievedkeyboard.getDescription());
        }

        //Same as above. We only change fields in the todo_resource when the user has entered something in a request.
        if (keyboard.getName() == null) {
        	keyboard.setName(retrievedkeyboard.getName());
        }
        
        if (keyboard.getPrice() == 0) {
        	keyboard.setPrice(retrievedkeyboard.getPrice());
        }

        //This calls the JDBC method which in turn calls the the UPDATE SQL command
        if(keyboardService.updateKeyboard(keyboard)) {

            return Response.ok().entity(keyboard).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }
    
    
    

}
