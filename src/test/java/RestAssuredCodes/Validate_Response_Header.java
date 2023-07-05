package RestAssuredCodes;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Validate_Response_Header
{      // https://reqres.in/api/users/2

	@Test
	public void getSingleUser()
	{
		// Get Request Specification
		RequestSpecification reqSpc = RestAssured.given();

		// Specify Base URI
		reqSpc.baseUri("https://reqres.in");
		reqSpc.basePath("/api/users/2");

		// Create Get Request
		Response response = reqSpc.get();

		// Validate Headers
		String contentType = response.getHeader("Content-Type");
		System.out.println("Content Type: "+contentType);

		String connection = response.getHeader("Connection");
		System.out.println("Connection: "+connection);

		// Read all Headers attributes/keys and print values
		Headers headersList = response.getHeaders();
		for (Header header:headersList)
		{
			System.out.println(header.getName()+" : " +header.getValue());
		}

		// Validate Content-Type. Expected Value:(application/json; charset=utf-8)

		Assert.assertEquals(contentType, "application/json; charset=utf-8","Header Content Type Mismatch");
	}

}
