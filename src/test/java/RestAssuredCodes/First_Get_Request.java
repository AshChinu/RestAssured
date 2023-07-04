package RestAssuredCodes;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class First_Get_Request
{
	// https://reqres.in/api/users/2 (Sample URL for Practice)	
	@Test
	void testcase01()
	{
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.asString());
		System.out.println("Status Code " +res.getStatusCode());
	}

}
