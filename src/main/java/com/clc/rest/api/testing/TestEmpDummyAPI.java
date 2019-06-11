package com.clc.rest.api.testing;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestEmpDummyAPI {

	public static void main(String[] args) throws JSONException, ClientProtocolException, IOException {

		DefaultHttpClient httpClient = new DefaultHttpClient();
	        HttpGet getRequest = new HttpGet("http://localhost:3000/user");
	        getRequest.addHeader("accept", "application/json");
	        HttpResponse response = httpClient.execute(getRequest);
	        int statusCode = response.getStatusLine().getStatusCode();
	        if (statusCode != 200)
	        {
	            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
	        }
	         
	        HttpEntity httpEntity = response.getEntity();
	        String apiOutput = EntityUtils.toString(httpEntity);
	        System.out.println(apiOutput);
		if(true)
			return;

		//Create new jsonObject and add some properties
		JsonObject newObject = new JsonObject();
		    newObject.addProperty("name", "aaaaaa");
		    newObject.addProperty("job", "bbbb");

		   RestAssured.baseURI="https://reqres.in";
		Response postResponse = 
		                RestAssured.given()
		        .contentType("application/json")
		        .body(newObject.toString())
		        .when()
		        .put("/api/users/2");



		System.out.println(postResponse.getStatusCode());
		System.out.println(postResponse.asString());


		
	}
	
	
}
