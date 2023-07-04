package RestAssuredCodes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PutMethod
{
	// https://reqres.in/api/users/791
	@Test
    public void test04()
    {
    	JSONObject jsondata = new JSONObject();
    	jsondata.put("Name", "Chinu");
    	jsondata.put("Job", "Teacher");
    	
    	RestAssured.baseURI = "https://reqres.in/api/users/791";
    	RestAssured.given().header("Content-Type" , "application/json")
    	.contentType(ContentType.JSON)
    	.body(jsondata.toJSONString())
    	.when().put()
    	.then().statusCode(200)
    	.log().all();  	
    }

}
