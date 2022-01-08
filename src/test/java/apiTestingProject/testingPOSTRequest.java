package apiTestingProject;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class testingPOSTRequest {
	
	@Test
	public void getWeatherInformation()
	{
		RestAssured.baseURI ="https://reqres.in/api/";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", "muhammad");
		requestParams.put("job", "tester");
		
		httpRequest.header("Content-Type","application/JSON");
		
		Response response =httpRequest.request(Method.POST,"/users");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);
		
		int statusCode=response.getStatusCode();
		System.out.println("status code is:" +statusCode);
		Assert.assertEquals(statusCode, 201);
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
	
	}
}
