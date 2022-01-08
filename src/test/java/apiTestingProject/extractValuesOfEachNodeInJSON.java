package apiTestingProject;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class extractValuesOfEachNodeInJSON {
	@Test
	public void extractResults()
	{
	
	RestAssured.baseURI ="https://reqres.in/api/";
	
	RequestSpecification httpRequest = RestAssured.given();
	
	Response response =httpRequest.request(Method.GET,"/users?page=2");
	
	JsonPath jsonpath = response.jsonPath();
	
	System.out.println(jsonpath.get("data[0].id"));
	System.out.println(jsonpath.get("data[0].email"));
	System.out.println(jsonpath.get("data[0].first_name"));
	System.out.println(jsonpath.get("data[0].last_name"));
	
	Assert.assertEquals(jsonpath.get("data[0].email"), "michael.lawson@reqres.in");
	
	}

}
