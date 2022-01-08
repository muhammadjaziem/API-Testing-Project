package apiTestingProject;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class testingGETRequest {
	
	@Test
	public void getWeatherInformation()
	{
		RestAssured.baseURI ="https://reqres.in/api/";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response =httpRequest.request(Method.GET,"/users?page=2");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);
		
		int statusCode=response.getStatusCode();
		System.out.println("status code is:" +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
