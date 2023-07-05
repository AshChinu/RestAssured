package RestAssuredCodes;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Check_Valid_Response
{
	// https://reqres.in/api/users/2 
	@Test
	public void getSingleUser()
	{
		RestAssured.baseURI = "https://reqres.in/api/users/2";

		// Get RequestSpecification of theRequest
		RequestSpecification reqSpc = RestAssured.given();

		// Call get Method
		Response res = reqSpc.get();

		// Get Response Code
		int statuscode = res.getStatusCode();

		// Validate Actual Status Code with Expected
		Assert.assertEquals(statuscode, 200,"Correct Status Code Received");

		String statusLine = res.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","Correct Status Line Received");	
	}

}
