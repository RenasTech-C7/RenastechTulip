package code;

import io.restassured.RestAssured;
import io.restassured.response.Response;
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
}
