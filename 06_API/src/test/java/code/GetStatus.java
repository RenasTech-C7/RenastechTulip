package code;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetStatus {

    @Test
    public void happyPathTest(){
        //This line will help us to make the get call and save response into response object
        Response response = RestAssured.get("https://simple-books-api.glitch.me/status");

        //This line will print the whole response body
        System.out.println("Response :"+ response.asString());

        //This line will print status code of this call
        System.out.println("Status code :"+response.getStatusCode());

        //This line will print how long it took to make the call and get response
        System.out.println("Time it took to make the call"+response.getTime());

        //This will print header
        System.out.println("Content-Type :"+response.getHeader("Content-Type"));

        //This will print header
        System.out.println("Content-Length :"+response.getHeader("Content-Length"));

        //This will print header
        System.out.println("Date :"+response.getHeader("Date"));

        //A header that is not present
        System.out.println("Test Header:"+response.getHeader("test"));

        //This will print all headers
        System.out.println("All Headers :"+response.getHeaders());
    }

    @Test(description = "Given baseURI When we make the get call to /status endpoint Then Verify Status Code")
    public void ValidateStatusCode(){
        //Given - BaseURI

        //When
        Response response=RestAssured.get("https://simple-books-api.glitch.me/status");
        int actualStatusCode=response.getStatusCode();
        int expectedStatusCode= 200;

        System.out.println("Actual status code:"+actualStatusCode);
        System.out.println("Expected status code:"+expectedStatusCode);

        //Then

        Assert.assertEquals(actualStatusCode,expectedStatusCode);
    }

    @Test(description = "given BaseURI When we make the get call to /status endpoint Then Verify time of response is 2000ms ")
    public void ValidateTime(){
        //Given and When
        Response response=RestAssured.get("https://simple-books-api.glitch.me/status");

        //Then
        long actualResponseTime = response.getTime();
        int expectedResponseTime = 2000;

        Assert.assertEquals(actualResponseTime,expectedResponseTime);

    }
}
