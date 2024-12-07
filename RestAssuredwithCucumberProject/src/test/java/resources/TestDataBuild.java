package resources;

import java.util.Arrays;

import pojo.PojoDemo;

public class TestDataBuild {

	
	
	public  PojoDemo addplacePayload(String name, String language, String address)
	{
		 pojo.PojoDemo pd=new pojo.PojoDemo();
		pojo.Location l=new pojo.Location();
		

		l.setLat("12.2355");
		l.setLng("23.3432");
		
		pd.setAccuracy("87");
		pd.setName(name);
		pd.setPhone_number("9123456736");
		pd.setAddress(address);
		pd.setLocation(l);
		pd.setTypes(Arrays.asList("shoe park","shop"));
		pd.setWebsite("https://drive.google.com/file/d/1A3Q_HX8A_GtamXs5kpdZ_7jM8W-OajKS/view");
		pd.setLanguage(language);
		
		return pd;
		
	}
	
	
	
	public String deletePlacePayload(String placeId)
	{
		return "{\"place_id\": \""+placeId+"\"}";
	}
	
}
