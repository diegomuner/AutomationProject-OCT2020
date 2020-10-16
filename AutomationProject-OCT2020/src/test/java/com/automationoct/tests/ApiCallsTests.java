package com.automationoct.tests;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class ApiCallsTests {

	@Test
	public void shouldReturnStatusOkay() throws UnirestException {
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
					.header("accept", "application/json").queryString("apiKey", "123").asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(jsonResponse.getBody());
		assertEquals(200, jsonResponse.getStatus());

	}

	@Test
	public void getResponseBody() {
		String body = null;
		try {
			body = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154").header("accept", "application/json")
					.queryString("apiKey", "123").asString().getBody();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(body);

	}

	@Test
	public void saveFileResponse() throws UnirestException {
		HttpResponse<String> response = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
				.header("cache-control", "no-cache").header("accept", "application/json").queryString("apiKey", "123")

				.asString();
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());

	}

}
