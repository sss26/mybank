package com.smthasa.mybank.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.json.simple.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransactionTests {

	public static final ObjectMapper MAPPER = new ObjectMapper();

	@Test
	public void testSerialization() throws JsonProcessingException {
		Transaction t1 = new Transaction("test-id", 52, "sold xbox");
		String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(t1);
		System.out.println(json);
	}

	@Test
	public void testDeserialization() throws JsonProcessingException {
		String jsonStr = createJsonString();
		Transaction t1 = MAPPER.readValue(jsonStr, Transaction.class);
		assertEquals(t1.getId(), "test-id");
		assertTrue(t1.getAmount() == 52);
		assertNotNull(t1.getTimeStamp());
		assertEquals(t1.getReference(), "sold xbox");
	}

	@Test
	@Ignore
	public void testCarSerialization() throws JsonProcessingException {
		Car car = new Car("blue", "toyota");
		String json = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(car);
		System.out.println(json);
	}

	@Test
	@Ignore
	public void testCarDeserialization() throws JsonProcessingException {
		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		Car car = MAPPER.readValue(json, Car.class);
	}

	@Test
	@Ignore
	public void testCarDeserializationAndSerialization() throws JsonMappingException, JsonProcessingException {
		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
		Car car = MAPPER.readValue(json, Car.class);
		String result = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(car);
		System.out.println(result);
	}

	private String createJsonString() {
		JSONObject json = new JSONObject();
		json.put("id", "test-id");
		json.put("amount", 52);
		json.put("timeStamp", "1992-02-28’T’HH:mm’Z");
		json.put("reference", "sold xbox");
		return json.toJSONString();
	}

}
