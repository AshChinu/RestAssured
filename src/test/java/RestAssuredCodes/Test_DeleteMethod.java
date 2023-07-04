package RestAssuredCodes;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_DeleteMethod
{
	@Test
	public void test05()
	{
		RestAssured.baseURI = "https://reqres.in/api/users/791";
		RestAssured.given()
		.when()
		.delete()
		.then()
        .log()
        .all()
        .statusCode(204);	
	}

}
