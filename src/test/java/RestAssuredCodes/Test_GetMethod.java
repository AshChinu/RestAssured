package RestAssuredCodes;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

@Test
public class Test_GetMethod 
{
	// https://reqres.in/api/users?page=2 (Sample URL for Practice)	
     
	 public void test01()
	 {
		 Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		 System.out.println("Response Code-"+ res.getStatusCode());
		 System.out.println("Response Body-"+ res.getBody().asPrettyString());
		 System.out.println("Response Time-"+ res.getTime());
		 System.out.println("Response Header-"+ res.getHeader("Content-Type"));
		 
		 // Validate Status Code Expected-200
		 int actStatusCode = res.getStatusCode();
		 int expStatusCode = 200;
		 
		 Assert.assertEquals(actStatusCode, expStatusCode);	 
	 }
	 
	 @Test
	 public void test02()
	 {
		// Using Gherkin (Given, when & then)
		 RestAssured.baseURI = "https://reqres.in/api/users";
		 RestAssured.given()
		 .queryParam("page", "2")
		 .when().get()
		 .then().statusCode(200);	 
	 }
}
