package com;

import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Project;

//For JSON
import com.google.gson.*;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Project")
public class ProjectService {

	Project pobj = new Project();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readProject() {

		return pobj.readProject();

	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(@FormParam("proj_name") String proj_name, 
			@FormParam("description") String description,
			@FormParam("patent_no") String patent_no, 
			@FormParam("cost") String cost) 
	{
		String output = pobj.insertProject(proj_name, description, patent_no, cost);
		return output;
	}

}
