package code;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class POSTOrderBook {

    String baseURI= RestAssured.baseURI="https://simple-books-api.glitch.me";


    @Test(description = "Given a baseURI and token When user wants to POST to /orders Then Verify Status code is 201")
    void orderBook(){

        //Order Book Call
        //Needed information: request payload, token, endpoint and header(content-type)






    }



}
