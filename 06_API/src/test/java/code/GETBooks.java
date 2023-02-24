package code;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GETBooks {
    String URL="https://simple-books-api.glitch.me/books";


    @Test(description = "Give a baseURI When we make GET call to /books Then Verify status code is 200 ")
    public void ValidateStatusCode(){
        //Given and When
        //Here we provided baseURI and endpoint
        Response response= RestAssured.get(URL);
        int actualStatusCode=response.getStatusCode();
        int expectedStatusCode=200;

        System.out.println(response.getBody().asString());

        //Then
        Assert.assertEquals(actualStatusCode,expectedStatusCode);
    }

    @Test(description = "Given a baseURI when we make a GET call to /books and use query param limit=2 Then verify status code")
    void userRetrieveListofTheBooksLimit2(){

        //Given
        //We are building request here so we need to provide parameters, body etc here.
        RequestSpecification request= given().queryParam("limit", 2);

        //Here we are making the API call
        Response response= request.when().get(URL);

        //Then
        response.then().assertThat().statusCode(200);

    }

}
