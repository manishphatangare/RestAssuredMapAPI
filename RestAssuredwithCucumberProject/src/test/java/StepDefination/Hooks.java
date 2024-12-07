package StepDefination;

import java.io.IOException;

import io.cucumber.java.Before;
import io.cucumber.plugin.event.StepDefinedEvent;

public class Hooks {

	
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		PlaceValidationStepDefination stepDefination=new PlaceValidationStepDefination();
		
		if(stepDefination.place_id==null)
		{
		stepDefination.add_place_payload("shetty", "English", "Word cross center");
		stepDefination.user_calls_with_http_request("AddPlaceAPI", "POST");
		stepDefination.verify_place_id_is_created_map_to_using("shetty", "getPlaceAPI");
		}
	}
	
}
