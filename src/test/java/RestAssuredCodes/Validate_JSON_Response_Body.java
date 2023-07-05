package RestAssuredCodes;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Validate_JSON_Response_Body 
{
	//https://reqres.in/api/users?page=2

	@Test
	public void userListResponseBody()
	{
		// Get RequestSpecification Reference
		RequestSpecification reqSpc = RestAssured.given();

		// Specify base URI
		reqSpc.baseUri("https://reqres.in");
		reqSpc.basePath("/api/users?page=2");

		// Create/Perform get request
		Response response = reqSpc.get();

		// Read/Print Response Body
		ResponseBody responseBody = response.getBody();
		String responseString = responseBody.asString();
		System.out.println("Response Body: "+ responseString);

		// Check the presence of George in response body
		Assert.assertEquals(responseString.contains("George"),true,"Check for presence of George");

		// Get JSON path view of response body
		JsonPath jsonPathView = responseBody.jsonPath();

		// data[4].first_name
		String firstName = jsonPathView.get("data[0].first_name");
		Assert.assertEquals(firstName, "George", "Check for Presnce of George");

	}
}
