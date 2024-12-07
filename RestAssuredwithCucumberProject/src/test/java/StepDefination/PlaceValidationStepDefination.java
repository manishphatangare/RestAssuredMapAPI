package StepDefination;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;


public class PlaceValidationStepDefination extends Utils {

	TestDataBuild demo=new TestDataBuild();
	static RequestSpecification req;
	static Response resp;
	static String place_id;


	@Given("add place payload {string} , {string} , {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
		
		 req =given().spec(requestSpecification()).body(demo.addplacePayload(name,language,address));
		 
	}
		 

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource,String method) {

		APIResources resourceAPI=APIResources.valueOf(resource);
		if(method.equalsIgnoreCase("POST"))
		{
		resp=req.when().post(resourceAPI.getResource());;
		String ResponseString = resp.asPrettyString();
		System.out.println(ResponseString);
		}
		else if(method.equalsIgnoreCase("GET"))
		{
			resp=req.when().get(resourceAPI.getResource());;
			String ResponseString = resp.asPrettyString();
			System.out.println(ResponseString);
		}
//		else if(method.equalsIgnoreCase("DELETE"))
//		{
//			resp=req.when().delete(resourceAPI.getResource());;
//			String ResponseString = resp.asPrettyString();
//			System.out.println(ResponseString);
//		}

	}

	@Then("API call is success with status code {int}")
	public void api_call_is_success_with_status_code(Integer int1) {

		Assert.assertEquals(resp.getStatusCode(), 200);
		

	}

	@And("{string} in response body is {string}")
	public void in_response_body_is(String keyValue , String ExpectedValue) {

//		String response=resp.asString();
		
		Assert.assertEquals(getJsonPath(resp,keyValue), ExpectedValue);
		
	}
	

@Then("Verify place_Id is created map to {string} using {string}")
public void verify_place_id_is_created_map_to_using(String expectedName, String resource) throws IOException {
 
	  place_id=getJsonPath(resp, "place_id");
	
	req =given().spec(requestSpecification()).queryParam("place_id", place_id);
	user_calls_with_http_request(resource,"GET");
	
	String actualName=getJsonPath(resp, "name");
	
	Assert.assertEquals(actualName, expectedName);
	
}

@Given("deletePlace Payload")
public void delete_place_payload() throws IOException {
	
	req =given().spec(requestSpecification()).body(demo.deletePlacePayload(place_id));
//	user_calls_with_http_request(resource,"GET");
}

}
