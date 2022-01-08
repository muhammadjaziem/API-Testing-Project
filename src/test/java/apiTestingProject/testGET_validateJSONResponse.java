package apiTestingProject;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class testGET_validateJSONResponse {
	
	@Test
	public void GetWeatherDetails()
	{
		RestAssured.baseURI ="https://reqres.in/api/";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response =httpRequest.request(Method.GET,"/users?page=2");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);
		
		Assert.assertEquals(responseBody.contains("michael.lawson"),true);
	}

}
