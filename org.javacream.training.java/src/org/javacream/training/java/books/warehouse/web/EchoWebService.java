package org.javacream.training.java.books.warehouse.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.javacream.training.java.books.warehouse.api.Book;

@Path("echo")
public class EchoWebService {

	@GET @Path ("{message}")public String echo(@PathParam("message") String message) {
		System.out.println("Echoing message " + message);
		return message;
	}
	
	@GET @Path ("books") @Produces(MediaType.APPLICATION_JSON) public Book one() {
		System.out.println("retrieving Book");
		return new Book("ISBN", "title", 19.99, 222, true);
	}
	
}
