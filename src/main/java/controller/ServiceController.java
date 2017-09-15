package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import business.UserClassifier;
import models.User;

@Path("/service")
public class ServiceController {

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Path("/verify")
	public Response verify(User user) {
		try {
			UserClassifier classifier = new UserClassifier();
			classifier.classify(user);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
