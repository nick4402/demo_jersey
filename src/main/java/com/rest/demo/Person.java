package com.rest.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("person")
public class Person {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PersonValue getAll() {
		return new PersonValue(1, "UP1");
	}
}
