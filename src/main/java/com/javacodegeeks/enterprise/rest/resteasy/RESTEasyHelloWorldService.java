package com.javacodegeeks.enterprise.rest.resteasy;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
 
@Path("/RESTEasyHelloWorld")
public class RESTEasyHelloWorldService {
	
	@GET
	@Path("/{pathParameter}")
	public Response responseMsg( @PathParam("pathParameter") String pathParameter,
			@DefaultValue("Nothing to say") @QueryParam("queryParameter") String queryParameter) {

		String response = "Hello from: " + pathParameter + " : " + queryParameter;

		return Response.status(200).entity(response).build();
	}
 
}
