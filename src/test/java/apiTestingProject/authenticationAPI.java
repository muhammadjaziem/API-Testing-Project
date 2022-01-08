package apiTestingProject;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class authenticationAPI {
	@Test
	public void testAuthorize()
	{
		
	
	RestAssured.baseURI ="https://reqres.in/api/login";
	
	PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
	authscheme.setUserName("eve.holt@reqres.in");
	authscheme.setPassword("cityslicka");
	
	RestAssured.authentication=authscheme;
	
	RequestSpecification httpRequest = RestAssured.given();
	
	Response response =httpRequest.request(Method.GET,"/");
	
	String responseBody=response.getBody().asString();
	System.out.println("Response Body is:" + responseBody);
	
	int statusCode = response.getStatusCode();
	System.out.println("Status code is" + statusCode);
	Assert.assertEquals(statusCode, 200);
	}

}
