Feature: Validating place APIs

@AddPlace
Scenario Outline: verify if place is Successfully added using AddPlaceAPI

Given add place payload "<name>" , "<language>" , "<address>"
When user calls "AddPlaceAPI" with "POST" http request
Then API call is success with status code 200 
And "status" in response body is "OK"
And "scope" in response body is "APP"
And Verify place_Id is created map to "<name>" using "getPlaceAPI"

Examples:
|name  |language|address          |
|AHouse|English |Word Cross Center|
#|Sou|English |Word Origin Center|

@DeletePlace
Scenario: Verify if delete place functionality is working
Given deletePlace Payload
When user calls "deletePlaceAPI" with "POST" http request
And "status" in response body is "OK"