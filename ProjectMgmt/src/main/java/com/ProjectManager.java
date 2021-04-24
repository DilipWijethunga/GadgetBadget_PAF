package com;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


	@Path("/Hello")
	public class ProjectManager {
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_PLAIN)
		
		public String hello() {
		return "Hello world.";
		}
		
		
		@GET
		@Path("/{dilip}")
		@Produces(MediaType.TEXT_PLAIN)
		public String dilip(@PathParam("dilip") String dilip) {
			
			return "Hi " + dilip;
		}
		
	}
	
