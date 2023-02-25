package code;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class POSTToken {

    String baseURI= RestAssured.baseURI="https://simple-books-api.glitch.me";

    @Test(description = "Given a baseURI When we make POST call to /api-clients Then verify if access token is available")
    void verifyAccessToken(){

        System.out.println(utils.generateBearerToken());
    }

}
