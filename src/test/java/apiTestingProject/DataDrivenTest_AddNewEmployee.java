package apiTestingProject;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DataDrivenTest_AddNewEmployee {
	
	@Test(dataProvider="empdataprovider")
	void postNewEmployees(String ename, String eage, String esal)
	{
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name", ename);
		requestParams.put("salary", eage);
		requestParams.put("age", esal);
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		Response response=httpRequest.request(Method.POST,"/create");
		
		String responseBody=response.getBody().asString();
		
		System.out.println("Response body is:" + responseBody);
		
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		Assert.assertEquals(responseBody.contains(esal), true);
		
		int statuscode =response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
		
		@DataProvider(name="empdataprovider")
		String [][] getEmpData()
		{
			String empdata[][]={{"abc125","50000","50"},{"xyz126","60000","60"},{"pqr127","70000","70"}};
			return(empdata);
		}
		
		
		
		
	}


