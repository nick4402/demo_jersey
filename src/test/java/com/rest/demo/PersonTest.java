package com.rest.demo;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	private HttpServer server;
	private WebTarget target;

	@Before
	public void setUp() throws Exception {
		server = Main.startServer();
		Client c = ClientBuilder.newClient();
		target = c.target(Main.BASE_URI);
	}

	@After
	public void tearDown() throws Exception {
		server.stop();
	}

	@Test
	public void getPersonDetail() {
		PersonValue expectedResult = new PersonValue(1, "UP1");
		PersonValue personValue = target.path("person").request().get(PersonValue.class);
		assertEquals(expectedResult.getId(), personValue.getId());
		assertEquals(expectedResult.getName(), personValue.getName());
	}
}
