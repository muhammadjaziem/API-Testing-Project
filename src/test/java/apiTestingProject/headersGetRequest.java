package apiTestingProject;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class headersGetRequest {
	
	@Test
	public void getRequest()
	{
		RestAssured.baseURI ="https://reqres.in/api/";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"users/2");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);
		
		Headers allheaders= response.headers();
		
		for(Header header:allheaders)
		{
			System.out.println(header.getName()+"  "+header.getValue());
		}
	}

}
