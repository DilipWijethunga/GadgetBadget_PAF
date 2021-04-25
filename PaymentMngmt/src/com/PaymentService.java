package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON
import com.google.gson.*;

import model.Payment;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Payments")
public class PaymentService {
	Payment paymentObj = new Payment();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPayments() {
		return paymentObj.readPayments();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayments(@FormParam("cardNumber") String cardNumber, @FormParam("expireDate") String expireDate,
			@FormParam("cvv") String cvv, @FormParam("paymentAmount") String paymentAmount) {
		String output = paymentObj.insertPayments(cardNumber, expireDate, cvv, paymentAmount);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayments(String paymentData) {
//Convert the input string to a JSON object
		JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject();
//Read the values from the JSON object
		String paymentId = paymentObject.get("paymentId ").getAsString();
		String cardNumber = paymentObject.get("cardNumber").getAsString();
		String expireDate = paymentObject.get("expireDate").getAsString();
		String cvv = paymentObject.get("cvv").getAsString();
		String paymentAmount = paymentObject.get("paymentAmount").getAsString();
		String output = paymentObj.updatePayments(paymentId, cardNumber, expireDate, cvv, paymentAmount);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayments(String paymentData) {
//Convert the input string to an XML document
		Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser());

//Read the value from the element <paymentId>
		String paymentId = doc.select("paymentId").text();
		String output = paymentObj.deletePayments(paymentId);
		return output;
	}
}
